package school.service.check;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.domain.AuthInfo;
import school.mapper.LoginMapper;

@Service
public class IdcheckService {
	@Autowired
	LoginMapper loginMapper;
	
	public Integer execute(String professorId) {
		AuthInfo authInfo = loginMapper.loginSelect(professorId);
		if(authInfo != null) {
			return 1;
		}else {
			return 0;
		}
	}

}
