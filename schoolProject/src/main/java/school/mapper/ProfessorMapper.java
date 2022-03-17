package school.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import school.domain.AuthInfo;
import school.domain.MajorDTO;
import school.domain.ProfessorDTO;
import school.domain.StartEndPageDTO;
import school.domain.SubjectDTO;

@Component
@Repository(value = "school.mapper.ProfessorMapper")
public interface ProfessorMapper {
	public String autoNum();
	public List<MajorDTO> selectDepartment();
	public Integer professorInsert(ProfessorDTO dto);
	public int professorCount();
	public List<ProfessorDTO> selectAll(StartEndPageDTO dto);
	public ProfessorDTO selectOne(String professorNum);
	public Integer professorUpdate(ProfessorDTO dto);
	public Integer professorDelete(String professorNum);
	
}
