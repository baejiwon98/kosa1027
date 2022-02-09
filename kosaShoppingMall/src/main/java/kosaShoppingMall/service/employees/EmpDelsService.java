package kosaShoppingMall.service.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.mapper.EmployeeMapper;

@Service
public class EmpDelsService {
	@Autowired
	EmployeeMapper employeeMapper;
	public void execute(String [] deletes) {
		employeeMapper.empDels(deletes);
	}
}
