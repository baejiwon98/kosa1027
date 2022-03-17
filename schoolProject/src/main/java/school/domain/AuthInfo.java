package school.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("AuthInfo")
public class AuthInfo {
	String userId;
	String userPw;
	String grade;
	String phone;
	String email;
}
