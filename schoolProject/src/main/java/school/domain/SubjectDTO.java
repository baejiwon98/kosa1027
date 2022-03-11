package school.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("SubjectDTO")
public class SubjectDTO {
	String subjectNum;
	String subjectName;
	String subjectTitle;
	String subjectContent;
}
