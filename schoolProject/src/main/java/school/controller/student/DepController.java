package school.controller.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import school.command.StudentCommand;
import school.service.student.StudentDepNumService;

@RestController
public class DepController {
	@Autowired
	StudentDepNumService studentDepNumService;
	
	@RequestMapping("student/depNum")
	public String depNum(StudentCommand studentCommand) {
		String studentNum = studentDepNumService.execute(studentCommand);
		return studentNum;
	}
}
