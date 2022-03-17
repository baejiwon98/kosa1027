package school.command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ProfessorCommand {
	@NotEmpty(message = "교수번호를 입력해주세요!")
	String professorNum;
	@NotEmpty(message = "학과를 선택해주세요!")
	String departmentNum;
	@NotEmpty(message = "아이디를 입력해주세요!")
	String professorId;
	@NotEmpty(message = "비밀번호를 입력해주세요!")
	String professorPw;
	@NotBlank(message = "비밀번호 확인을 입력해주세요!")
	String professorPwCon;
	@NotEmpty(message = "이름을 입력해주세요!")
	String professorName;
	@NotEmpty(message = "전화번호를 입력해주세요!")
	String professorPhone;
	@NotBlank(message = "이메일 입력하여 주세요.")
	String professorEmail;
	
	public boolean isProfPwEqualsProfPwCon() {
		return professorPw.equals(professorPwCon);
	}

	public String getProfessorNum() {
		return professorNum;
	}

	public void setProfessorNum(String professorNum) {
		this.professorNum = professorNum;
	}

	public String getDepartmentNum() {
		return departmentNum;
	}

	public void setDepartmentNum(String departmentNum) {
		this.departmentNum = departmentNum;
	}

	public String getProfessorId() {
		return professorId;
	}

	public void setProfessorId(String professorId) {
		this.professorId = professorId;
	}

	public String getProfessorPw() {
		return professorPw;
	}

	public void setProfessorPw(String professorPw) {
		this.professorPw = professorPw;
	}

	public String getProfessorPwCon() {
		return professorPwCon;
	}

	public void setProfessorPwCon(String professorPwCon) {
		this.professorPwCon = professorPwCon;
	}

	public String getProfessorName() {
		return professorName;
	}

	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}

	public String getProfessorPhone() {
		return professorPhone;
	}

	public void setProfessorPhone(String professorPhone) {
		this.professorPhone = professorPhone;
	}

	public String getProfessorEmail() {
		return professorEmail;
	}

	public void setProfessorEmail(String professorEmail) {
		this.professorEmail = professorEmail;
	}
	
}
