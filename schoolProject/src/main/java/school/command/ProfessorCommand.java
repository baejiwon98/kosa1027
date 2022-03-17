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
}
