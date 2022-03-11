package school.service.major;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import school.domain.MajorDTO;
import school.mapper.MajorMapper;

@Service
public class MajorListService {
	@Autowired
	MajorMapper majorMapper;
	public void execute(Model model) {
		List<MajorDTO> list = majorMapper.selectAll();
		model.addAttribute("list", list);
	}
	
}
