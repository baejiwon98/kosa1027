package default_method;

public class ClassC extends ClassA{
	public void method04() {
		System.out.println("ClassC-method04");
	}

	@Override
	public void method01() { // 추상 메소드
		System.out.println("ClassC-method04");	
	}
	@Override
	public void method02() { // 일반 메소드
		System.out.println("ClassC-method02");
	}
}
