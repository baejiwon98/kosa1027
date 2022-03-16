package school.controller.professor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("profsubject")
public class ProfsubjectController {
	@RequestMapping("profsubjectList")
	public String profsubjectList() {
		return "thymeleaf/profsubject/profsubjectList";
	}
	
	@RequestMapping("profsubjInsert")
	public String profsubjInsert() {
		return "thymeleaf/profsubject/profsubjInsert";
	}
}
