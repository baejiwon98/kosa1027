package springBootTest2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springBootTest2.command.LibCommand;
import springBootTest2.service.lib.LibDeleteService;
import springBootTest2.service.lib.LibDetailService;
import springBootTest2.service.lib.LibListService;
import springBootTest2.service.lib.LibModifyService;
import springBootTest2.service.lib.LibUpdateService;
import springBootTest2.service.lib.LibWriteService;

@Controller
@RequestMapping("lib")
public class LibraryController {
	@Autowired
	LibWriteService libWriteService;
	@Autowired
	LibListService libListService;
	@Autowired
	LibDetailService libDetailService;
	@Autowired
	LibModifyService libModifyService;
	@Autowired
	LibUpdateService libUpdateService;
	@Autowired
	LibDeleteService libDeleteService ;
		
	@RequestMapping("libDelete")
	public String libDelete(LibCommand libCommand, 
			HttpSession session,Model model) {
		String path = libDeleteService.execute(libCommand,session,model);
		return path;
	}
	
	@RequestMapping(value="libUpdate", method=RequestMethod.POST)
	public String libUpdate(LibCommand libCommand, HttpSession session, Model model) {
		String path = libUpdateService.execute(libCommand, session, model);
		return path;
	}
	
	@RequestMapping("libModify")
	public String libModify(@RequestParam(value="libNum") Integer libNum,
			@RequestParam(value="libPw") String libPw, Model model,
			HttpSession session) {
		String path = libModifyService.execute(libNum,libPw,model,session);
		return path;
	}
	
	@RequestMapping(value = "libDetail", method = RequestMethod.GET)
	public String libDetail(@RequestParam(value = "num") Integer libNum, Model model) {
		libDetailService.execute(model, libNum);
		return "thymeleaf/lib/libInfo";
	}
	
	@RequestMapping("libList")
	public String libList(Model model) {
		libListService.execute(model);
		return "thymeleaf/lib/libList";
	}
	
	@RequestMapping("libWrite")
	public String libWrite(LibCommand libCommand, HttpServletRequest request) {
		libWriteService.execute(libCommand, request);
		return "redirect:libList";
	}
	
	@RequestMapping("libForm")
	public String libForm() {
		return "thymeleaf/lib/libForm";
	}
}
