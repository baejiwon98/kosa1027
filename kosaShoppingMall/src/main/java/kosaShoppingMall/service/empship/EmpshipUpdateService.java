package kosaShoppingMall.service.empship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import kosaShoppingMall.command.EmployeeCommand;
import kosaShoppingMall.domain.EmployeeDTO;
import kosaShoppingMall.mapper.EmpshipMapper;

@Component
@Service
public class EmpshipUpdateService {
	@Autowired
	EmpshipMapper empshipMapper;
	public void execute(EmployeeCommand employeeCommand) {
		EmployeeDTO dto = empshipMapper.selectOne(employeeCommand.getEmpId());
		dto.setEmpAddr(employeeCommand.getEmpAddr());
		dto.setEmpId(employeeCommand.getEmpId());
		dto.setEmpName(employeeCommand.getEmpName());
		dto.setEmpPhone(employeeCommand.getEmpPhone());
		dto.setEmpId(employeeCommand.getEmpEmail());
		
		empshipMapper.employeeUpdate(dto);
	}
}
