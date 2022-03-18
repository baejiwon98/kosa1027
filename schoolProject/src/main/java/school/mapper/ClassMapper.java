package school.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import school.domain.CourseDTO;
import school.domain.ProfSubjectDTO;
import school.domain.StartEndPageDTO;

@Component
@Repository(value = "school.mapper.ClassMapper")
public interface ClassMapper {
	public Integer classInsert(CourseDTO dto);
	public List<CourseDTO> selectAll(String studentNum);
	public Integer classWishCancels(List<String[]> condition);
}
