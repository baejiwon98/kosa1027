package springBootTest2.service.emplib;

import java.io.File;

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
			Integer i = empLibMapper.empLibDelete(dto.getLibNum());
			if(i > 0) {
				String storeFileNames[] = dto.getStoreFileName().split("`");
				String fileDir = session.getServletContext().getRealPath("/view/empLib");
				for(String fileName : storeFileNames) {
					File file = new File(fileDir + "/" + fileName);
					if(file.exists())file.delete();
				}
			}
			path = "redirect:emplibList";
		}
		
		return path;
	}
}
