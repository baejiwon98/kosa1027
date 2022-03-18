package school.controller.course;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import school.command.CourseCommand;
import school.service.courses.ClassInsertService;
import school.service.courses.ClassListService;
import school.service.courses.ClassProfessorService;
import school.service.courses.ClassSubjectService;
import school.service.courses.ClassWishCancelService;
import school.service.courses.ClassWishListService;

@Controller
@RequestMapping("courses")
public class CourseController {
	@Autowired
	ClassListService classListService;
	@Autowired
	ClassSubjectService classSubjectService;
	@Autowired
	ClassProfessorService classProfessorService;
	@Autowired
	ClassInsertService classInsertService;
	@Autowired
	ClassWishListService classWishListService;
	@Autowired
	ClassWishCancelService classWishCancelService;
	
	@RequestMapping(value="courseCancel", method=RequestMethod.POST)
	public String courseCancel(@RequestParam(value="cancel") String [] cancels) {
		classWishCancelService.execute(cancels);
		return "redirect:courseWishList";
	}
	
	@RequestMapping("courseWishList")
	public String courseWishList(Model model , HttpSession session) {
		classWishListService.execute(model, session);
		return "thymeleaf/courses/courseWishList";
	}
	
	@RequestMapping(value = "coursesInsert", method=RequestMethod.POST)
	public String coursesInsert(CourseCommand courseCommand, HttpSession session) {
		classInsertService.execute(courseCommand, session);
		return "redirect:courseWishList";
	}
	
	@RequestMapping("professorList")
	public String professorList(@RequestParam(value="subjectNum")String subjectNum, 
			Model model) {
		classProfessorService.execute(subjectNum, model);
		return "thymeleaf/courses/professorList";
	}
	
	@RequestMapping("classSubject")
	public String classSubject(@RequestParam(value="departmentNum") String departmentNum,
			HttpSession session, Model model) {
		classSubjectService.execute(departmentNum, session, model);
		return "thymeleaf/courses/classSubject";
	}
	
	@RequestMapping("coursesCheck")
	public String courses(Model model) {
		classListService.execute(model);
		return "thymeleaf/courses/coursesList";
	}
}
