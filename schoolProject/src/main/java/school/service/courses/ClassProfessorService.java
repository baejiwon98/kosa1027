package school.service.courses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import school.domain.ProfessorDTO;
import school.mapper.MajorMapper;

@Service
public class ClassProfessorService {
	@Autowired
	MajorMapper majorMapper;
	
	public void execute(String subjectNum, Model model) {
		List<ProfessorDTO> list = majorMapper.selectProfessor(subjectNum);
		model.addAttribute("list", list);
		
	}
}
