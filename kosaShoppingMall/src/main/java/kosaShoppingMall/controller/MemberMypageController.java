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

import kosaShoppingMall.command.MemberCommand;
import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.service.MemEmailCheckModifyService;
import kosaShoppingMall.service.member.MemberDropService;
import kosaShoppingMall.service.member.MemberPasswordService;
import kosaShoppingMall.service.member.MemberUpdateService;
import kosaShoppingMall.service.member.MembershipInfoService;

@Controller
@RequestMapping("mypage")
public class MemberMypageController {
	@Autowired
	MembershipInfoService membershipInfoService;
	@Autowired
	MemberUpdateService memberUpdateService;
	@Autowired
	MemberPasswordService memberPasswordService;
	@Autowired
	MemberDropService memberDropService;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	MemEmailCheckModifyService memEmailCheckModifyService;
	
	@RequestMapping(value="memberDropOk", method=RequestMethod.POST)
	public String memberDropOk(@RequestParam(value="memPw") String memPw, Model model,HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		if(passwordEncoder.matches(memPw, authInfo.getUserPw())) {
			memberDropService.execute(authInfo.getUserId());
			return "redirect:/main/logout";
		} else {
			model.addAttribute("err_pw", "비밀번호가 틀립니다. ");
			return "thymeleaf/member/memberDropPass";
		}
	}
	
	@RequestMapping("memberUserDel")
	public String memberDrop() {
		return "thymeleaf/member/memberDropPass";
	}	
	
	@RequestMapping(value="memberPassModify", method=RequestMethod.POST)
	public String memberPassModify(@RequestParam(value="memPw") String oldPw, 
			@RequestParam(value="newMemPw") String newPw, @RequestParam(value="newMemPwCon") String newPwCon,
			HttpSession session, Model model) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo"); 
		
		if(passwordEncoder.matches(oldPw, authInfo.getUserPw())) {
			if(newPw.equals(newPwCon) && !newPw.isEmpty()) {
				newPw = passwordEncoder.encode(newPw);
				memberPasswordService.execute(authInfo.getUserId(), newPw);
				authInfo.setUserPw(newPw);
				return "redirect:memberDetail";
			}else {
				model.addAttribute("err_pwCon", "비밀번호 확인이 틀립니다.");
				return "thymeleaf/member/memberPassCon";
			}
		}else {
			model.addAttribute("err_pw", "비밀번호가 틀립니다. ");
			return "thymeleaf/member/memberPassCon";
		}
	}	
	
	@RequestMapping(value="memberPasswordPro", method=RequestMethod.POST)
	public String memberPasswordPro(@RequestParam(value="memPw") String pw, HttpSession session, Model model) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		if(passwordEncoder.matches(pw, authInfo.getUserPw())) {
			return "thymeleaf/member/memberPassCon";
		}else {
			model.addAttribute("err_pw", "비밀번호가 틀립니다. ");
			return "thymeleaf/member/memberPass";
		}
	}
	
	@RequestMapping("memberPwForm")
	public String memberPass() {
		return "thymeleaf/member/memberPass";
	}
	
	@RequestMapping(value="membershipUpdate", method=RequestMethod.POST)
	public String memberUpdate(@Validated MemberCommand memberCommand, BindingResult result) {
		if(result.hasErrors()) {
			return "thymeleaf/member/membershipModify";
		}
		Integer i = memEmailCheckModifyService.execute(memberCommand);
		if(i == 1) {
			result.rejectValue("memEmail", "memberCommand.memEmail", "중복이메일입니다.");
			return "thymeleaf/member/membershipModify";
		}
		memberUpdateService.execute(memberCommand);
		return "redirect:memberDetail";
	}
	
	@RequestMapping("memberPw")
	public String memberModify(Model model, HttpSession session) {
		membershipInfoService.execute(model, session);
		return "thymeleaf/member/membershipModify";
	}
	
	@RequestMapping("memberDetail")
	public String memberDetail(Model model, HttpSession session) {
		membershipInfoService.execute(model, session);
		return "thymeleaf/member/memberInfo";
	}	
}
