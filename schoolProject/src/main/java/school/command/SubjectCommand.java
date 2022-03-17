package school.command;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class SubjectCommand {
	@NotEmpty(message="과목 번호를 입력하세요!")
	String subjectNum;
	@NotEmpty(message="과목 이름을 입력하세요!")
	String subjectName;
	@NotEmpty(message="제목을 입력하세요!")
	String subjectTitle;
	@NotEmpty(message="내용을 입력하세요!")
	String subjectContent;
	public String getSubjectNum() {
		return subjectNum;
	}
	public void setSubjectNum(String subjectNum) {
		this.subjectNum = subjectNum;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getSubjectTitle() {
		return subjectTitle;
	}
	public void setSubjectTitle(String subjectTitle) {
		this.subjectTitle = subjectTitle;
	}
	public String getSubjectContent() {
		return subjectContent;
	}
	public void setSubjectContent(String subjectContent) {
		this.subjectContent = subjectContent;
	}
	
}
