package spring.dependenyTest5.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import spring.dependenyTest5.DTO.MemberDTO;
import spring.dependenyTest5.DTO.MemberDao;

public class MemberListPrinter {
	@Autowired
	MemberDao memberDao;
	MemberPrinter print;
	
	public void printAll() {
		Collection<MemberDTO> lists = memberDao.selectAll();
		for(MemberDTO dto : lists) {
			print.print(dto);
		}
	}
}