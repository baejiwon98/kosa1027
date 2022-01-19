package springBootTest2.service.lib;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.domain.AuthInfo;
import springBootTest2.domain.LibDTO;
import springBootTest2.mapper.LibMapper;

@Component
@Service
public class LibModifyService {
	@Autowired
	LibMapper libMapper;
	public String execute(Integer libNum, String libPw, Model model, HttpSession session) {
		String path = "thymeleaf/lib/libModify";
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		LibDTO dto = libMapper.selectOne(libNum);
		model.addAttribute("dto", dto);
		if(!dto.getLibPw().equals(libPw) || 
				!dto.getMemId().equals(authInfo.getUserId())) {
			model.addAttribute("err_pw","비밀번호가 틀리거나 작성자가 아닙니다.");
			path = "thymeleaf/lib/libInfo";
		}
		return path;
	}
}
