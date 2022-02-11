package kosaShoppingMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kosaShoppingMall.command.EmployeeCommand;
import kosaShoppingMall.command.MemberCommand;
import kosaShoppingMall.service.EmailCheckModifyService;
import kosaShoppingMall.service.EmailCheckService;
import kosaShoppingMall.service.IdcheckService;
import kosaShoppingMall.service.MemEmailCheckModifyService;

@RestController
public class CheckController {
	@Autowired
	IdcheckService idcheckService;
	@Autowired
	EmailCheckService emailCheckService;
	@Autowired
	EmailCheckModifyService emailCheckModifyService;
	@Autowired
	MemEmailCheckModifyService memEmailCheckModifyService;
	
	@RequestMapping(value="/mypage/memEmailCheckModify")
	public String memEmailCheckModify1(MemberCommand memberCommand) {
		Integer i = memEmailCheckModifyService.execute(memberCommand);
		if(i == 0) {
			return "사용 가능한 email 입니다.";
		}else {
			return "사용 중인 Email입니다.";
		}
	}
	
	@RequestMapping(value="/empMypage/emailCheckModify", method=RequestMethod.POST)
	public String emailCheckModify1(EmployeeCommand employeeCommand) {
		Integer i = emailCheckModifyService.execute(employeeCommand);
		if(i == 0) {
			return "사용 가능한 email 입니다.";
		}else {
			return "사용 중인 Email입니다.";
		}
	}
	
	@RequestMapping(value="/mem/memEmailCheckModify")
	public String memEmailCheckModify(MemberCommand memberCommand) {
		Integer i = memEmailCheckModifyService.execute(memberCommand);
		if(i == 0) {
			return "사용 가능한 email 입니다.";
		}else {
			return "사용 중인 Email입니다.";
		}
	}
	
	@RequestMapping(value="/mem/emailCheck", method=RequestMethod.POST)
	public String emailCheck2(@RequestParam(value="memEmail") String memEmail) {
		Integer i = emailCheckService.execute(memEmail);
		if(i == 0) {
			return "사용 가능한 email 입니다.";
		}else {
			return "사용 중인 Email입니다.";
		}
	}
	
	@RequestMapping(value="/mem/idCheck", method=RequestMethod.POST)
	public String idCheck2(@RequestParam(value="memId") String memId) {
		Integer i = idcheckService.execute(memId);
		if(i == 0) {
			return "사용 가능한 id입니다.";
		}else {
			return "사용 중인 id입니다.";
		}
	}
	
	@RequestMapping(value="/emp/emailCheckModify", method=RequestMethod.POST)
	public String emailCheckModify(EmployeeCommand employeeCommand) {
		Integer i = emailCheckModifyService.execute(employeeCommand);
		if(i == 0) {
			return "사용 가능한 email 입니다.";
		}else {
			return "사용 중인 Email입니다.";
		}
	}
	
	@RequestMapping(value="/emp/emailCheck", method=RequestMethod.POST)
	public String emailCheck1(@RequestParam(value="empEmail") String empEmail) {
		Integer i = emailCheckService.execute(empEmail);
		if(i == 0) {
			return "사용 가능한 email 입니다.";
		}else {
			return "사용 중인 Email입니다.";
		}
	}
	
	@RequestMapping(value="/emp/idCheck", method=RequestMethod.POST)
	public String idCheck1(@RequestParam(value="empId") String empId) {
		Integer i = idcheckService.execute(empId);
		if(i == 0) {
			return "사용 가능한 id입니다.";
		}else {
			return "사용 중인 id입니다.";
		}
	}
	
	
	@RequestMapping(value="/register/emailCheck", method=RequestMethod.POST)
	public String emailCheck(@RequestParam(value="memEmail") String memEmail) {
		Integer i = emailCheckService.execute(memEmail);
		if(i == 0) {
			return "사용 가능한 email 입니다.";
		}else {
			return "사용 중인 Email입니다.";
		}
	}
	
	@RequestMapping(value="/register/idCheck", method=RequestMethod.POST)
	public String idCheck(@RequestParam(value="memId") String memId) {
		Integer i = idcheckService.execute(memId);
		if(i == 0) {
			return "사용 가능한 id입니다.";
		}else {
			return "사용 중인 id입니다.";
		}
	}
}
