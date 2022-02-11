package kosaShoppingMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kosaShoppingMall.command.MemberCommand;
import kosaShoppingMall.service.EmailCheckService;
import kosaShoppingMall.service.IdcheckService;
import kosaShoppingMall.service.MemEmailCheckModifyService;
import kosaShoppingMall.service.member.MemberDeleteService;
import kosaShoppingMall.service.member.MemberDelsService;
import kosaShoppingMall.service.member.MemberInfoService;
import kosaShoppingMall.service.member.MemberListService;
import kosaShoppingMall.service.member.MemberModifyService;
import kosaShoppingMall.service.member.MemberNumberService;
import kosaShoppingMall.service.member.MemberUpdateService;
import kosaShoppingMall.service.member.MemberWriteService;

@Controller
@RequestMapping("mem")
public class MemberController {
	@Autowired
	MemberWriteService memberWriteService;
	@Autowired
	MemberNumberService memberNumberService;
	@Autowired
	MemberListService memberListService;
	@Autowired
	MemberInfoService memberInfoService;
	@Autowired
	MemberModifyService memberModifyService;
	@Autowired
	MemberUpdateService memberUpdateService;
	@Autowired
	MemberDeleteService memberDeleteService;
	@Autowired
	MemberDelsService memberDelsService;
	@Autowired
	IdcheckService idcheckService;
	@Autowired
	EmailCheckService emailCheckService;
	@Autowired
	MemEmailCheckModifyService memEmailCheckModifyService;
	
	@ModelAttribute
 	MemberCommand setMemberCommand() {
 		return new MemberCommand();
 	}
	
	@RequestMapping(value="memberDels", method=RequestMethod.POST)
	public String memberDels(@RequestParam(value="delete") String [] deletes) {
		memberDelsService.execute(deletes);
		return "redirect:memList";
	}
	
	@RequestMapping(value = "memberDelete")
	public String memberDelete(@RequestParam(value="memNum") String memNum, Model model) {
		memberDeleteService.execute(memNum, model);
		return "thymeleaf/member/memberDelete";
		//return "member/memberDelete";
	}
	
	@RequestMapping(value = "memberUpdate", method=RequestMethod.POST)
	public String memberUpdate(@Validated MemberCommand memberCommand, BindingResult result) {
		if(result.hasErrors()) {
			return "thymeleaf/member/memberModify";
			//return "member/memberModify";
		}
		Integer i = memEmailCheckModifyService.execute(memberCommand);
		if(i == 1) {
			result.rejectValue("memEmail", "memberCommand.memEmail", "중복이메일입니다.");
			return "thymeleaf/member/memberModify";
		}
		memberUpdateService.execute(memberCommand);
		return "redirect:memberInfo/"+memberCommand.getMemNum();
	}
	
	@RequestMapping("memberModify")
	public String memberModify(@RequestParam(value="memNum") String memNum, Model model) {
		memberModifyService.execute(memNum, model);
		return "thymeleaf/member/memberModify";
		//return "member/memberModify";
	}
	
	@RequestMapping(value="memberInfo/{id}")
	public String memberInfo(@PathVariable(value="id") String memNum, Model model) {
		memberInfoService.execute(memNum, model);
		return "thymeleaf/member/memberDetail";
		//return "member/memberDetail";
	}
	
	@RequestMapping(value = "memberRegist", method = RequestMethod.GET)
	public String memberForm(MemberCommand memberCommand, Model model) {
		memberNumberService.execute(memberCommand, model);
		return "thymeleaf/member/memberForm";
		//return "member/memberForm";
	}
	
	@RequestMapping(value = "memberRegist", method = RequestMethod.POST)
	public String memberRegist(@Validated MemberCommand memberCommand, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "thymeleaf/member/memberForm";
			//return "member/memberForm";
		}
		if(!memberCommand.isMemPwEqualsMemPwCon()) {
			result.rejectValue("memPw", "memberCommand.memPw", "비밀번호 확인이 다릅니다.");
			return "thymeleaf/member/memberForm";
			//return "member/memberForm";
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
		
		memberWriteService.execute(memberCommand, model);
		return "redirect:memList";
	}
	
	@RequestMapping("memList")
	public String memList(@RequestParam(value="page", defaultValue = "1", required = false)Integer page, Model model) {
		memberListService.execute(model, page);
		return "thymeleaf/member/memberList";
		//return "member/memberList";
	}
}
