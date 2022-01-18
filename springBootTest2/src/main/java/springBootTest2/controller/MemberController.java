package springBootTest2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springBootTest2.command.MemberCommand;
import springBootTest2.service.member.MemberDelService;
import springBootTest2.service.member.MemberDetailService;
import springBootTest2.service.member.MemberInfoService;
import springBootTest2.service.member.MemberListService;
import springBootTest2.service.member.MemberNumberService;
import springBootTest2.service.member.MemberRegistService;
import springBootTest2.service.member.MemberUpdateService;

@Controller
@RequestMapping("mem")
public class MemberController {
	@Autowired
	MemberListService memberListService;
	@Autowired
	MemberRegistService memberRegistService;
	@Autowired
	MemberDetailService memberDetailService;
 	@Autowired
 	MemberDelService memberDelService;
 	@Autowired
 	MemberInfoService memberInfoService;
 	@Autowired
 	MemberUpdateService memberUpdateService;
 	@Autowired
 	MemberNumberService memberNumberService;
 	
 	@RequestMapping("memberUpdate")
 	public String memberUpdateOk(MemberCommand memberCommand) {
 		memberUpdateService.execute(memberCommand);
 		return "redirect:memberDetail?num="+memberCommand.getMemNum();
 	}
	
 	@RequestMapping("memberModify")
 	public String memberUpdate(@RequestParam(value = "num") String memNum, Model model) {
 		memberInfoService.execute(memNum, model);
 		return "thymeleaf/member/memberDetail";
 	}
 	
 	@RequestMapping(value="memberDel", method = RequestMethod.GET)
 	public String memberDel(@RequestParam(value = "num") String memNum) {
 		memberDelService.execute(memNum);
 		return "redirect:memberList";
 	}
 	
	@RequestMapping(value="memberDetail", method = RequestMethod.GET)
	public String memberDetail(@RequestParam(value = "num") String memNum, Model model) {
		memberDetailService.execute(model, memNum);
		return "thymeleaf/member/memberInfo";
	}
	
	@RequestMapping("memberList")
	public String memberList(Model model) {
		memberListService.execute(model);
		return "thymeleaf/member/memberList";
	}
	
	@RequestMapping("memberRegist")
	public String memberRegist(Model model) {
		memberNumberService.execute(model);
		return "thymeleaf/member/memberForm";
	}
	
	@RequestMapping("memberWrite")
	public String memberWrite(MemberCommand memberCommand) {
		memberRegistService.execute(memberCommand);
		return "redirect:memberList";
	}
}
