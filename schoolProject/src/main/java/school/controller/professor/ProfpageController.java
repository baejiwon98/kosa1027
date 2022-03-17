package school.controller.professor;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import school.command.ProfessorCommand;
import school.domain.AuthInfo;
import school.service.check.EmailCheckModifyService;
import school.service.professor.ProfessorAutoDepNumService;
import school.service.profpage.ProfpageInfoService;
import school.service.profpage.ProfpagePwService;
import school.service.profpage.ProfpageUpdateService;

@Controller
@RequestMapping("profpage")
public class ProfpageController {
	@Autowired
	ProfpageInfoService profpageInfoService;
	@Autowired
	ProfpageUpdateService profpageUpdateService;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	EmailCheckModifyService emailCheckModifyService;
	@Autowired
	ProfessorAutoDepNumService professorAutoDepNumService;
	@Autowired
	ProfpagePwService profpagePwService;
	
	@ModelAttribute
	ProfessorCommand setProfessorCommand() {
		return new ProfessorCommand();
	}
	
	@RequestMapping(value="passwordProCon", method=RequestMethod.POST)
	public String memberPassModify(@RequestParam(value="professorPw") String oldPw, 
			@RequestParam(value="newprofessorPw") String newPw, @RequestParam(value="newprofessorPwCon") String newPwCon,
			HttpSession session, Model model) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo"); 
		
		if(passwordEncoder.matches(oldPw, authInfo.getUserPw())) {
			if(newPw.equals(newPwCon) && !newPw.isEmpty()) {
				newPw = passwordEncoder.encode(newPw);
				profpagePwService.execute(authInfo.getUserId(), newPw);
				authInfo.setUserPw(newPw);
				return "redirect:profDetail";
			}else {
				model.addAttribute("err_pwCon", "비밀번호 확인이 틀립니다.");
				return "thymeleaf/profpage/profPassCon";
			}
		}else {
			model.addAttribute("err_pw", "비밀번호가 틀립니다. ");
			return "thymeleaf/profpage/profPassCon";
		}
	}
	
	@RequestMapping(value="passwordPro", method=RequestMethod.POST)
	public String empPasswordPro(@RequestParam(value="empPw") String pw, HttpSession session, Model model) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		if(passwordEncoder.matches(pw, authInfo.getUserPw())) {
			return "thymeleaf/profpage/profPassCon";
		}else {
			model.addAttribute("err_pw", "비밀번호가 틀립니다. ");
			return "thymeleaf/profpage/profPass";
		}
	}
	
	@RequestMapping("profpagePwModify")
	public String profpagePwModify() {
		return "thymeleaf/profpage/profPass";
	}
	
	@RequestMapping(value="profUpdate", method = RequestMethod.POST  )
	public String profUpdate(@Validated ProfessorCommand professorCommand, BindingResult result, Model model){
		professorAutoDepNumService.execute(model);
		if(result.hasErrors()) {
			return "thymeleaf/profpage/profModify";
		}
		Integer i = emailCheckModifyService.execute(professorCommand);
		if(i == 1) {
			result.rejectValue("professorEmail", "professorCommand.professorEmail", "중복이메일입니다.");
			return "thymeleaf/profpage/profModify";
		}
		profpageUpdateService.execute(professorCommand);
		return "redirect:profDetail";
	}
	
	@RequestMapping("profpageModify")
	public String profModify(Model model, HttpSession session) {
		profpageInfoService.execute(model, session);
		return "thymeleaf/profpage/profModify";
	}
	
	@RequestMapping("profDetail")
	public String profDetail(Model model, HttpSession session) {
		profpageInfoService.execute(model, session);
		return "thymeleaf/profpage/profDetail";
	}
}
