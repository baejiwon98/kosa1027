package school.service.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import school.command.SubjectCommand;
import school.domain.SubjectDTO;
import school.mapper.SubjectMapper;

@Service
public class SubjectModifyService {
	@Autowired
	SubjectMapper subjectMapper;
	public void execute(SubjectCommand subjectCommand, Model model) {
		SubjectDTO dto = subjectMapper.selectOne(subjectCommand.getSubjectNum());		
		dto.setSubjectNum(subjectCommand.getSubjectNum());
		dto.setSubjectName(subjectCommand.getSubjectName());
		dto.setSubjectTitle(subjectCommand.getSubjectTitle());
		dto.setSubjectContent(subjectCommand.getSubjectContent());
		subjectMapper.subjectUpdate(dto);	
	}

}
