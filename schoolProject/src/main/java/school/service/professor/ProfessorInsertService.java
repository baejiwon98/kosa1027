package school.service.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import school.command.ProfessorCommand;
import school.domain.ProfessorDTO;
import school.mapper.ProfessorMapper;

@Service
public class ProfessorInsertService {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	ProfessorMapper professorMapper;
	
	public void execute(ProfessorCommand professorCommand, BindingResult result, Model model) {
		String proPw = passwordEncoder.encode(professorCommand.getProfessorPw());
		System.out.println(proPw);
		ProfessorDTO dto = new ProfessorDTO();
		dto.setProfessorNum(professorCommand.getProfessorNum());
		dto.setDepartmentNum(professorCommand.getDepartmentNum());
		dto.setProfessorId(professorCommand.getProfessorId());
		dto.setProfessorPw(proPw);
		dto.setProfessorName(professorCommand.getProfessorName());		
		dto.setProfessorPhone(professorCommand.getProfessorPhone());
		dto.setProfessorEmail(professorCommand.getProfessorEmail());
		
		professorMapper.professorInsert(dto);
	}

}
