package school.service.major;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import school.command.MajorCommand;
import school.domain.MajorDTO;
import school.mapper.MajorMapper;

@Service
public class MajorUpdateService {
	@Autowired
	MajorMapper majorMapper;
	public void execute(MajorCommand majorCommand, Model model) {
		MajorDTO dto = majorMapper.selectOne(majorCommand.getDepartmentNum());
		
		dto.setDepartmentNum(majorCommand.getDepartmentNum());
		dto.setFullAddr(majorCommand.getFullAddr());
		dto.setZip(majorCommand.getZip());
		dto.setAddr1(majorCommand.getAddr1());
		dto.setAddr2(majorCommand.getAddr2());
		dto.setDetailAddr(majorCommand.getDetailAddr());
		dto.setDepartmentAddr(majorCommand.getFullAddr()+" "+majorCommand.getAddr2()+" "+majorCommand.getDetailAddr());
		dto.setDepartmentPhone(majorCommand.getDepartmentPhone());
		dto.setDepartmentName(majorCommand.getDepartmentName());
		
		majorMapper.majorUpdate(dto);
	}
	
}
