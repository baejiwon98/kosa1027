package main.service;

import main.DTO.MemberDAO;
import main.DTO.MemberDTO;

public class ChangePasswordService {
	// 의존객체
	MemberDAO memberDao;
	public ChangePasswordService(MemberDAO memberDAO) {
		this.memberDao = memberDao;
	}
	public void execute(String email, String oldPw, String newPw) {
		MemberDTO dto = memberDao.selectByEmail(email);
		if(dto == null) {
			System.out.println("이메일이 존재하지 않습니다.");
			return;
		}
		dto.changePassword(oldPw, newPw);
		memberDao.update(dto);
	}
}
