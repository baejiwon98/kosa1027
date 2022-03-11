package school.service.professor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import school.domain.MajorDTO;
import school.domain.ProfessorDTO;
import school.mapper.ProfessorMapper;

@Service
public class ProfessorInfoService {
	@Autowired
	ProfessorMapper professorMapper;
	
	public void execute(String professorNum, Model model) {
		List<MajorDTO> list = professorMapper.selectDepartment();
		model.addAttribute("list", list);
		ProfessorDTO dto = professorMapper.selectOne(professorNum);
		model.addAttribute("dto", dto);
		
	}

}
