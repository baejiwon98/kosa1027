package school.service.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import school.command.StudentCommand;
import school.domain.MajorDTO;
import school.mapper.StudentMapper;

@Service
public class StudentAutoNumService {
	@Autowired
	StudentMapper studentMapper;
	public void execute(Model model) {
		List<MajorDTO> list = studentMapper.selectDepartment();
		model.addAttribute("list", list);
	}
}
