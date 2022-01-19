package springBootTest2.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import springBootTest2.domain.BoardDTO;
import springBootTest2.domain.LibDTO;

@Component
@Repository(value = "springBootTest2.mapper.LibMapper")
public interface LibMapper {
	public Integer libInsert(LibDTO dto);
	public List<LibDTO> selectAll();
	public LibDTO selectOne(Integer libNum);
	public Integer libUpdate(LibDTO dto);
	public Integer libDelete(Integer libNum);
	
}
