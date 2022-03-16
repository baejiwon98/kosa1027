package school.service.profpage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.command.ProfessorCommand;
import school.domain.ProfessorDTO;
import school.mapper.ProfpageMapper;

@Service	
public class ProfpageUpdateService {
	@Autowired
	ProfpageMapper profpageMapper;
	
	public void execute(ProfessorCommand professorCommand) {
		ProfessorDTO dto = profpageMapper.selectOne(professorCommand.getProfessorId());
		dto.setDepartmentNum(professorCommand.getDepartmentNum());
		dto.setProfessorEmail(professorCommand.getProfessorEmail());
		dto.setProfessorId(professorCommand.getProfessorId());
		dto.setProfessorName(professorCommand.getProfessorName());
		dto.setProfessorNum(professorCommand.getProfessorNum());
		dto.setProfessorPhone(professorCommand.getProfessorPhone());
		
		profpageMapper.profUpdate(dto);
		
	}

}
