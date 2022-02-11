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

	public String getMemNum() {
		return memNum;
	}

	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPw() {
		return memPw;
	}

	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}

	public String getMemPwCon() {
		return memPwCon;
	}

	public void setMemPwCon(String memPwCon) {
		this.memPwCon = memPwCon;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemAddr() {
		return memAddr;
	}

	public void setMemAddr(String memAddr) {
		this.memAddr = memAddr;
	}

	public Date getMemRegiDate() {
		return memRegiDate;
	}

	public void setMemRegiDate(Date memRegiDate) {
		this.memRegiDate = memRegiDate;
	}

	public String getMemGender() {
		return memGender;
	}

	public void setMemGender(String memGender) {
		this.memGender = memGender;
	}

	public String getMemPhone() {
		return memPhone;
	}

	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}

	public Date getMemBirth() {
		return memBirth;
	}

	public void setMemBirth(Date memBirth) {
		this.memBirth = memBirth;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
	
	
}
