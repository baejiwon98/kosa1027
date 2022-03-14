package school.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.mapper.StudentMapper;

@Service
public class StudentDeleteService {
	@Autowired
	StudentMapper studentMapper;

	public void execute(String studentNum) {
		studentMapper.studentDelete(studentNum);
		
	}

}
