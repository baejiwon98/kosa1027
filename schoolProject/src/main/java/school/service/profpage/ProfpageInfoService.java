package school.service.profpage;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import school.domain.AuthInfo;
import school.domain.MajorDTO;
import school.domain.ProfessorDTO;
import school.mapper.ProfpageMapper;

@Service
public class ProfpageInfoService {
	@Autowired
	ProfpageMapper profpageMapper;
	
	public void execute(Model model, HttpSession session) {
		List<MajorDTO> list = profpageMapper.selectDepartment();
		model.addAttribute("list", list);
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String profId = authInfo.getUserId();
		ProfessorDTO dto = profpageMapper.selectOne(profId);
		model.addAttribute("professorCommand", dto);
		
	}

}
