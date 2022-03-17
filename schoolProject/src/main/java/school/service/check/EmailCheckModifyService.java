package school.service.check;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.command.ProfessorCommand;
import school.domain.AuthInfo;
import school.mapper.LoginMapper;

@Service
public class EmailCheckModifyService {
	@Autowired
	LoginMapper loginMapper;
	public Integer execute(ProfessorCommand professorCommand) {
		AuthInfo authInfo = loginMapper.findId(professorCommand.getProfessorEmail());
		System.out.println(professorCommand.getProfessorId());
		if(authInfo != null) {
			if(authInfo.getUserId().equals(professorCommand.getProfessorId())) {
				return 0; // 사용가능한 이메일
			}
			else {
				return 1; // 불가능한 아이디
			}
		}else {
			return 0; // 사용가능한 이메일
		}
		
	}
}
