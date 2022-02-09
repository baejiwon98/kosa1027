package kosaShoppingMall.service.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.mapper.MembershipMapper;

@Component
@Service
public class MembershipInfoService {
	@Autowired
	MembershipMapper membershipMapper;
	public void execute(Model model, HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String memId = authInfo.getUserId();
		MemberDTO dto = membershipMapper.selectOne(memId);
		model.addAttribute("memberCommand", dto);
	}
}
