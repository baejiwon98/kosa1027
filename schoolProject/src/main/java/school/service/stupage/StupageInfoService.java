package school.service.stupage;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import school.domain.AuthInfo;
import school.domain.MajorDTO;
import school.domain.StudentDTO;
import school.mapper.StupageMapper;

@Service
public class StupageInfoService {
	@Autowired
	StupageMapper stupageMapper;

	public void execute(Model model, HttpSession session) {
		List<MajorDTO> list = stupageMapper.selectDepartment();
		model.addAttribute("list", list);
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String studentId = authInfo.getUserId();
		StudentDTO dto = stupageMapper.selectOne(studentId);
		model.addAttribute("studentCommand", dto);
		
	}
	
	
}
