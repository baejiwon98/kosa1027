package kosaShoppingMall.command;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class FindPasswordCommand {
	@NotBlank(message = "아이디를 입력해주세요.")
	String userId;
	@NotBlank(message = "연락처를 입력해주세요.")
	String userPhone;
	@NotBlank(message = "이메일을 입력해주세요.")
	String userEmail;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
}
