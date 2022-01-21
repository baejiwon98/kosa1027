package springBootTest2.service.emplib;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.domain.AuthInfo;
import springBootTest2.domain.EmpLibDTO;
import springBootTest2.mapper.EmpLibMapper;

@Component
@Service
public class EmpLibModifyService {
	@Autowired
	EmpLibMapper emplibMapper;
	public String execute(Integer libNum, String libPw, Model model, HttpSession session) {
		String path = "thymeleaf/emplib/emplibModify";
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		EmpLibDTO dto = emplibMapper.selectOne(libNum);
		
		dto.setEmpId(authInfo.getUserId());
		
		model.addAttribute("dto", dto);
		if(!dto.getLibPw().equals(libPw) || 
				!dto.getEmpNum().equals(emplibMapper.empnumGenerate(dto))) {
			model.addAttribute("err_pw","비밀번호가 틀리거나 작성자가 아닙니다.");
			path = "thymeleaf/emplib/emplibInfo";
		}
		return path;
	}
}
