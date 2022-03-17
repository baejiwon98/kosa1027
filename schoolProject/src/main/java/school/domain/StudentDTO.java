package school.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("StudentDTO")
public class StudentDTO {
	String studentNum;
	String departmentNum;
	String departmentName;
	String studentId;
	String studentPw;
	String studentName;
	String studentPhone;
	String studentEmail;
}
