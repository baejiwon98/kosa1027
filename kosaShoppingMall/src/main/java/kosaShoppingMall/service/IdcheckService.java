package kosaShoppingMall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.mapper.LoginMapper;

@Service
public class IdcheckService {
	@Autowired
	LoginMapper loginMapper;
	public Integer execute(String empId) {
		AuthInfo authInfo = loginMapper.loginSelect(empId);
		if(authInfo != null) {
			return 1;
		}else {
			return 0;
		}
		
	}
}
