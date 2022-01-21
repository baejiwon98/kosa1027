package springBootTest2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springBootTest2.command.EmpLibCommand;
import springBootTest2.mapper.EmpLibMapper;
import springBootTest2.service.emplib.EmpLibDeleteService;
import springBootTest2.service.emplib.EmpLibDetailService;
import springBootTest2.service.emplib.EmpLibListService;
import springBootTest2.service.emplib.EmpLibModifyService;
import springBootTest2.service.emplib.EmpLibUpdateService;
import springBootTest2.service.emplib.EmpLibWriteService;

@Controller
@RequestMapping("emplib")
public class EmplibController {
	@Autowired
	EmpLibMapper empLibMapper;
	@Autowired
	EmpLibWriteService empLibWriteService;
	@Autowired
	EmpLibListService empLibListService;
	@Autowired
	EmpLibDetailService empLibDetailService;
	@Autowired
	EmpLibDeleteService empLibDeleteService;
	@Autowired
	EmpLibModifyService empLibModifyService;
	@Autowired
	EmpLibUpdateService empLibUpdateService;
	
	@RequestMapping(value ="emplibUpdate", method=RequestMethod.POST)
	public String emplibUpdate(EmpLibCommand emplibCommand, HttpSession session, Model model, HttpServletRequest request) {
		String path = empLibUpdateService.execute(emplibCommand, session, model, request);
		return path;
	}
	
	@RequestMapping("emplibModify")
	public String emplibModify(@RequestParam(value="libNum") Integer libNum,
			@RequestParam(value="libPw") String libPw, Model model,
			HttpSession session) {
		String path = empLibModifyService.execute(libNum, libPw, model, session);
		return path;
	}
	
	@RequestMapping("libDelete")
	public String libDelete(EmpLibCommand emplibCommand, 
			HttpSession session,Model model) {
		String path = empLibDeleteService.execute( emplibCommand,session,model);
		return path;
	}
	
	@RequestMapping(value = "emplibDetail" , method = RequestMethod.GET)
	public String empLibDetail(@RequestParam(value = "num") Integer libNum, Model model) {
		empLibDetailService.execute(model, libNum);
		return "thymeleaf/emplib/emplibInfo";
	}
	
	@RequestMapping("emplibList")
	public String empLibList(Model model) {
		empLibListService.execute(model);
		return "thymeleaf/emplib/emplibList";
	}
	
	@RequestMapping("empLibWrite")
	public String empLibWrite(EmpLibCommand empLibCommand, HttpServletRequest request) {
		empLibWriteService.execute(empLibCommand, request);
		return "redirect:emplibList";
	}
	
	@RequestMapping("empLibForm")
	public String empLibForm() {
		return "thymeleaf/emplib/emplibForm";
	}
}
