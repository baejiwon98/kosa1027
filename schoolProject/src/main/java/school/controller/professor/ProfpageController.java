package school.controller.professor;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import school.command.ProfessorCommand;
import school.domain.AuthInfo;
import school.service.profpage.ProfpageInfoService;
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
	
	@RequestMapping(value="empPasswordPro", method=RequestMethod.POST)
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
	public String profUpdate(ProfessorCommand professorCommand){
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
