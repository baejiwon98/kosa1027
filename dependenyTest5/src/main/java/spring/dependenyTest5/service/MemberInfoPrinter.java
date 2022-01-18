package spring.dependenyTest5.service;

import org.springframework.beans.factory.annotation.Autowired;

import spring.dependenyTest5.DTO.MemberDTO;
import spring.dependenyTest5.DTO.MemberDao;

public class MemberInfoPrinter {
	@Autowired
	MemberDao memberDao;
	MemberPrinter print= new MemberPrinter();
	
	public void execute(String email) {
		MemberDTO dto = memberDao.selectByEmail(email);
		if(dto == null) {
			System.out.println("데이터 없음\n");
			return;
		}
		print.print(dto);
	}
}