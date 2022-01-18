package springBootTest2.domain;

import lombok.Data;

@Data
public class LibDTO {
	Integer libNum;
	String libWriter;
	String libSubject;
	String libContent;
	String memId;
	String ipAddr;
	String libPw;
}
