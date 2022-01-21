package springBootTest2.service.emplib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.command.EmpLibCommand;
import springBootTest2.domain.AuthInfo;
import springBootTest2.domain.EmpLibDTO;
import springBootTest2.mapper.EmpLibMapper;

@Component
@Service
public class EmpLibUpdateService {
	@Autowired
	EmpLibMapper emplibMapper;
	public String execute(EmpLibCommand emplibCommand, HttpSession session, Model model, HttpServletRequest request) {
		String path = "redirect:emplibDetail?num="+emplibCommand.getLibNum();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		EmpLibDTO dto = emplibMapper.selectOne(emplibCommand.getLibNum());
		
		dto.setEmpId(authInfo.getUserId());
		
		if(!dto.getLibPw().equals(emplibCommand.getLibPw()) || 
				!dto.getEmpNum().equals(emplibMapper.empnumGenerate(dto))) {
			model.addAttribute("dto", emplibCommand);
			model.addAttribute("err_pw","비밀번호가 틀리거나 작성자가 아닙니다.");
			path = "thymeleaf/emplib/emplibModify";
		}
		else {
			dto.setLibContent(emplibCommand.getLibContent());
			dto.setLibNum(emplibCommand.getLibNum());
			dto.setLibSubject(emplibCommand.getLibSubject());
			dto.setLibWriter(emplibCommand.getLibWriter());
			dto.setIpAddr(request.getRemoteAddr());
			dto.setEmpId(authInfo.getUserId());
//			dto.setEmpNum(emplibMapper.empnumGenerate(dto));
			
			emplibMapper.empLibUpdate(dto);
		}
		return path;
	}
}
