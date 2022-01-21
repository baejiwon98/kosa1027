package springBootTest2.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MyBoardCommand {
	Integer boardNum;
	String boardWriter;
	String boardSubject;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date boardDate;
	String boardContent;
	String writerIp;
}
