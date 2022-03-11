package school.service.major;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.mapper.MajorMapper;

@Service
public class MajorDeleteService {
	@Autowired
	MajorMapper majorMapper;
	public void execute(String departmentNum) {
		majorMapper.majorDelete(departmentNum);
	}

}
