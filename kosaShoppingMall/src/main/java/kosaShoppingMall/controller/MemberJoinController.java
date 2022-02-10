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

import kosaShoppingMall.command.MemberCommand;
import kosaShoppingMall.service.EmailCheckService;
import kosaShoppingMall.service.IdcheckService;
import kosaShoppingMall.service.member.MemberInfoService;
import kosaShoppingMall.service.member.MemberJoinService;

@Controller
@RequestMapping("register")
public class MemberJoinController {
	@Autowired
	MemberJoinService memberJoinService;
	@Autowired
	IdcheckService idcheckService;
	@Autowired
	EmailCheckService emailCheckService;
	
	@ModelAttribute
	public MemberCommand getMemberCommand() {
		return new MemberCommand();
	}
	
	@RequestMapping(value = "agree", method = RequestMethod.GET)
	public String agree() {
		return "thymeleaf/member/agree";
	}
	@RequestMapping(value = "regist", method = RequestMethod.GET)
	public String agree1() {
		return "thymeleaf/member/agree";
	}
	@RequestMapping(value = "regist", method = RequestMethod.POST)
	public String regist(@RequestParam(value = "agree", defaultValue = "false") Boolean agree) {
		System.out.println(agree);
		if(agree == false) {
			return "thymeleaf/member/agree";
		}
		return "thymeleaf/member/memberJoinForm";
	}
	@RequestMapping(value = "memberJoinAction", method = RequestMethod.POST)
	public String join(@Validated MemberCommand memberCommand, BindingResult result) {
		if(result.hasErrors()) {
			return "thymeleaf/member/memberJoinForm";
		}
		Integer i = idcheckService.execute(memberCommand.getMemId());
		if(i == 1) {
			result.rejectValue("memId", "memberCommand.memId", "중복아이디입니다.");
			return "thymeleaf/member/memberJoinForm";
		}
		
		i = emailCheckService.execute(memberCommand.getMemEmail());
		if(i == 1) {
			result.rejectValue("memEmail", "memberCommand.memEmail", "중복이메일입니다.");
			return "thymeleaf/member/memberJoinForm";
		}
		
		memberJoinService.execute(memberCommand, result);
		return "thymeleaf/member/welcome";
	}
}
