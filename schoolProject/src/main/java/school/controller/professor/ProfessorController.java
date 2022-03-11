package school.controller.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import school.command.ProfessorCommand;
import school.service.professor.ProfessorAutoNumService;
import school.service.professor.ProfessorDeleteService;
import school.service.professor.ProfessorInfoService;
import school.service.professor.ProfessorInsertService;
import school.service.professor.ProfessorListService;
import school.service.professor.ProfessorModifyService;

@Controller
@RequestMapping("professor")
public class ProfessorController {
	@Autowired
	ProfessorAutoNumService professorAutoNumService;
	@Autowired
	ProfessorInsertService professorInsertService;
	@Autowired
	ProfessorListService professorListService;
	@Autowired
	ProfessorInfoService professorInfoService;
	@Autowired
	ProfessorModifyService professorModifyService;
	@Autowired
	ProfessorDeleteService professorDeleteService;
	
	@RequestMapping("professorDelete")
	public String professorDelete(@RequestParam(value="num") String professorNum) {
		professorDeleteService.execute(professorNum);
		return "redirect:professorList";
	}
	
	@RequestMapping(value = "professorModify", method = RequestMethod.POST)
	public String professorModify(ProfessorCommand professorCommand, Model model) {
		professorModifyService.execute(professorCommand, model);
		return "redirect:professorInfo?num="+professorCommand.getProfessorNum();
	}
	
	@RequestMapping(value = "professorModify", method = RequestMethod.GET)
	public String professorModify(@RequestParam(value="num") String professorNum, Model model) {
		professorInfoService.execute(professorNum, model);
		return "thymeleaf/professor/professorModify";
	}
	
	@RequestMapping("professorInfo")
	public String professorInfo(@RequestParam(value="num") String professorNum, Model model) {
		professorInfoService.execute(professorNum, model);
		return "thymeleaf/professor/professorInfo";
	}
	
	@RequestMapping("professorList")
	public String professorList(Model model , @RequestParam(value="page", defaultValue = "1", required = false) Integer page) {
		professorListService.execute(model, page);
		return "thymeleaf/professor/professorList";
	}
	
	@RequestMapping(value = "professorInsert", method=RequestMethod.GET)
	public String professorInsert(ProfessorCommand professorCommand, Model model) {
		professorAutoNumService.execute(professorCommand, model);
		return "thymeleaf/professor/professorInsert";
	}
	
	@RequestMapping(value = "professorInsert", method=RequestMethod.POST)
	public String professorInsert1(ProfessorCommand professorCommand) {
		professorInsertService.execute(professorCommand);
		return "redirect:professorList";
	}
	
	
	
}
