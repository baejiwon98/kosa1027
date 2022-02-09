package springBootTest2.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import springBootTest2.command.MemberCommand;
import springBootTest2.mapper.MemberMapper;

@Component
@Service
public class MemberNumberService {
	@Autowired
	MemberMapper memberMapper;
	public void execute(MemberCommand memberCommand) {
		String memberNum = memberMapper.numberGenerate();
//		model.addAttribute("memberNum", memberNum);
		memberCommand.setMemNum(memberNum);
	}

}
