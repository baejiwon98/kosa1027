package kosaShoppingMall.service.empship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import kosaShoppingMall.domain.EmployeeDTO;
import kosaShoppingMall.mapper.EmpshipMapper;

@Component
@Service
public class EmpPasswordService {
	@Autowired
	EmpshipMapper empshipMapper;
	public void execute(String empId, String empPw) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpId(empId);
		dto.setEmpPw(empPw);
		empshipMapper.updatePassword(dto);
	}
}
