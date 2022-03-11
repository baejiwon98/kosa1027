package school.controller.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import school.command.SubjectCommand;
import school.service.subject.SubjectAutoNumService;
import school.service.subject.SubjectDeleteService;
import school.service.subject.SubjectInfoService;
import school.service.subject.SubjectInsertService;
import school.service.subject.SubjectListService;
import school.service.subject.SubjectModifyService;

@Controller
@RequestMapping("subject")
public class SubjectController {
	@Autowired
	SubjectAutoNumService subjectAutoNumService;
	@Autowired
	SubjectInsertService subjectInsertService;
	@Autowired
	SubjectListService subjectListService;
	@Autowired
	SubjectInfoService subjectInfoService;
	@Autowired
	SubjectModifyService subjectModifyService;
	@Autowired
	SubjectDeleteService subjectDeleteService;
	
	@RequestMapping("subjectDelete")
	public String subjectDelete(@RequestParam(value="num") String subjectNum) {
		subjectDeleteService.execute(subjectNum);
		return "redirect:subjectList";
	}
	
	@RequestMapping(value="subjectModify", method=RequestMethod.POST)
	public String subjectModify(SubjectCommand subjectCommand, Model model) {
		subjectModifyService.execute(subjectCommand, model);
		return "redirect:subjectInfo?num="+subjectCommand.getSubjectNum();
	}
	
	@RequestMapping(value="subjectModify", method=RequestMethod.GET)
	public String subjectModify(@RequestParam(value="num") String subjectNum, Model model) {
		subjectInfoService.execute(subjectNum, model);
		return "thymeleaf/subject/subjectModify";
	}
	
	@RequestMapping("subjectInfo")
	public String subjectInfo(@RequestParam(value="num") String subjectNum, Model model) {
		subjectInfoService.execute(subjectNum, model);
		return "thymeleaf/subject/subjectInfo";
	}
	
	@RequestMapping("subjectList")
	public String subjectList(Model model , @RequestParam(value="page", defaultValue = "1", required = false) Integer page) {
		subjectListService.execute(model, page);
		return "thymeleaf/subject/subjectList";
	}
	
	@RequestMapping(value = "subjectInsert", method=RequestMethod.GET)
	public String subjectInsert(SubjectCommand subjectCommand, Model model) {
		subjectAutoNumService.execute(subjectCommand, model);
		return "thymeleaf/subject/subjectInsert";
	}
	
	@RequestMapping(value = "subjectInsert", method=RequestMethod.POST)
	public String subjectInsert1(SubjectCommand subjectCommand) {
		subjectInsertService.execute(subjectCommand);
		return "redirect:subjectList";
	}
}
