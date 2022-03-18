package kosaShoppingMall.domain;

import lombok.Data;

@Data
public class AuthInfo {
	String userId;
	String userPw;
	String grade;
	String phone;
	String email;
	String memOk;
	String userNum;
	
	public String getMemOk() {
		return memOk;
	}
	public void setMemOk(String memOk) {
		this.memOk = memOk;
	}
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
