package school.service.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import school.command.SubjectCommand;
import school.mapper.SubjectMapper;

@Service
public class SubjectAutoNumService {
	@Autowired
	SubjectMapper subjectMapper;
	public void execute(SubjectCommand subjectCommand, Model model) {
		String subjectNumber = subjectMapper.AutoNum();
		subjectCommand.setSubjectNum(subjectNumber);
	}
}
