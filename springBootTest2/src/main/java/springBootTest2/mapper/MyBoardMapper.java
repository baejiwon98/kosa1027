package springBootTest2.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import springBootTest2.domain.MyBoardDTO;

@Component
@Repository(value = "springBootTest2.mapper.MyBoardMapper")
public interface MyBoardMapper {
	public List<MyBoardDTO> selectAll();
	public Integer boardInsert(MyBoardDTO dto);
	public MyBoardDTO selectOne(Integer boardNum);
	public Integer boardDel(Integer boardNum);
	public Integer boardUpdate(MyBoardDTO dto);
}
