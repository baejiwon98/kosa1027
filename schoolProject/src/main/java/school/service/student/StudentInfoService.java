package school.service.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import school.domain.MajorDTO;
import school.domain.StudentDTO;
import school.mapper.StudentMapper;

@Service
public class StudentInfoService {
	@Autowired
	StudentMapper studentMapper;
	
	public void execute(String studentNum, Model model) {
		List<MajorDTO> list = studentMapper.selectDepartment();
		model.addAttribute("list", list);
		StudentDTO dto = studentMapper.selectOne(studentNum);
		model.addAttribute("dto", dto);
		
	}

}
