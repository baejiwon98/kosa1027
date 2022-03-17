package school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import school.command.ProfessorCommand;
import school.service.check.EmailCheckModifyService;
import school.service.check.EmailCheckService;
import school.service.check.IdcheckService;

@RestController
public class CheckController {
	@Autowired
	IdcheckService idcheckService;
	@Autowired
	EmailCheckService emailCheckService;
	@Autowired
	EmailCheckModifyService emailCheckModifyService;
	
	@RequestMapping(value="/professor/emailCheckModify", method=RequestMethod.POST)
	public String emailCheckModify(ProfessorCommand professorCommand) {
		Integer i = emailCheckModifyService.execute(professorCommand);
		if(i == 0) {
			return "사용 가능한 email 입니다.";
		}else {
			return "사용 중인 Email입니다.";
		}
	}
	
	@RequestMapping(value="/professor/emailCheck", method=RequestMethod.POST)
	public String emailCheck(@RequestParam(value="professorEmail") String professorEmail) {
		Integer i = emailCheckService.execute(professorEmail);
		if(i == 0) {
			return "사용 가능한 email 입니다.";
		}else {
			return "사용 중인 Email입니다.";
		}
	}
	
	@RequestMapping(value="/professor/idCheck", method=RequestMethod.POST)
	public String idCheck(@RequestParam(value="professorId") String professorId) {
		Integer i = idcheckService.execute(professorId);
		if(i == 0) {
			return "사용 가능한 id입니다.";
		}else {
			return "사용 중인 id입니다.";
		}
	}
}
