package springBootTest2.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kosaShoppingMall.command.MemberCommand;
import springBootTest2.service.login.LoginService;

@Controller
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@ModelAttribute
	public LoginCommand getLoginCommand() {
		return new LoginCommand();
	}
	
	@RequestMapping(value = "/loginPro", method = RequestMethod.GET)
	public String home() {
		return "redirect:/";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value = "/loginPro",  method = RequestMethod.POST )
	public String loginPro(@RequestParam(value="id") String id,
			@RequestParam(value="pw") String pw, HttpSession session , Model model) {
		String path = loginService.execute(id, pw, session, model);
		return path;
	}
}
