package school.service.major;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import school.domain.MajorDTO;
import school.mapper.MajorMapper;

@Component
@Service
public class MajorInfoService {
	@Autowired
	MajorMapper majorMapper;
	public void execute(String departmentNum, Model model) {
		MajorDTO dto = majorMapper.selectOne(departmentNum);
		model.addAttribute("dto", dto);
	}

}
