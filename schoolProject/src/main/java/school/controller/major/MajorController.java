package school.controller.major;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@ModelAttribute
	MajorCommand setMajorCommand() {
		return new MajorCommand();
	}
	
	@RequestMapping("majorDelete")
	public String majorDelete(@RequestParam(value="num") String departmentNum) {
		majorDeleteService.execute(departmentNum);
		return "redirect:majorList";
	}
	
	@RequestMapping(value = "majorUpdate", method=RequestMethod.POST)
	public String majorUpdate1(@Validated MajorCommand majorCommand, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "thymeleaf/major/majorUpdate";
		}
		majorUpdateService.execute(majorCommand, model);
		return "redirect:majorInfo?num="+majorCommand.getDepartmentNum();
	}
	
	@RequestMapping("majorModify")
	public String majorUpdate(@RequestParam(value="num") String departmentNum, Model model) {
		majorInfoService.execute(departmentNum, model);
		return "thymeleaf/major/majorUpdate";
	}
	
	@RequestMapping("majorInfo")
	public String majorInfo(@RequestParam(value="num") String departmentNum, Model model) {
		majorInfoService.execute(departmentNum, model);
		return "thymeleaf/major/majorInfo";
	}
	
	@RequestMapping("majorList")
	public String majorList(Model model , @RequestParam(value="page", defaultValue = "1", required = false) Integer page) {
		majorListService.execute(model,page);
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
