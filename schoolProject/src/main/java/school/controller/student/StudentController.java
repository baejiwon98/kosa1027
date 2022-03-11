package school.controller.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import school.command.StudentCommand;
import school.service.student.StudentInsertService;

@Controller
@RequestMapping("student")
public class StudentController {
	@Autowired
	StudentInsertService studentInsertService;
	
	@RequestMapping("studentList")
	public String studentList() {
		return "thymeleaf/student/studentList";
	}
	
	@RequestMapping(value = "studentInsert", method=RequestMethod.GET)
	public String studentInsert() {
		return "thymeleaf/student/studentInsert";
	}
	
	@RequestMapping(value = "studentInsert", method=RequestMethod.POST)
	public String studentInsert1(StudentCommand studentCommand) {
		studentInsertService.execute(studentCommand);
		return "thymeleaf/student/studentInsert";
	}
}
