package kosaShoppingMall.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kosaShoppingMall.domain.EmployeeDTO;

@Component
@Repository(value = "kosaShoppingMall.mapper.EmpshipMapper")
public interface EmpshipMapper {
	public EmployeeDTO selectOne(String empId);
	public Integer employeeUpdate(EmployeeDTO dto);
	public Integer updatePassword(EmployeeDTO dto);
}
