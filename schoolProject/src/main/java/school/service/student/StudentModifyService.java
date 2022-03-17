package school.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import school.command.StudentCommand;
import school.domain.StudentDTO;
import school.mapper.StudentMapper;

@Service
public class StudentModifyService {
	@Autowired
	StudentMapper studentMapper;
	
	public void execute(StudentCommand studentCommand, Model model) {
		StudentDTO dto = new StudentDTO();
		dto.setStudentNum(studentMapper.autoNum(studentCommand.getDepartmentNum()));
		dto.setDepartmentNum(studentCommand.getDepartmentNum());
		dto.setStudentId(studentCommand.getStudentId());
		dto.setStudentName(studentCommand.getStudentName());		
		dto.setStudentPhone(studentCommand.getStudentPhone());
		dto.setStudentEmail(studentCommand.getStudentEmail());
		
		studentMapper.studentUpdate(dto);
		
	}

}
