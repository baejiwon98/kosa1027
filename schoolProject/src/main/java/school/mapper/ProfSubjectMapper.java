package school.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import school.domain.ProfSubjectDTO;
import school.domain.ProfessorDTO;
import school.domain.StartEndPageDTO;
import school.domain.SubjectDTO;

@Component
@Repository(value = "school.mapper.ProfSubjectMapper")
public interface ProfSubjectMapper {
	public List<ProfessorDTO> selectProfessorNum();
	public List<SubjectDTO> selectSubjectNum();
	public Integer profSubjInsert(ProfSubjectDTO dto);
	public int profSubjCount();
	public List<ProfSubjectDTO> selectAll(StartEndPageDTO dto);
	public Integer profSubjDels(List<String[]> condition);

}
