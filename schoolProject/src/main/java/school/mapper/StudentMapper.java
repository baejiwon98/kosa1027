package school.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import school.domain.MajorDTO;
import school.domain.StartEndPageDTO;
import school.domain.StudentDTO;

@Component
@Repository(value = "school.mapper.StudentMapper")
public interface StudentMapper {
	public String autoNum(String departmentNum);
	public List<MajorDTO> selectDepartment();
	public Integer studentInsert(StudentDTO dto);
	public int studentCount();
	public List<StudentDTO> selectAll(StartEndPageDTO dto);
	public StudentDTO selectOne(String studentNum);
	public Integer studentUpdate(StudentDTO dto);
	public Integer studentDelete(String studentNum);
}
