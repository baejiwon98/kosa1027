package kosaShoppingMall.command;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class FindIdCommand {
	@NotBlank(message = "등록한 연락처를 입력하세요.")
	String memPhone;
	@NotBlank(message = "등록한 이메일을 입력하세요.")
	String memEmail;
	public String getMemPhone() {
		return memPhone;
	}
	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}
	public String getMemEmail() {
		return memEmail;
	}
	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
	
}
