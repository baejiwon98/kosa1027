package springBootTest2.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import springBootTest2.domain.LibDTO;

@Component
@Repository(value = "springBootTest2.mapper.LibMapper")
public interface LibMapper {
	public Integer libInsert(LibDTO dto);
}
