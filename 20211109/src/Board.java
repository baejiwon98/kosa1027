
public class Board {
	// 번호, 제목, 글쓴이, 내용, 글쓴이 ip주소, 방문자수
	int num;
	String subject;
	String writer;
	String content;
	String ip;
	int readCount;
	public Board() {}
	public Board(int num, String subject, String writer, String content, String ip, int readCount) {
		this.num = num;
		this.subject = subject;
		this.writer = writer;
		this.content = content;
		this.ip = ip;
		this.readCount = readCount;
	}
	// setter
	public void setNum(int num) {
		this.num = num;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	// getter
	public int getNum() {
		return this.num;
	}
	public String getSubject() {
		return this.subject;
	}
	public String getWriter() {
		return this.writer;
	}
	public String getContent() {
		return this.content;
	}
	public String getIp() {
		return this.ip;
	}
	public int getReadCount() {
		return this.readCount;
	}
}
