package school.service.profsubject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.command.ProfSubjectCommand;
import school.domain.ProfSubjectDTO;
import school.mapper.ProfSubjectMapper;

@Service
public class ProfSubjectInsertService {
	@Autowired
	ProfSubjectMapper profSubjectMapper;
		
	public void execute(ProfSubjectCommand profSubjectCommand) {
		ProfSubjectDTO dto = new ProfSubjectDTO();
		dto.setProfessorNum(profSubjectCommand.getProfessorNum());
		dto.setSubjectNum(profSubjectCommand.getSubjectNum());
		dto.setStatus(profSubjectCommand.getStatus());
		
		profSubjectMapper.profSubjInsert(dto);
	}

}
