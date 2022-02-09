package kosaShoppingMall.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.mapper.MemberMapper;

@Service
public class MemberDelsService {
	@Autowired
	MemberMapper memberMapper;
	public void execute(String [] deletes) {
		memberMapper.memberDels(deletes);
	}
}
