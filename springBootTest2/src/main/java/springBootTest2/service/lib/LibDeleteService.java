package springBootTest2.service.lib;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.command.LibCommand;
import springBootTest2.domain.AuthInfo;
import springBootTest2.domain.LibDTO;
import springBootTest2.mapper.LibMapper;

@Component
@Service
public class LibDeleteService {
	@Autowired
	LibMapper libMapper;
	public String execute(LibCommand libCommand, HttpSession session, Model model) {
		String path = null;
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		LibDTO dto = libMapper.selectOne(libCommand.getLibNum());
		model.addAttribute("dto", dto);
		if(!dto.getLibPw().equals(libCommand.getLibPw()) || 
				!dto.getMemId().equals(authInfo.getUserId())) {
			model.addAttribute("err_pw","비밀번호가 틀리거나 작성자가 아닙니다.");
			path = "thymeleaf/lib/libInfo";
		}else {
			Integer i = libMapper.libDelete(libCommand.getLibNum());
			if(i > 0 && dto.getStoreFileName() != null) {
				String [] fileNames = dto.getStoreFileName().split("`");
				String filePath = "/view/lib";
				String fileDir = session.getServletContext()
										.getRealPath(filePath);
				File file = null;
				try {
					for (String fileName : fileNames) {
						file = new File(fileDir + "/" + fileName);
						if(file.exists()) file.delete();
					}
				} catch(Exception e) {}
			}
			path = "redirect:libList";
		}
		return path;
	}
}
