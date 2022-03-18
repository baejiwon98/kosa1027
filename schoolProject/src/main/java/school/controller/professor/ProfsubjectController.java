package school.controller.professor;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import school.command.ProfSubjectCommand;
import school.service.profsubject.ProfSubjectAutoNumsService;
import school.service.profsubject.ProfSubjectCancelsService;
import school.service.profsubject.ProfSubjectDelsService;
import school.service.profsubject.ProfSubjectInsertService;
import school.service.profsubject.ProfSubjectListService;
import school.service.profsubject.ProfSubjectReCancelsService;
import school.service.profsubject.ProfmySubjectListService;

@Controller
@RequestMapping("profsubject")
public class ProfsubjectController {
	@Autowired
	ProfSubjectAutoNumsService profSubjectAutoNumsService;
	@Autowired
	ProfSubjectInsertService profSubjectInsertService;
	@Autowired
	ProfSubjectListService profSubjectListService;
	@Autowired
	ProfSubjectDelsService profSubjectDelsService;
	@Autowired
	ProfmySubjectListService profmySubjectListService;
	@Autowired
	ProfSubjectCancelsService profSubjectCancelsService;
	@Autowired
	ProfSubjectReCancelsService profSubjectReCancelsService;
	
	@RequestMapping(value = "profsubjReCancels", method=RequestMethod.POST)
	public String profsubjReCancels(@RequestParam(value="cancel") String [] cancels) {
		profSubjectReCancelsService.execute(cancels);
		return "redirect:profmysubj";
	}
	
	@RequestMapping(value = "profsubjCancels", method=RequestMethod.POST)
	public String profsubjCancels(@RequestParam(value="cancel") String [] cancels) {
		profSubjectCancelsService.execute(cancels);
		return "redirect:profmysubj";
	}
	
	@RequestMapping("profmysubj")
	public String profmysubj(Model model, HttpSession session) {
		profmySubjectListService.execute(model, session);
		return "thymeleaf/profsubject/profmysubjectList";
	}
	
	@RequestMapping(value = "profsubjdels", method=RequestMethod.POST)
	public String profsubjdels(@RequestParam(value="delete") String [] deletes) {
		profSubjectDelsService.execute(deletes);
		return "redirect:profsubjectList";
	}
	
	@RequestMapping("profsubjectList")
	public String profsubjectList(Model model, @RequestParam(value="page", defaultValue = "1", required= false)Integer page) {
		profSubjectListService.execute(model, page);
		return "thymeleaf/profsubject/profsubjectList";
	}
	
	@RequestMapping(value = "profsubjInsert", method = RequestMethod.GET)
	public String profsubjInsert(ProfSubjectCommand profSubjectCommand, Model model) {
		profSubjectAutoNumsService.execute(profSubjectCommand, model);
		return "thymeleaf/profsubject/profsubjInsert";
	}
	
	@RequestMapping(value = "profsubjInsert", method = RequestMethod.POST)
	public String profsubjInsert1(ProfSubjectCommand profSubjectCommand) {
		profSubjectInsertService.execute(profSubjectCommand);
		return "redirect:profsubjectList";
	}
}
