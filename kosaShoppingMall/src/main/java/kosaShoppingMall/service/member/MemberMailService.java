package kosaShoppingMall.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.mapper.MemberMapper;

@Service
public class MemberMailService {
	@Autowired
	MemberMapper memberMapper;
	public Integer execute(String memOk, String reciver, String userId) {
		MemberDTO dto = new MemberDTO();
		dto.setMemOk(memOk);
		dto.setMemEmail(reciver);
		dto.setMemId(userId);
		return memberMapper.joinOkUpdate(dto);
	}
}
