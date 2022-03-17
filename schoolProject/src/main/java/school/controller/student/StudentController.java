package school.controller.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import school.command.StudentCommand;
import school.service.check.EmailCheckService;
import school.service.check.EmailStuCheckModifyService;
import school.service.check.IdcheckService;
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
	@Autowired
	IdcheckService idcheckService;
	@Autowired
	EmailCheckService emailCheckService;
	@Autowired
	EmailStuCheckModifyService emailStuCheckModifyService;
	
	@ModelAttribute
	StudentCommand setStudentCommand() {
		return new StudentCommand();
	}
	
	@RequestMapping("studentDelete")
	public String studentDelete(@RequestParam(value="num") String studentNum) {
		studentDeleteService.execute(studentNum);
		return "redirect:studentList";
	}
	
	@RequestMapping(value = "studentModify", method = RequestMethod.POST)
	public String studentModify(@Validated StudentCommand studentCommand, BindingResult result, Model model) {
		studentAutoNumService.execute(model);
		if(result.hasErrors()) {
			return "thymeleaf/student/studentModify";
		}
		Integer i = emailStuCheckModifyService.execute(studentCommand);
		if(i == 1) {
			result.rejectValue("studentEmail", "studentCommand.studentEmail", "중복이메일입니다.");
			return "thymeleaf/student/studentModify";
		}
		studentModifyService.execute(studentCommand, model);
		return "redirect:studentInfo?num="+studentCommand.getStudentNum();
	}
	
	@RequestMapping("studentUpdate")
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
	public String studentInsert(Model model) {
		studentAutoNumService.execute(model);
		return "thymeleaf/student/studentInsert";
	}
	
	@RequestMapping(value = "studentInsert", method=RequestMethod.POST)
	public String studentInsert1(@Validated StudentCommand studentCommand, BindingResult result, Model model) {
		studentAutoNumService.execute(model);
		if(result.hasErrors()) {
			return "thymeleaf/student/studentInsert";
		}
		if(!studentCommand.isStuPwEqualsStuPwCon()) {
			result.rejectValue("studentPwCon", "studentCommand.studentPwCon", "비밀번호 확인이 다릅니다.");
			return "thymeleaf/student/studentInsert";
		}
		Integer i = idcheckService.execute(studentCommand.getStudentId());
		if(i == 1) {
			result.rejectValue("studentId", "studentCommand.studentId", "중복아이디입니다.");
			return "thymeleaf/student/studentInsert";
		}
		
		i = emailCheckService.execute(studentCommand.getStudentEmail());
		if(i == 1) {
			result.rejectValue("studentEmail", "studentCommand.studentEmail", "중복이메일입니다.");
			return "thymeleaf/student/studentInsert";
		}
		
		studentInsertService.execute(studentCommand);
		return "redirect:studentList";
	}
}
