package school.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("ProfessorDTO")
public class ProfessorDTO {
	String professorNum;
	String departmentNum;
	String departmentName;
	String professorId;
	String professorPw;
	String professorName;
	String professorPhone;
	String professorEmail;
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
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
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
