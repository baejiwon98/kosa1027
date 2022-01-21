package springBootTest2.service.myboard;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import springBootTest2.command.MyBoardCommand;
import springBootTest2.domain.MyBoardDTO;
import springBootTest2.mapper.MyBoardMapper;

@Component
@Service
public class MyBoardModifyService {
	@Autowired
	MyBoardMapper boardMapper;
	public void execute(MyBoardCommand boardCommand,  HttpServletRequest request) {
		MyBoardDTO dto = new MyBoardDTO();
		dto.setBoardContent(boardCommand.getBoardContent());
		dto.setBoardNum(boardCommand.getBoardNum());
		dto.setBoardSubject(boardCommand.getBoardSubject());
		dto.setBoardWriter(boardCommand.getBoardWriter());
		dto.setWriterIp(request.getRemoteAddr());
		dto.setBoardDate(boardCommand.getBoardDate());
		
		boardMapper.boardUpdate(dto);
	}
}
