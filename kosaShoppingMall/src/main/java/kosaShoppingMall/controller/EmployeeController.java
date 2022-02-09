package kosaShoppingMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kosaShoppingMall.command.EmployeeCommand;
import kosaShoppingMall.service.employees.EmpDelsService;
import kosaShoppingMall.service.employees.EmployeeDeleteService;
import kosaShoppingMall.service.employees.EmployeeInfoService;
import kosaShoppingMall.service.employees.EmployeeListService;
import kosaShoppingMall.service.employees.EmployeeModifyService;
import kosaShoppingMall.service.employees.EmployeeUpdateService;
import kosaShoppingMall.service.employees.EmployeeWriteService;

@Controller
@RequestMapping("emp")
public class EmployeeController {
	@Autowired
	EmployeeWriteService employeeWriteService;
	@Autowired
	EmployeeListService employeeListService;
	@Autowired
	EmployeeInfoService employeeInfoService;
	@Autowired
	EmployeeModifyService employeeModifyService;
	@Autowired
	EmployeeUpdateService employeeUpdateService;
	@Autowired
	EmployeeDeleteService employeeDeleteService;
	@Autowired
	EmpDelsService empDelsService;
	
	@ModelAttribute
	EmployeeCommand setEmployeeCommand() {
		return new EmployeeCommand();
	}
	
	@RequestMapping(value="empDels", method=RequestMethod.POST)
	public String empDels(@RequestParam(value="delete") String[] deletes) {
		empDelsService.execute(deletes);
		return "redirect:empList";
	}
	
	@RequestMapping(value="empDelete")
	public String empDelete(EmployeeCommand employeeCommand, Model model) {
		employeeDeleteService.execute(employeeCommand,model);
		return "thymeleaf/employee/empDelete" ;
	}
	
	@RequestMapping(value="empUpdate", method=RequestMethod.POST)
	public String empUpdate(EmployeeCommand employeeCommand, BindingResult result) {
		String path = employeeUpdateService.execute(employeeCommand, result);
		return path;
	}
	
	@RequestMapping("empModify")
	public String empModify(@RequestParam(value="Id") String empId, @RequestParam(value="empPw") String empPw, Model model) {
		String path = employeeModifyService.execute(empId, empPw, model);
		return path;
	}
	
	@RequestMapping("employeeInfo")
	public String empInfo(@RequestParam(value="Id") String empId, Model model) {
		employeeInfoService.execute(empId, model);
		return "thymeleaf/employee/empDetail";
	}
	
	@RequestMapping("empList")
	public String empList(Model model) {
		employeeListService.execute(model);
		return "thymeleaf/employee/empList";
	}
	
	@RequestMapping("empJoin")
	public String empJoin() {
		//model.addAttribute("employeeCommand", new EmployeeCommand());
		return "thymeleaf/employee/empForm";
	}
	
	@RequestMapping(value = "empWrite", method = RequestMethod.GET)
	public String Write1() {
		return "thymeleaf/employee/empForm";
	}
	
	@RequestMapping(value = "empWrite", method = RequestMethod.POST)
	public String empWrite(@Validated EmployeeCommand employeeCommand, BindingResult result) {
		if(result.hasErrors()) {
			return "thymeleaf/employee/empForm";
		}
		if(!employeeCommand.isEmpPwEqualsEmpPwCon()) {
			result.rejectValue("empPwCon", "employeeCommand.empPwCon","비밀번호 확인이 다릅니다.");
			return "thymeleaf/employee/empForm";
		}
		employeeWriteService.execute(employeeCommand);
		return "redirect:empList";	
	}
}
