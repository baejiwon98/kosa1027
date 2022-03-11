package school.service.professor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import school.command.ProfessorCommand;
import school.domain.MajorDTO;
import school.mapper.ProfessorMapper;

@Service
public class ProfessorAutoNumService {
	@Autowired
	ProfessorMapper professorMapper;
	public void execute(ProfessorCommand professorCommand, Model model) {
		String professorNum = professorMapper.autoNum();
		professorCommand.setProfessorNum(professorNum);
		List<MajorDTO> list = professorMapper.selectDepartment();
		model.addAttribute("list", list);
	}
}
