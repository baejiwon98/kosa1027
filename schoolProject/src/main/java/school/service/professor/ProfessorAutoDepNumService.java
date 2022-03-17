package school.service.professor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import school.domain.MajorDTO;
import school.mapper.ProfessorMapper;

@Service
public class ProfessorAutoDepNumService {
	@Autowired
	ProfessorMapper professorMapper;
	
	public void execute(Model model) {
		List<MajorDTO> list = professorMapper.selectDepartment();
		model.addAttribute("list", list);
	}
}
