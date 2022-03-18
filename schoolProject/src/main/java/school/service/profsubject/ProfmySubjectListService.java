package school.service.profsubject;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import school.domain.AuthInfo;
import school.domain.ProfSubjectDTO;
import school.mapper.ProfSubjectMapper;

@Service
public class ProfmySubjectListService {
	@Autowired
	ProfSubjectMapper profSubjectMapper;

	public void execute(Model model, HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		System.out.println(authInfo.getUserId());
		String getNum = profSubjectMapper.getNum(authInfo.getUserId());
		System.out.println(getNum);
		List<ProfSubjectDTO> list = profSubjectMapper.selectMyAll(getNum);
		model.addAttribute("list", list);
		
	}

}
