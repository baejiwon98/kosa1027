package springBootTest2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import springBootTest2.mapper.BoardMapper;

@Component
@Service
public class BoardDelService {
	@Autowired
	BoardMapper boardMapper;
	public void execute(Integer boardNum) {
		boardMapper.boardDel(boardNum);
	}
}
