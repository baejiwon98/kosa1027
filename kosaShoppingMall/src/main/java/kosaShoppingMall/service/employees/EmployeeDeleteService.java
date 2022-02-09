package kosaShoppingMall.service.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.command.EmployeeCommand;
import kosaShoppingMall.domain.EmployeeDTO;
import kosaShoppingMall.mapper.EmployeeMapper;


@Component
@Service
public class EmployeeDeleteService {
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public void execute(EmployeeCommand employeeCommand, Model model) {
		String empPw = employeeCommand.getEmpPw();
		EmployeeDTO dto = employeeMapper.selectOne(employeeCommand.getEmpId());
		if(passwordEncoder.matches(empPw, dto.getEmpPw())) {
			System.out.println("맞다");
			Integer i = employeeMapper.empDelete(employeeCommand.getEmpId());
			model.addAttribute("Id", i);
			
		} else { 
			/*
			 * System.out.println("틀리다."); model.addAttribute("employeeCommand", dto);
			 * model.addAttribute("err_pw","비밀번호가 일치하지 않습니다."); path =
			 * "thymeleaf/employee/empDetail";
			 */
			model.addAttribute("Id", 0);
		}
	}

}