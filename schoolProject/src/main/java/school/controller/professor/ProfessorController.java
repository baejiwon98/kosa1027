package school.controller.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import school.command.ProfessorCommand;
import school.service.check.EmailCheckModifyService;
import school.service.check.EmailCheckService;
import school.service.check.IdcheckService;
import school.service.professor.ProfessorAutoDepNumService;
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
	@Autowired
	IdcheckService idcheckService;
	@Autowired
	EmailCheckService emailCheckService;
	@Autowired
	EmailCheckModifyService emailCheckModifyService;
	@Autowired
	ProfessorAutoDepNumService professorAutoDepNumService;
	
	@ModelAttribute
	ProfessorCommand setProfessorCommand() {
		return new ProfessorCommand();
	}
	
	@RequestMapping("professorDelete")
	public String professorDelete(@RequestParam(value="num") String professorNum) {
		professorDeleteService.execute(professorNum);
		return "redirect:professorList";
	}
	
	@RequestMapping(value = "professorUpdate", method = RequestMethod.POST)
	public String professorModify(@Validated ProfessorCommand professorCommand, BindingResult result, Model model) {
		professorAutoDepNumService.execute(model);
		if(result.hasErrors()) {
			return "thymeleaf/professor/professorModify";
		}
		Integer i = emailCheckModifyService.execute(professorCommand);
		if(i == 1) {
			result.rejectValue("professorEmail", "professorCommand.professorEmail", "중복이메일입니다.");
			return "thymeleaf/professor/professorModify";
		}
		professorModifyService.execute(professorCommand);
		return "redirect:professorInfo?num="+professorCommand.getProfessorNum();
	}
	
	@RequestMapping("professorModify")
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
	public String professorInsert1(@Validated ProfessorCommand professorCommand, BindingResult result, Model model) {
		professorAutoNumService.execute(professorCommand, model);
		if(result.hasErrors()) {
			return "thymeleaf/professor/professorInsert";
		}
		if(!professorCommand.isProfPwEqualsProfPwCon()) {
			result.rejectValue("professorPwCon", "professorCommand.professorPwCon", "비밀번호 확인이 다릅니다.");
			return "thymeleaf/professor/professorInsert";
		}
		Integer i = idcheckService.execute(professorCommand.getProfessorId());
		if(i == 1) {
			result.rejectValue("professorId", "professorCommand.professorId", "중복아이디입니다.");
			return "thymeleaf/professor/professorInsert";
		}
		
		i = emailCheckService.execute(professorCommand.getProfessorEmail());
		if(i == 1) {
			result.rejectValue("professorEmail", "professorCommand.professorEmail", "중복이메일입니다.");
			return "thymeleaf/professor/professorInsert";
		}
		
		professorInsertService.execute(professorCommand, result, model);
		return "redirect:professorList";
	}
	
	
	
}
