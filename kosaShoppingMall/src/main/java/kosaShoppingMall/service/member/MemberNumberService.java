package kosaShoppingMall.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.command.MemberCommand;
import kosaShoppingMall.mapper.MemberMapper;

@Component
@Service
public class MemberNumberService {
	@Autowired
	MemberMapper memberMapper;
	public void execute(MemberCommand memberCommand, Model model) {
		String memNum = memberMapper.numberGenerate();
//		model.addAttribute("memNum", memNum);
		memberCommand.setMemNum(memNum);
	}
}