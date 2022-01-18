package springBootTest2.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import springBootTest2.domain.BoardDTO;
import springBootTest2.mapper.BoardMapper;

@Component
@Service
public class BoardInfoService {
	@Autowired
	BoardMapper boardMapper;
	public void execute(HttpServletRequest request) {
		Integer num = Integer.parseInt(request.getParameter("num"));
		
		BoardDTO dto = boardMapper.selectOne(num);
		request.setAttribute("dto", dto);
	}
}
