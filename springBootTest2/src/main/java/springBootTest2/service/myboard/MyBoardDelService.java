package springBootTest2.service.myboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import springBootTest2.domain.MyBoardDTO;
import springBootTest2.mapper.MyBoardMapper;

@Component
@Service
public class MyBoardDelService {
	@Autowired
	MyBoardMapper boardMapper;
	public void execute(Integer boardNum) {
		boardMapper.boardDel(boardNum);
	}
}
