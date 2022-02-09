package kosaShoppingMall.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.command.MemberCommand;
import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.mapper.MemberMapper;

@Component
@Service
public class MemberDeleteService {
	@Autowired
	MemberMapper memberMapper;
	public void execute(String memNum, Model model) {
		Integer i = memberMapper.memberDelete(memNum);
		model.addAttribute("memNum", i);
	}
}