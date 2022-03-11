package school.service.professor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import school.domain.ProfessorDTO;
import school.domain.StartEndPageDTO;
import school.mapper.ProfessorMapper;

@Service
public class ProfessorListService {
	@Autowired
	ProfessorMapper professorMapper;
	
	public void execute(Model model, Integer page) {
		int limit = 3;
		int limitPage = 10;
		
		Long startRow = ((long)page - 1) * limit +1;
		Long endRow = startRow + limit - 1;
		StartEndPageDTO dto = new StartEndPageDTO();
		dto.setStartRow(startRow);
		dto.setEndRow(endRow);
		
		int count = professorMapper.professorCount();		
		List<ProfessorDTO> list = professorMapper.selectAll(dto);
		
		int maxPage = (int)((double)count / limit + 0.9);
		
		int startPage = ((int)((double)page / limitPage + 0.9) -1) * limitPage + 1;
		// 								24 / 10 = 2.4 + 0.9 = 3.3 => 3 - 1 = 2 * 10 + 1 = 21
		int endPage = startPage + limitPage - 1;
		if(endPage > maxPage) endPage = maxPage;
		
		model.addAttribute("count", count);
		model.addAttribute("list", list);
		
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		model.addAttribute("page", page);
		
	}
	
}
