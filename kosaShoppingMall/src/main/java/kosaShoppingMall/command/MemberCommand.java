package kosaShoppingMall.command;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MemberCommand {
	@Size(min = 10, max = 10, message = "번호를 10글자이상 입력하여 주세요.")
	String memNum;
	@NotBlank(message = "아이디를 입력하여 주세요.")
	String memId;
	@NotBlank(message = "비밀번호를 입력하여 주세요.")
	String memPw;
	@NotBlank(message = "비밀번호 확인을 입력하여 주세요.")
	String memPwCon;
	@NotBlank(message = "이름을 입력하여 주세요.")
	String memName;
	@NotBlank(message = "주소를 입력하여 주세요.")
	String memAddr;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull (message = "등록일을 입력하여 주세요.")
	Date memRegiDate;
	@NotBlank(message = "성별을 선택하여 주세요.")
	String memGender;
	@NotBlank(message = "연락처를 입력하여 주세요.")
	String memPhone;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull (message = "생일을 입력하여 주세요.")
	Date memBirth;
	@Email(message="형식에 맞지 않습니다.")
	@NotBlank(message = "이메일 입력하여 주세요.")
	String memEmail;
	
	public boolean isMemPwEqualsMemPwCon() {
		return memPw.equals(memPwCon);
	}
	
}
