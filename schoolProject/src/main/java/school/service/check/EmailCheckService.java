package school.service.check;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.domain.AuthInfo;
import school.mapper.LoginMapper;
import school.mapper.ProfessorMapper;

@Service
public class EmailCheckService {
	@Autowired
	LoginMapper loginMapper;
	
	public Integer execute(String professorEmail) {
		AuthInfo authInfo = loginMapper.findId(professorEmail);
		if(authInfo != null) {
			return 1;
		}else {
			return 0;
		}
	}

}
