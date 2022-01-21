package springBootTest2.service.emplib;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.domain.EmpLibDTO;
import springBootTest2.mapper.EmpLibMapper;

@Component
@Service
public class EmpLibDetailService {
	@Autowired
	EmpLibMapper empLibMapper;
	public void execute(Model model, Integer libNum) {
		EmpLibDTO dto = empLibMapper.selectOne(libNum);
		model.addAttribute("dto", dto);
	}
}
