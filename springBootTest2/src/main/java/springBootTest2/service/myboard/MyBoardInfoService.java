package springBootTest2.service.myboard;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.domain.MemberDTO;
import springBootTest2.domain.MyBoardDTO;
import springBootTest2.mapper.MemberMapper;
import springBootTest2.mapper.MyBoardMapper;


@Component
@Service
public class MyBoardInfoService {
	@Autowired
	MyBoardMapper boardMapper;
	public void execute(Integer boardNum, Model model) {
		MyBoardDTO dto = boardMapper.selectOne(boardNum);
		model.addAttribute("dto", dto);
	}
}
