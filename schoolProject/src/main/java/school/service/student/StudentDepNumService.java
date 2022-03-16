package school.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.command.StudentCommand;
import school.mapper.StudentMapper;

@Service
public class StudentDepNumService {
	@Autowired
	StudentMapper studentMapper;
	public String execute(StudentCommand studentCommand) {
		String studentNum = studentMapper.autoNum(studentCommand.getDepartmentNum());
		return studentNum;
	}
}
