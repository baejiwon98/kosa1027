package kosaShoppingMall.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import kosaShoppingMall.command.MemberCommand;
import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.mapper.MembershipMapper;

@Component
@Service
public class MemberJoinService {
	@Autowired
	MembershipMapper membershipMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public void execute(MemberCommand memberCommand, BindingResult result) {
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
	}
}
