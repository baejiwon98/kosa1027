
public class Board {
	int num;
	String name;
	String subject;
	String content;
	int visit;
	
	public Board() {}
	
	public Board(int num, String name, String subject, String content, int visit) {
		this.num = num;
		this.name = name;
		this.subject = subject;
		this.content = content;
		this.visit = visit;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getVisit() {
		return visit;
	}

	public void setVisit(int visit) {
		this.visit = visit;
	}
		
	
}
