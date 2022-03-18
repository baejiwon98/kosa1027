package school.service.stupage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.command.StudentCommand;
import school.domain.StudentDTO;
import school.mapper.StupageMapper;

@Service
public class StupageUpdateService {
	@Autowired
	StupageMapper stupageMapper;
	
	public void execute(StudentCommand studentCommand) {
		StudentDTO dto = stupageMapper.selectOne(studentCommand.getStudentId());
		
		dto.setStudentNum(studentCommand.getStudentNum());
		dto.setDepartmentNum(studentCommand.getDepartmentNum());
		dto.setStudentId(studentCommand.getStudentId());
		dto.setStudentName(studentCommand.getStudentName());		
		dto.setStudentPhone(studentCommand.getStudentPhone());
		dto.setStudentEmail(studentCommand.getStudentEmail());
		
		stupageMapper.stuUpdate(dto);
	}

}
