package school.service.profsubject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.mapper.ProfSubjectMapper;

@Service
public class ProfSubjectDelsService {
	@Autowired
	ProfSubjectMapper profSubjectMapper;
	
	public void execute(String[] deletes) {
		List<String[]> condition = new ArrayList<String[]>();
		
		for(String num : deletes) {
			String [] n = num.split("`");
			condition.add(n);
		}
		
		profSubjectMapper.profSubjDels(condition);
		
	}

}
