package school.command;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class MajorCommand {
	@NotEmpty(message="학과 번호를 입력하세요!")
	String departmentNum;
	@NotEmpty(message="학과 이름을 입력하세요!")
	String departmentName;
	@NotEmpty(message="학과 연락처를 입력하세요!")
	String departmentPhone;
	String departmentAddr;
	@NotEmpty(message="우편번호를 입력하세요!")
	String zip;
	@NotEmpty(message="전체주소를 입력하세요!")
	String fullAddr;
	String addr1;
	String addr2;
	@NotEmpty(message="상세주소를 입력하세요!")
	String detailAddr;
}
