package springBootTest2.service.lib;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.domain.LibDTO;
import springBootTest2.mapper.LibMapper;

@Component
@Service
public class LibDetailService {
	@Autowired
	LibMapper libMapper;
	public void execute(Model model, Integer libNum) {
		LibDTO dto = libMapper.selectOne(libNum);
		model.addAttribute("dto", dto);
	}
}
