package springBootTest2.service.lib;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.command.LibCommand;
import springBootTest2.domain.LibDTO;
import springBootTest2.mapper.LibMapper;

@Component
@Service
public class LibWriteService {
	@Autowired
	LibMapper libMapper;
	public void execute(LibCommand libCommand, HttpServletRequest request) {
		LibDTO dto = new LibDTO();
		dto.setLibNum(libCommand.getLibNum());
		dto.setLibWriter(libCommand.getLibWriter());
		dto.setLibSubject(libCommand.getLibSubject());
		dto.setLibContent(libCommand.getLibContent());
		dto.setIpAddr(request.getRemoteAddr());
		dto.setLibPw(libCommand.getLibPw());
		
		libMapper.libInsert(dto);
		
	}
}
