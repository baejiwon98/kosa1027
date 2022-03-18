package school.service.courses;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.command.CourseCommand;
import school.domain.AuthInfo;
import school.domain.CourseDTO;
import school.mapper.ClassMapper;

@Service
public class ClassInsertService {
	@Autowired
	ClassMapper classMapper;
	
	public void execute(CourseCommand courseCommand, HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		CourseDTO dto = new CourseDTO();
		dto.setProfessorNum(courseCommand.getProfessorNum());
		dto.setStudentNum(authInfo.getUserNum());
		dto.setSubjectNum(courseCommand.getSubjectNum());
		
		classMapper.classInsert(dto);
	}
}
