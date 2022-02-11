package kosaShoppingMall.service.help;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import kosaShoppingMall.command.FindIdCommand;
import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.mapper.LoginMapper;

@Component
@Service
public class FindIdService {
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	LoginMapper loginMapper;
	public String execute(FindIdCommand findIdCommand, BindingResult result, Model model) {
		AuthInfo authInfo = loginMapper.findId(findIdCommand.getMemEmail());
		
		if(authInfo == null) {
			result.rejectValue("memEmail", "findIdCommand.memEmail", "이메일이 틀렸습니다.");
			return "thymeleaf/help/findId";	
		}else {
			if(authInfo.getPhone().equals(findIdCommand.getMemPhone())) {
				model.addAttribute("userId", authInfo.getUserId());
				MimeMessage msg = mailSender.createMimeMessage();
				String content = "<html><body>"
						+ "안녕하세요 야호루~ <br />'" 
						+ findIdCommand.getMemEmail() + "'님의 "
						+ "아이디는 <strong><b>["+ authInfo.getUserId() + "]</b></strong> 입니다. <br />"
						+ "까먹지마세용히히히"
						+ "</body></html>";
				String subject = "두구두두둥 당신의 아이디는 바로";
				try {
					msg.setHeader("content-type", "text/html; charset=UTF-8");
					//내용을 담아서 보냄
					msg.setContent(content, "text/html; charset=UTF-8");
					msg.setSubject(subject);
					/*
					msg.setFrom(new InternetAddress("sender@gmail.com")); //보내는 사람
					*/
					msg.setRecipient(MimeMessage.RecipientType.TO,
							new InternetAddress(findIdCommand.getMemEmail())); // 받는 사람
					mailSender.send(msg);
				}catch (MessagingException e) {
					e.printStackTrace();
				}
				
				return "thymeleaf/help/findIdOk";	
			}else {
				//result.rejectValue("memPhone", "findIdCommand.memPhone", "연락처가 틀렸습니다.");
				result.rejectValue("memPhone", "bad");
				return "thymeleaf/help/findId";	
			}
		}
	}
}
