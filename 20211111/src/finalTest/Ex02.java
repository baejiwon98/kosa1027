package finalTest;

public class Ex02 extends Ex01{
	public int sub() {
		return first - second;
	}
	public int mul() {
		return first * second;
	}
//	@Override
//	public int div() {
//		if(second == 0) {
//			return 0;
//		}else { 
//			return first/second;
//		}
//	}
	// -> final 메소드는 재정의(오버라이딩)를 할 수 없다.
}
