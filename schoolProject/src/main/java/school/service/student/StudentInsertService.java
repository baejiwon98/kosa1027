package school.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import school.command.StudentCommand;
import school.domain.StudentDTO;
import school.mapper.StudentMapper;

@Service
public class StudentInsertService {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	StudentMapper studentMapper;

	public void execute(StudentCommand studentCommand) {
		String stuPw = passwordEncoder.encode(studentCommand.getStudentPw());
		System.out.println(stuPw);
		StudentDTO dto = new StudentDTO();
		dto.setDepartmentNum(studentCommand.getDepartmentNum());
		dto.setStudentEmail(studentCommand.getStudentEmail());
		dto.setStudentId(studentCommand.getStudentId());
		dto.setStudentPw(stuPw);
		dto.setStudentPhone(studentCommand.getStudentPhone());
		dto.setStudentName(studentCommand.getStudentName());
		dto.setStudentNum(studentMapper.autoNum(studentCommand.getDepartmentNum()));
		
		studentMapper.studentInsert(dto);
		
	}

}
