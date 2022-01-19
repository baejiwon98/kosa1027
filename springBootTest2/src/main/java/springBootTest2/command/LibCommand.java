package springBootTest2.command;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class LibCommand {
	String libWriter;
	String libSubject;
	String libContent;
	String libPw;
	Integer libNum;
	MultipartFile [] report;
}
