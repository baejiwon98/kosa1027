package school.service.check;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.command.StudentCommand;
import school.domain.AuthInfo;
import school.mapper.LoginMapper;

@Service
public class EmailStuCheckModifyService {
	@Autowired
	LoginMapper loginMapper;
	
	public Integer execute(StudentCommand studentCommand) {
		AuthInfo authInfo = loginMapper.findId(studentCommand.getStudentEmail());
		System.out.println(studentCommand.getStudentId());
		if(authInfo != null) {
			if(authInfo.getUserId().equals(studentCommand.getStudentId())) {
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
