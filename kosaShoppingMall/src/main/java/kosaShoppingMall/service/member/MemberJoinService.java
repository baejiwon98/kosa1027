package kosaShoppingMall.service.member;

import java.util.HashMap;
import java.util.UUID;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import kosaShoppingMall.command.MemberCommand;
import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.mapper.MembershipMapper;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Component
@Service
public class MemberJoinService {
	@Autowired
	MembershipMapper membershipMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	JavaMailSender mailSender;
	
	public void execute(MemberCommand memberCommand, BindingResult result, Model model) {
		String memPw = passwordEncoder.encode(memberCommand.getMemPw());
		MemberDTO dto = new MemberDTO();
		dto.setMemNum(membershipMapper.numberGenerate());
		dto.setMemAddr(memberCommand.getMemAddr());
		dto.setMemBirth(memberCommand.getMemBirth());
		dto.setMemEmail(memberCommand.getMemEmail());
		dto.setMemGender(memberCommand.getMemGender());
		dto.setMemId(memberCommand.getMemId());
		dto.setMemName(memberCommand.getMemName());
		dto.setMemPhone(memberCommand.getMemPhone());
		dto.setMemPw(memPw);
		
		membershipMapper.memberJoin(dto);
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
		
		// SMS
		String api_key = "NCSW6VCZXODXGPOX";
	    String api_secret = "UZMGJ9ADCK2LCTIEWQRITSVRXW3J0B3T";
		
		Message coolsms = new Message(api_key, api_secret); 
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to", memberCommand.getMemPhone()); //수신번호
		params.put("from", "01071461970"); //발신번호
		content = "안녕하세요를레히오\n"
				+ memberCommand.getMemName() + "님 가입을 환영합니당";
		if(content.length() > 80) {
			params.put("type", "LMS");
		}else {
			params.put("type", "SMS");
		}
		params.put("text", content);
		params.put("app_version", "JAVA SDK v2.2");
		try {
			JSONObject obj = (JSONObject) coolsms.send(params);
			System.out.println(obj.toString());
		} catch (CoolsmsException e) {
			e.printStackTrace();
		}
	}
}
