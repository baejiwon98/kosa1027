package default_method;

public class ClassC extends ClassA{
	public void method04() {
		System.out.println("ClassC-method04");
	}

	@Override
	public void method01() { // �߻� �޼ҵ�
		System.out.println("ClassC-method04");	
	}
	@Override
	public void method02() { // �Ϲ� �޼ҵ�
		System.out.println("ClassC-method02");
	}
}
