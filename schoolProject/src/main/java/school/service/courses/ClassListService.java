package school.service.courses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import school.domain.MajorDTO;
import school.domain.StartEndPageDTO;
import school.mapper.MajorMapper;

@Service
public class ClassListService {
	@Autowired
	MajorMapper majorMapper;
	public void execute(Model model) {
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO();
		List<MajorDTO> list = majorMapper.selectAll(startEndPageDTO);
		model.addAttribute("list", list);
		
	}

}
