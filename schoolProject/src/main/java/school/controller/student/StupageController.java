package school.controller.student;

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

import school.command.StudentCommand;
import school.domain.AuthInfo;
import school.service.check.EmailStuCheckModifyService;
import school.service.student.StudentAutoNumService;
import school.service.stupage.StupageInfoService;
import school.service.stupage.StupagePwService;
import school.service.stupage.StupageUpdateService;

@Controller
@RequestMapping("stupage")
public class StupageController {
	@Autowired
	StupageInfoService stupageInfoService;
	@Autowired
	StupageUpdateService stupageUpdateService;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	EmailStuCheckModifyService emailStuCheckModifyService;
	@Autowired
	StudentAutoNumService studentAutoNumService;
	@Autowired
	StupagePwService stupagePwService;
	
	@ModelAttribute
	StudentCommand setStudentCommand() {
		return new StudentCommand();
	}
	
	@RequestMapping(value="passwordStuCon", method=RequestMethod.POST)
	public String memberPassModify(@RequestParam(value="studentPw") String oldPw, 
			@RequestParam(value="newstudentPw") String newPw, @RequestParam(value="newstudentPwCon") String newPwCon,
			HttpSession session, Model model) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo"); 
		
		if(passwordEncoder.matches(oldPw, authInfo.getUserPw())) {
			if(newPw.equals(newPwCon) && !newPw.isEmpty()) {
				newPw = passwordEncoder.encode(newPw);
				stupagePwService.execute(authInfo.getUserId(), newPw);
				authInfo.setUserPw(newPw);
				return "redirect:stuDetail";
			}else {
				model.addAttribute("err_pwCon", "비밀번호 확인이 틀립니다.");
				return "thymeleaf/stupage/stuPassCon";
			}
		}else {
			model.addAttribute("err_pw", "비밀번호가 틀립니다. ");
			return "thymeleaf/stupage/stuPassCon";
		}
	}
	
	@RequestMapping(value="passwordStu", method=RequestMethod.POST)
	public String empPasswordStu(@RequestParam(value="empPw") String pw, HttpSession session, Model model) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		if(passwordEncoder.matches(pw, authInfo.getUserPw())) {
			return "thymeleaf/stupage/stuPassCon";
		}else {
			model.addAttribute("err_pw", "비밀번호가 틀립니다. ");
			return "thymeleaf/stupage/stuPass";
		}
	}
	
	@RequestMapping("stupagePwModify")
	public String stupagePwModify() {
		return "thymeleaf/stupage/stuPass";
	}
	
	@RequestMapping(value="stuUpdate", method = RequestMethod.POST  )
	public String stuUpdate(@Validated StudentCommand studentCommand, BindingResult result, Model model){
		studentAutoNumService.execute(model);
		if(result.hasErrors()) {
			return "thymeleaf/stupage/stuModify";
		}
		Integer i = emailStuCheckModifyService.execute(studentCommand);
		if(i == 1) {
			result.rejectValue("studentEmail", "studentCommand.studentEmail", "중복이메일입니다.");
			return "thymeleaf/stupage/stuModify";
		}
		stupageUpdateService.execute(studentCommand);
		return "redirect:stuDetail";
	}
	
	@RequestMapping("stupageModify")
	public String stuModify(Model model, HttpSession session) {
		stupageInfoService.execute(model, session);
		return "thymeleaf/stupage/stuModify";
	}
	
	@RequestMapping("stuDetail")
	public String stuDetail(Model model, HttpSession session) {
		stupageInfoService.execute(model, session);
		return "thymeleaf/stupage/stuDetail";
	}
}
