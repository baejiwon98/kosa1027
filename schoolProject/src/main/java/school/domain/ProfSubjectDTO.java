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
}
