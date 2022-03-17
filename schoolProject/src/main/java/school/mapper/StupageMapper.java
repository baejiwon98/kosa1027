package school.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import school.domain.MajorDTO;
import school.domain.ProfessorDTO;
import school.domain.StudentDTO;

@Component
@Repository(value = "school.mapper.StupageMapper")
public interface StupageMapper {
	public String autoNum(String departmentNum);
	public List<MajorDTO> selectDepartment();
	public StudentDTO selectOne(String studentId);
	public Integer stuUpdate(StudentDTO dto);
	public Integer updatePassword(StudentDTO dto);
}
