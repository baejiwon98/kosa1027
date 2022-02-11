package kosaShoppingMall.command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class EmployeeCommand {
	@Size(min = 4, max = 12, message="아이디는 4자에서 12자 사이로 입력하여 주세요!")
	String empId;
	@NotEmpty(message = "비밀번호를 입력해주세요!")
	@Size(min = 3, max = 12)
	String empPw;
	@NotBlank(message = "비밀번호확인을 입력해주세요!")
	@Size(min = 3, max = 12)
	String empPwCon;
	@NotEmpty(message = "이름을 입력해주세요!")
	String empName;
	@NotEmpty(message = "주소를 입력해주세요!")
	String empAddr;
	@NotEmpty(message = "전화번호를 입력해주세요!")
	String empPhone;
	@NotBlank(message = "이메일 입력하여 주세요.")
	String empEmail;
	
	public boolean isEmpPwEqualsEmpPwCon() {
		return empPw.equals(empPwCon);
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpPw() {
		return empPw;
	}

	public void setEmpPw(String empPw) {
		this.empPw = empPw;
	}

	public String getEmpPwCon() {
		return empPwCon;
	}

	public void setEmpPwCon(String empPwCon) {
		this.empPwCon = empPwCon;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddr() {
		return empAddr;
	}

	public void setEmpAddr(String empAddr) {
		this.empAddr = empAddr;
	}

	public String getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	
}
