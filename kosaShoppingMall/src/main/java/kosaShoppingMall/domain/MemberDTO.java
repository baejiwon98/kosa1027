package kosaShoppingMall.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Alias(value="memDTO")
public class MemberDTO {
	String memNum;
	String memId;
	String memPw;
	String memName;
	String memAddr;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date memRegiDate;
	String memGender;
	String memPhone;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date memBirth;
	String memEmail;
}
