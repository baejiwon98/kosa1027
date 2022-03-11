package school.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("ProfessorDTO")
public class ProfessorDTO {
	String professorNum;
	String departmentNum;
	String professorId;
	String professorPw;
	String professorName;
	String professorPhone;
	String professorEmail;
}
