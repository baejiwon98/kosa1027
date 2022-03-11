package school.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.command.StudentCommand;
import school.domain.StudentDTO;
import school.mapper.StudentMapper;

@Service
public class StudentInsertService {
	@Autowired
	StudentMapper studentMapper;
	
	public void execute(StudentCommand studentCommand) {
	StudentDTO dto = new StudentDTO();
	
		
	}

}
