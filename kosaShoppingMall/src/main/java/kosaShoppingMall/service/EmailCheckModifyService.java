package kosaShoppingMall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.command.EmployeeCommand;
import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.mapper.LoginMapper;

@Service
public class EmailCheckModifyService {
	@Autowired
	LoginMapper loginMapper;
	public Integer execute(EmployeeCommand employeeCommand) {
		AuthInfo authInfo = loginMapper.findId(employeeCommand.getEmpEmail());
		System.out.println(employeeCommand.getEmpId());
		if(authInfo != null) {
			if(authInfo.getUserId().equals(employeeCommand.getEmpId())) {
				return 0; // 사용가능한 이메일
			}
			else {
				return 1; // 불가능한 아이디
			}
		}else {
			return 0; // 사용가능한 이메일
		}
		
	}
}
