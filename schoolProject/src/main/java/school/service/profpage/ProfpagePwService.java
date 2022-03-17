package school.service.profpage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.domain.ProfessorDTO;
import school.mapper.ProfpageMapper;

@Service
public class ProfpagePwService {
	@Autowired
	ProfpageMapper profpageMapper;

	public void execute(String userId, String userPw) {
		ProfessorDTO dto = new ProfessorDTO();
		dto.setProfessorId(userId);
		dto.setProfessorPw(userPw);
		profpageMapper.updatePassword(dto);
		
	}

}
