package school.service.courses;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import school.domain.AuthInfo;
import school.domain.CourseDTO;
import school.mapper.ClassMapper;

@Service
public class ClassWishListService {
	@Autowired
	ClassMapper classMapper;
	
	public void execute(Model model, HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		List<CourseDTO> list = classMapper.selectAll(authInfo.getUserNum());
		model.addAttribute("list", list);
		
	}

}
