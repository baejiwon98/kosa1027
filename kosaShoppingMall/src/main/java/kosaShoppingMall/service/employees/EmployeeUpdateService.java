package kosaShoppingMall.service.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import kosaShoppingMall.command.EmployeeCommand;
import kosaShoppingMall.domain.EmployeeDTO;
import kosaShoppingMall.mapper.EmployeeMapper;

@Component
@Service
public class EmployeeUpdateService {
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	PasswordEncoder passwordEncoder;	
	
	public String execute(EmployeeCommand employeeCommand, BindingResult result) {
		EmployeeDTO dto = employeeMapper.selectOne(employeeCommand.getEmpId());
		if(passwordEncoder.matches(employeeCommand.getEmpPw(), dto.getEmpPw())) {
			System.out.println("맞다");
			dto.setEmpAddr(employeeCommand.getEmpAddr());
			dto.setEmpId(employeeCommand.getEmpId());
			dto.setEmpName(employeeCommand.getEmpName());
			dto.setEmpPhone(employeeCommand.getEmpPhone());
			dto.setEmpEmail(employeeCommand.getEmpEmail());
			employeeMapper.employeeUpdate(dto);
			return "redirect:empList";
		}else {
			System.out.println("틀리다.");
//			model.addAttribute("err_pw","비밀번호가 틀립니다.");
			result.rejectValue("empPw", "employeeCommand.empPw", "비밀번호가 틀립니다.");
			return "thymeleaf/employee/empModify";
		}	
	}
}
