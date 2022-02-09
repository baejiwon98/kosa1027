package kosaShoppingMall.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kosaShoppingMall.domain.EmployeeDTO;

@Component
@Repository(value = "kosaShoppingMall.mapper.EmployeeMapper")
public interface EmployeeMapper {
	public Integer employeeInsert(EmployeeDTO dto);
	public List<EmployeeDTO> selectAll();
	public EmployeeDTO selectOne(String empId);
	public Integer employeeUpdate(EmployeeDTO dto);
	public Integer empDelete(String empId);
	public Integer empDels(String[] deletes);
}
