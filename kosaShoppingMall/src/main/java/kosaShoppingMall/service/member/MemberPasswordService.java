package kosaShoppingMall.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.mapper.MembershipMapper;

@Component
@Service
public class MemberPasswordService {
	@Autowired
	MembershipMapper membershipMapper;
	public void execute(String memId, String memPw) {
		MemberDTO dto = new MemberDTO();
		dto.setMemId(memId);
		dto.setMemPw(memPw);
		membershipMapper.updatePassword(dto);
	} 
}
