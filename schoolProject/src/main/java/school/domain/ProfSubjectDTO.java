package school.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("ProfSubjectDTO")
public class ProfSubjectDTO {
	String professorNum;
	String subjectNum;
	String status;
	String subjectName;
	String professorName;
	public String getProfessorNum() {
		return professorNum;
	}
	public void setProfessorNum(String professorNum) {
		this.professorNum = professorNum;
	}
	public String getSubjectNum() {
		return subjectNum;
	}
	public void setSubjectNum(String subjectNum) {
		this.subjectNum = subjectNum;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getProfessorName() {
		return professorName;
	}
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
	
}
