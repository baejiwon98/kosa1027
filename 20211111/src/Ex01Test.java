
public class Ex01Test {

	public static void main(String[] args) {
		Ex01 ex01 = new Ex01();
		Ex01 ex02 = new Ex01();
		Ex01 ex03 = new Ex01();
		if (ex01 == ex02) {
			System.out.println("같다.");
		}else {
			System.out.println("다르다.");
		}
		ex01.first=20;
		System.out.println(ex02.first);
		System.out.println(ex01.first);
		
//		Singleton s1 = Singleton.getInstance();///20000
//		Singleton s2 = Singleton.getInstance();
//		if(s1==s2) {
//			System.out.println("s1과 s2는 같다.");
//		}else {
//			System.out.println("s1과 s2는 다르다.");
//		}
		//static 키워드가 이쓴ㄴ 멤버 변수는 객체 생성 없이 클래스명으로 사용할 수 있다.
		int result  = Singleton.val;	
		System.out.println(result);
		Singleton s = Singleton.getInstance(); // s = 30000
		Singleton s1 = Singleton.getInstance(); // s1 = 30000
		if(s== s1) {
			System.out.println("s와 s1은 같은 객체이다.");
		}else {
			System.out.println("s와 s1은 다른 객체이다.");
		}
	}

}
