package school.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("CourseDTO")
public class CourseDTO {
	String professorNum;
	String subjectNum;
	String studentNum;
	String professorName;
	String subjectName;
	String studentName;
}
