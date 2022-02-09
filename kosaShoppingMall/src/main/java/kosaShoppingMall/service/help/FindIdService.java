package kosaShoppingMall.service.help;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import kosaShoppingMall.command.FindIdCommand;
import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.mapper.LoginMapper;

@Component
@Service
public class FindIdService {
	@Autowired
	LoginMapper loginMapper;
	public String execute(FindIdCommand findIdCommand, BindingResult result, Model model) {
		AuthInfo authInfo = loginMapper.findId(findIdCommand.getMemEmail());
		
		if(authInfo == null) {
			result.rejectValue("memEmail", "findIdCommand.memEmail", "이메일이 틀렸습니다.");
			return "thymeleaf/help/findId";	
		}else {
			if(authInfo.getPhone().equals(findIdCommand.getMemPhone())) {
				model.addAttribute("userId", authInfo.getUserId());
				return "thymeleaf/help/findIdOk";	
			}else {
				//result.rejectValue("memPhone", "findIdCommand.memPhone", "연락처가 틀렸습니다.");
				result.rejectValue("memPhone", "bad");
				return "thymeleaf/help/findId";	
			}
		}
	}
}
