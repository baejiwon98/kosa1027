package school.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import school.domain.MajorDTO;

@Component
@Repository(value = "school.mapper.MajorMapper")
public interface MajorMapper {
	public Integer majorInsert(MajorDTO dto);
	public String autoNum();
	public List<MajorDTO> selectAll();
	public MajorDTO selectOne(String departmentNum);
	public Integer majorUpdate(MajorDTO dto);
	public Integer majorDelete(String departmentNum);
}
