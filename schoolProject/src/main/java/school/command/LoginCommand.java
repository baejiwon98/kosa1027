package school.command;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class LoginCommand {
	@NotNull(message = "아이디를 입력하여 주세요.")
	String userId;
	@NotNull(message = "비밀번호를 입력하여 주세요.")
	String userPw;
	String grade;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
