package school.command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class StudentCommand {
	@NotEmpty(message = "학생번호를 입력해주세요!")
	String studentNum;
	@NotEmpty(message = "학과를 선택해주세요!")
	String departmentNum;
	@NotEmpty(message = "아이디를 입력해주세요!")
	String studentId;
	@NotEmpty(message = "비밀번호를 입력해주세요!")
	String studentPw;
	@NotBlank(message = "비밀번호 확인을 입력해주세요!")
	String studentPwCon;
	@NotEmpty(message = "이름을 입력해주세요!")
	String studentName;
	@NotEmpty(message = "핸드폰번호를 입력해주세요!")
	String studentPhone;
	@NotEmpty(message = "이메일을 입력해주세요!")
	String studentEmail;
	
	
	public String getStudentPwCon() {
		return studentPwCon;
	}

	public void setStudentPwCon(String studentPwCon) {
		this.studentPwCon = studentPwCon;
	}

	public boolean isStuPwEqualsStuPwCon() {
		return studentPw.equals(studentPwCon);
	}
	
	public String getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}
	public String getDepartmentNum() {
		return departmentNum;
	}
	public void setDepartmentNum(String departmentNum) {
		this.departmentNum = departmentNum;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentPw() {
		return studentPw;
	}
	public void setStudentPw(String studentPw) {
		this.studentPw = studentPw;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentPhone() {
		return studentPhone;
	}
	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	
}
