package main.service;

import main.DTO.MemberDAO;

public class Assembler { // 객체 조립기
	MemberDAO memberDao;
	MemberPrinter printer;
	MemberRegisterService memberRegisterService;
	MemberListPrinter memberListPrinter;
	ChangePasswordService changerPasswordService;
	MemberInfoPrinter memberInfoPrinter;
	public Assembler() {
		this.memberDao = new MemberDAO();
		this.printer = new MemberPrinter();
		this.memberRegisterService = new MemberRegisterService(memberDao);
		this.memberListPrinter = new MemberListPrinter(memberDao, printer);
		this.memberInfoPrinter = new MemberInfoPrinter(memberDao);
	}
	public MemberDAO getMemberDao() {
		return memberDao;
	}
	public MemberPrinter getPrinter() {
		return printer;
	}
	public MemberRegisterService getMemberRegisterService() {
		return memberRegisterService;
	}
	public MemberListPrinter getMemberListPrinter() {
		return memberListPrinter;
	}
	public ChangePasswordService getChangerPasswordService() {
		return changerPasswordService;
	}
	public MemberInfoPrinter getMemberInfoPrinter() {
		return memberInfoPrinter;
	}
}
