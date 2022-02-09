package kosaShoppingMall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kosaShoppingMall.command.EmployeeCommand;
import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.service.empship.EmpPasswordService;
import kosaShoppingMall.service.empship.EmpshipInfoService;
import kosaShoppingMall.service.empship.EmpshipUpdateService;

@Controller
@RequestMapping("empMypage")
public class EmpMyPageController {
	@Autowired
	EmpshipInfoService empshipInfoService;
	@Autowired
	EmpshipUpdateService empshipUpdateService;
	@Autowired
	EmpPasswordService empPasswordService;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@RequestMapping(value="empPassModify", method=RequestMethod.POST)
	public String empPassModify(@RequestParam(value="empPw") String oldPw, 
			@RequestParam(value="newEmpPw") String newPw, @RequestParam(value="newEmpPwCon") String newPwCon,
			HttpSession session, Model model) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo"); 
		
		if(passwordEncoder.matches(oldPw, authInfo.getUserPw())) {
			if(newPw.equals(newPwCon) && !newPw.isEmpty()) {
				newPw = passwordEncoder.encode(newPw);
				empPasswordService.execute(authInfo.getUserId(), newPw);
				authInfo.setUserPw(newPw);
				return "redirect:empDetail";
			}else {
				model.addAttribute("err_pwCon", "비밀번호 확인이 틀립니다.");
				return "thymeleaf/employeesShip/empPassCon";
			}
		}else {
			model.addAttribute("err_pw", "비밀번호가 틀립니다. ");
			return "thymeleaf/employeesShip/empPassCon";
		}
	}	
	
	@RequestMapping(value="empPasswordPro", method=RequestMethod.POST)
	public String empPasswordPro(@RequestParam(value="empPw") String pw, HttpSession session, Model model) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		if(passwordEncoder.matches(pw, authInfo.getUserPw())) {
			return "thymeleaf/employeesShip/empPassCon";
		}else {
			model.addAttribute("err_pw", "비밀번호가 틀립니다. ");
			return "thymeleaf/employeesShip/empPass";
		}
	}
	
	@RequestMapping("empPwUpdate")
	public String empPwUpdate() {
		return "thymeleaf/employeesShip/empPass";
	}
	
	@RequestMapping(value="empUpdate", method=RequestMethod.POST)
	public String empUpdate(@Validated EmployeeCommand employeeCommand, BindingResult result){
		if(result.hasErrors()) {
			return "thymeleaf/employeesShip/empModify";
		}
		empshipUpdateService.execute(employeeCommand);
		return "redirect:empDetail";
	}
	
	@RequestMapping("empModify")
	public String empModify(Model model, HttpSession session) {
		empshipInfoService.execute(model, session);
		return "thymeleaf/employeesShip/empModify";
	}
	
	@RequestMapping("empDetail")
	public String empDetail(Model model, HttpSession session) {
		empshipInfoService.execute(model, session);
		return  "thymeleaf/employeesShip/empDetail";
	}
}
