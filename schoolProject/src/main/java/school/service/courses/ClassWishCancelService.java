package school.service.courses;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.mapper.ClassMapper;

@Service
public class ClassWishCancelService {
	@Autowired
	ClassMapper classMapper;
	
	public void execute(String[] cancels) {
		List<String[]> condition = new ArrayList<String[]>();
		
		for(String num : cancels) {
			String [] n = num.split("`");
			condition.add(n);
		}
		
		classMapper.classWishCancels(condition);
		
	}

}
