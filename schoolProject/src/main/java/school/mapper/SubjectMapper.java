package school.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import school.domain.StartEndPageDTO;
import school.domain.SubjectDTO;

@Component
@Repository(value = "school.mapper.SubjectMapper")
public interface SubjectMapper {
	public String AutoNum();
	public Integer subjectInsert(SubjectDTO dto);
	public List<SubjectDTO> selectAll(StartEndPageDTO dto);
	public SubjectDTO selectOne(String subjectNum);
	public Integer subjectUpdate(SubjectDTO dto);
	public Integer subjectDelete(String subjectNum);
	public int subjectCount();
	
}
