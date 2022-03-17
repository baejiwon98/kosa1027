package school.service.profsubject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import school.command.ProfSubjectCommand;
import school.domain.ProfessorDTO;
import school.domain.SubjectDTO;
import school.mapper.ProfSubjectMapper;

@Service
public class ProfSubjectAutoNumsService {
	@Autowired
	ProfSubjectMapper profSubjectMapper;
	public void execute(ProfSubjectCommand profSubjectCommand, Model model) {
		List<ProfessorDTO> list = profSubjectMapper.selectProfessorNum();
		model.addAttribute("list", list);
		List<SubjectDTO> sub = profSubjectMapper.selectSubjectNum();
		model.addAttribute("sub", sub);
	}
	
}
