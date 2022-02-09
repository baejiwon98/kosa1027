package kosaShoppingMall.service.empship;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.EmployeeDTO;
import kosaShoppingMall.mapper.EmpshipMapper;

@Component
@Service
public class EmpshipInfoService {
	@Autowired
	EmpshipMapper empshipMapper;
	public void execute(Model model, HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String empId = authInfo.getUserId();
		EmployeeDTO dto = empshipMapper.selectOne(empId);
		model.addAttribute("employeeCommand", dto);
	}
}
