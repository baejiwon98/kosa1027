package springBootTest2.service.myboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.domain.MyBoardDTO;
import springBootTest2.mapper.MyBoardMapper;

@Component
@Service
public class MyBoardDetailService {
	@Autowired
	MyBoardMapper boardMapper;
	public void execute(Model model, Integer boardNum) {
		MyBoardDTO dto = boardMapper.selectOne(boardNum);
		model.addAttribute("dto", dto);
	}
}
