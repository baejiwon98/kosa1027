package default_method;

public interface MyInterface {
	public void method1(); // 재정의
	
	// 오버라이드를 할 수도 있고 안할 수도 있는 메소드
	public default void method2() {
		System.out.println("MyInterface-method2 실행");
	}
}
