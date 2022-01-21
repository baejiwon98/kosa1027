package springBootTest2.service.emplib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import springBootTest2.command.EmpLibCommand;
import springBootTest2.domain.AuthInfo;
import springBootTest2.domain.EmpLibDTO;
import springBootTest2.mapper.EmpLibMapper;

@Component
@Service
public class EmpLibWriteService {
	@Autowired
	EmpLibMapper empLibMapper;
	public void execute(EmpLibCommand empLibCommand, HttpServletRequest request) {
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");	
		
		EmpLibDTO dto = new EmpLibDTO();
		
		dto.setEmpId(authInfo.getUserId());
		
		dto.setEmpNum(empLibMapper.empnumGenerate(dto));
		dto.setLibWriter(empLibCommand.getLibWriter());
		dto.setLibSubject(empLibCommand.getLibSubject());
		dto.setLibContent(empLibCommand.getLibContent());
		dto.setLibPw(empLibCommand.getLibPw());
		dto.setIpAddr(request.getRemoteAddr());
		
		empLibMapper.empLibInsert(dto);
		
	}
}
