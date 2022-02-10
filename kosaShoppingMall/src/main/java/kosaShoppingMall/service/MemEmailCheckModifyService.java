package kosaShoppingMall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.command.MemberCommand;
import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.mapper.LoginMapper;

@Service
public class MemEmailCheckModifyService {
	@Autowired
	LoginMapper loginMapper;
	public Integer execute(MemberCommand memberCommand) {
		AuthInfo authInfo = loginMapper.findId(memberCommand.getMemEmail());
		if(authInfo != null) {
			if(authInfo.getUserId().equals(memberCommand.getMemId())) {
				return 0;
			}
			else {
				return 1;
			}
		}else {
			return 0;
		}
	}
}
