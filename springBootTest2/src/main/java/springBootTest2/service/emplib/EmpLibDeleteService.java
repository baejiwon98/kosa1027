package springBootTest2.service.emplib;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.command.EmpLibCommand;
import springBootTest2.domain.AuthInfo;
import springBootTest2.domain.EmpLibDTO;
import springBootTest2.domain.MemberDTO;
import springBootTest2.mapper.EmpLibMapper;

@Component
@Service
public class EmpLibDeleteService {
	@Autowired
	EmpLibMapper empLibMapper;
	public String execute(EmpLibCommand emplibCommand, HttpSession session, Model model) {
		String path = null;
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		EmpLibDTO dto = empLibMapper.selectOne(emplibCommand.getLibNum());
		model.addAttribute("dto", dto);
		
		dto.setEmpId(authInfo.getUserId());
				
		if(!dto.getLibPw().equals(emplibCommand.getLibPw()) || 
				!dto.getEmpNum().equals(empLibMapper.empnumGenerate(dto))) {
			model.addAttribute("err_pw","비밀번호가 틀리거나 작성자가 아닙니다.");
			path = "thymeleaf/emplib/emplibInfo";
		}else {
			empLibMapper.empLibDelete(dto.getLibNum());
			path = "redirect:emplibList";
		}
		
		return path;
	}
}
