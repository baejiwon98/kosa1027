package school.service.courses;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import school.domain.AuthInfo;
import school.domain.SubjectDTO;
import school.mapper.MajorMapper;

@Service
public class ClassSubjectService {
	@Autowired
	MajorMapper majorMapper;
	
	public void execute(String departmentNum, HttpSession session, Model model) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String studentNum = authInfo.getUserNum();
		String departmentNum1 = studentNum.substring(2, studentNum.length() -5);
		List<SubjectDTO> list = majorMapper.selectSubject(departmentNum);
		model.addAttribute("list", list);
		
		
	}	
}
