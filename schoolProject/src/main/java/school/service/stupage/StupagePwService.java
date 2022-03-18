package school.service.stupage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.domain.StudentDTO;
import school.mapper.StupageMapper;

@Service
public class StupagePwService {
	@Autowired
	StupageMapper stupageMapper;
	
	public void execute(String userId, String newPw) {
		StudentDTO dto = new StudentDTO();
		dto.setStudentId(userId);
		dto.setStudentPw(newPw);
		stupageMapper.updatePassword(dto);
	}

}
