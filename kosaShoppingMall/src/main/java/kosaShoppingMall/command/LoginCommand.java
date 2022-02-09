package kosaShoppingMall.command;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class LoginCommand {
	@NotNull(message = "아이디를 입력하여 주세요.")
	String userId;
	@NotNull(message = "비밀번호를 입력하여 주세요.")
	String userPw;
	String grade;
}
