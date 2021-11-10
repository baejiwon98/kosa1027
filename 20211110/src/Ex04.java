
public class Ex04 {
	static int first;
	static int second;
	// static변수는 생성자를 이요해서 초기화 할 수 없다.
	// static변수를 초기활 할 떄에는 static 블럭을 이용한다.
	static {
		first = 10;
		second = 20;
	}
	int val;
	public Ex04() {}
	public Ex04(int val) {
		this.val = val;
	}
}
