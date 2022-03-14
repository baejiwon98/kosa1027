package school.controller.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import school.command.StudentCommand;
import school.service.student.StudentAutoNumService;
import school.service.student.StudentDeleteService;
import school.service.student.StudentInfoService;
import school.service.student.StudentInsertService;
import school.service.student.StudentListService;
import school.service.student.StudentModifyService;

@Controller
@RequestMapping("student")
public class StudentController {
	@Autowired
	StudentInsertService studentInsertService;
	@Autowired
	StudentAutoNumService studentAutoNumService;
	@Autowired
	StudentListService studentListService;
	@Autowired
	StudentInfoService studentInfoService;
	@Autowired
	StudentModifyService studentModifyService;
	@Autowired
	StudentDeleteService studentDeleteService;
	

	@RequestMapping("studentDelete")
	public String studentDelete(@RequestParam(value="num") String studentNum) {
		studentDeleteService.execute(studentNum);
		return "redirect:studentList";
	}
	
	@RequestMapping(value = "studentModify", method = RequestMethod.POST)
	public String studentModify(StudentCommand studentCommand, Model model) {
		studentModifyService.execute(studentCommand, model);
		return "redirect:studentInfo?num="+studentCommand.getStudentNum();
	}
	
	@RequestMapping(value = "studentModify", method = RequestMethod.GET)
	public String studentModify(@RequestParam(value="num") String studentNum, Model model) {
		studentInfoService.execute(studentNum, model);
		return "thymeleaf/student/studentModify";
	}
	
	@RequestMapping("studentInfo")
	public String studentInfo(@RequestParam(value="num") String studentNum, Model model) {
		studentInfoService.execute(studentNum, model);
		return "thymeleaf/student/studentInfo";
	}
	
	@RequestMapping("studentList")
	public String studentList(Model model, @RequestParam(value="page", defaultValue = "1", required= false)Integer page) {
		studentListService.execute(model, page);
		return "thymeleaf/student/studentList";
	}
	
	@RequestMapping(value = "studentInsert", method=RequestMethod.GET)
	public String studentInsert(StudentCommand studentCommand, Model model) {
		studentAutoNumService.execute(studentCommand, model);
		return "thymeleaf/student/studentInsert";
	}
	
	@RequestMapping(value = "studentInsert", method=RequestMethod.POST)
	public String studentInsert1(StudentCommand studentCommand) {
		studentInsertService.execute(studentCommand);
		return "redirect:studentList";
	}
}
