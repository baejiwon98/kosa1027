package school.command;

import lombok.Data;

@Data
public class ProfSubjectCommand {
	String professorNum;
	String subjectNum;
	String status;
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
	
}
