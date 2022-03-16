package school.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import school.domain.MajorDTO;
import school.domain.ProfessorDTO;

@Component
@Repository(value = "school.mapper.ProfpageMapper")
public interface ProfpageMapper {
	public ProfessorDTO selectOne(String profId);
	public List<MajorDTO> selectDepartment();
	public Integer profUpdate(ProfessorDTO dto);
	public Integer updatePassword(ProfessorDTO dto);
}
