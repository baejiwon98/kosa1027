package springBootTest2.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MemberCommand {
	String memName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date memBirth;
	String memGender;
	String memId;
	String memPw;
	String memPwCon;
	String memPhone1;
	String memPhone2;
	String memAddr;
	String memEmail;
	String memNum;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date memRegiDate;
}
