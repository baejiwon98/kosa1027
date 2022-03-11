package school.service.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.mapper.SubjectMapper;

@Service
public class SubjectDeleteService {
	@Autowired
	SubjectMapper subjectMapper;

	public void execute(String subjectNum) {
		subjectMapper.subjectDelete(subjectNum);		
	}
}
