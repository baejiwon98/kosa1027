package school.service.major;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.command.MajorCommand;
import school.domain.MajorDTO;
import school.mapper.MajorMapper;

@Service
public class MajorInsertService {
	@Autowired
	MajorMapper majorMapper;
	public void execute(MajorCommand majorCommand) {
		MajorDTO dto = new MajorDTO();
		dto.setDepartmentNum(majorCommand.getDepartmentNum());
		dto.setDepartmentName(majorCommand.getDepartmentName());
		dto.setZip(majorCommand.getZip());
		dto.setFullAddr(majorCommand.getFullAddr());
		dto.setAddr1(majorCommand.getAddr1());
		dto.setAddr2(majorCommand.getAddr2());
		dto.setDetailAddr(majorCommand.getDetailAddr());
		dto.setDepartmentAddr(majorCommand.getFullAddr() +" "+majorCommand.getAddr2()+" "+majorCommand.getDetailAddr());
		dto.setDepartmentPhone(majorCommand.getDepartmentPhone());
		
		majorMapper.majorInsert(dto);
	}

}
