package kosaShoppingMall.service.member;

import java.util.UUID;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.command.MemberCommand;
import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.mapper.MemberMapper;

@Component
@Service
public class MemberWriteService {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	JavaMailSender mailSender;
	
	public void execute(MemberCommand memberCommand, Model model) {
		String memPw = passwordEncoder.encode(memberCommand.getMemPw());
		MemberDTO dto = new MemberDTO();
		dto.setMemNum(memberMapper.numberGenerate());
		dto.setMemAddr(memberCommand.getMemAddr());
		dto.setMemBirth(memberCommand.getMemBirth());
		dto.setMemEmail(memberCommand.getMemEmail());
		dto.setMemGender(memberCommand.getMemGender());
		dto.setMemId(memberCommand.getMemId());
		dto.setMemName(memberCommand.getMemName());
		dto.setMemPhone(memberCommand.getMemPhone());
		dto.setMemPw(memPw);
		dto.setMemRegiDate(memberCommand.getMemRegiDate());
		
		memberMapper.memberInsert(dto);
		model.addAttribute("memName", dto.getMemName());
		
		//메일 보내기
				String num = UUID.randomUUID().toString().substring(0,10);
				MimeMessage msg = mailSender.createMimeMessage();
				String content = "<html><body>"
							+ "안녕하세용 헤헤헤헤헤헤 로그인해주세용<br />"
							+ memberCommand.getMemName()+"님 가입을 환영합니다<br />"
							+ "<a href='http://localhost:8080/register/memberMail?"
							+ "num="+ num +"&reciver="+ memberCommand.getMemEmail() 
							+ "&userId="+ memberCommand.getMemId() +"'>"
							+ "<strong><b>가입을 완료하시려면 여기를 눌러주세요.</b></strong></a>"
							+ "</body></html>";
				String subject = "가입인사입니다";
				try {
					msg.setHeader("content-type", "text/html; charset=UTF-8");
					msg.setContent(content, "text/html; charset=UTF-8");
					msg.setSubject(subject);
					msg.setFrom(new InternetAddress("sender@gmail.com")); //보내는 사람
					msg.setRecipient(MimeMessage.RecipientType.TO,
							new InternetAddress(memberCommand.getMemEmail())); // 받는 사람
					mailSender.send(msg);
				}catch (Exception e) {
					e.printStackTrace();
				}
	}
}
