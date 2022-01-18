package springBootTest2.service.qna;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import springBootTest2.command.QnACommand;
import springBootTest2.domain.QnADTO;
import springBootTest2.mapper.QnAMapper;

@Component
@Service
public class QnAWriteService {
	@Autowired
	QnAMapper qnaMapper;
	public void execute(QnACommand qnaCommand, HttpServletRequest request) {
		QnADTO dto = new QnADTO();
		dto.setQnaContent(qnaCommand.getQnaContent());
		dto.setQnaSubject(qnaCommand.getQnaSubject());
		dto.setQnaRegiDate(qnaCommand.getQnaRegiDate());
		
		qnaMapper.qnaInsert(dto);
	}
}
