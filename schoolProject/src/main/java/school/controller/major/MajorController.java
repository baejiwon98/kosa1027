package school.controller.major;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import school.command.MajorCommand;
import school.service.major.MajorAutoNumServiece;
import school.service.major.MajorDeleteService;
import school.service.major.MajorInfoService;
import school.service.major.MajorInsertService;
import school.service.major.MajorListService;
import school.service.major.MajorUpdateService;

@Controller
@RequestMapping("major")
public class MajorController {
	@Autowired
	MajorInsertService majorInsertService;
	@Autowired
	MajorAutoNumServiece majorAutoNumService;
	@Autowired
	MajorListService majorListService;
	@Autowired
	MajorInfoService majorInfoService;
	@Autowired
	MajorUpdateService majorUpdateService;
	@Autowired
	MajorDeleteService majorDeleteService;
	
	@RequestMapping("majorDelete/{departmentNum}")
	public String majorDelete(@PathVariable(value="departmentNum") String departmentNum) {
		majorDeleteService.execute(departmentNum);
		return "redirect:../majorList";
	}
	
	@RequestMapping(value = "majorUpdate", method=RequestMethod.POST)
	public String majorUpdate1(@ModelAttribute MajorCommand majorCommand, BindingResult result, Model model) {
		majorUpdateService.execute(majorCommand, model);
		String addr = majorCommand.getDepartmentNum();
		return "redirect:majorInfo/"+addr;
	}
	
	@RequestMapping(value = "majorUpdate/{departmentNum}", method=RequestMethod.GET)
	public String majorUpdate(@PathVariable(value="departmentNum") String departmentNum, Model model) {
		majorInfoService.execute(departmentNum, model);
		return "thymeleaf/major/majorUpdate";
	}
	
	@RequestMapping("majorInfo/{departmentNum}")
	public String majorInfo(@PathVariable(value="departmentNum") String departmentNum, Model model) {
		majorInfoService.execute(departmentNum, model);
		return "thymeleaf/major/majorInfo";
	}
	
	@RequestMapping("majorList")
	public String majorList(Model model) {
		majorListService.execute(model);
		return "thymeleaf/major/majorList";
	}
	
	@RequestMapping(value = "majorInsert", method = RequestMethod.GET)
	public String majorInsert(MajorCommand majorCommand, Model model) {
		majorAutoNumService.execute(majorCommand, model);
		return "thymeleaf/major/majorInsert";
	}
	
	@RequestMapping(value = "majorInsert", method = RequestMethod.POST)
	public String majorWrite(@Validated MajorCommand majorCommand, BindingResult result) {
		if(result.hasErrors()) {
			return "thymeleaf/major/majorInsert";
		}
		majorInsertService.execute(majorCommand);
		return "redirect:majorList";
	}
}
