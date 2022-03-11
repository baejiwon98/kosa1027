package school.service.major;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import school.command.MajorCommand;
import school.mapper.MajorMapper;

@Component
@Service
public class MajorAutoNumServiece {
	@Autowired
	MajorMapper majorMapper;
	public void execute(MajorCommand majorCommand, Model model) {
		String departmentNum = majorMapper.autoNum();
		majorCommand.setDepartmentNum(departmentNum);
	}
}
