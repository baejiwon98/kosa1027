package school.service.profsubject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.mapper.ProfSubjectMapper;

@Service
public class ProfSubjectReCancelsService {
	@Autowired
	ProfSubjectMapper profSubjectMapper;

	public void execute(String[] cancels) {
		List<String[]> condition = new ArrayList<String[]>();
		
		for(String num : cancels) {
			String [] n = num.split("`");
			condition.add(n);
		}
		
		profSubjectMapper.profSubjReCancels(condition);
		
	}
}
