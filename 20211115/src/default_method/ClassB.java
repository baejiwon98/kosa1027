package default_method;

public class ClassB extends ClassA{
	public void method03() {
		System.out.println("ClassB-method03");
	}

	@Override
	public void method01() { // 추상메소드
		System.out.println("ClassB-method01");	
	}
	// 상속받은 일반 메소드는 오버라이딩을 할 필요 없다.
}
