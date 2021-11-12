
public class Ex04Test {

	public static void main(String[] args) {
		B b = new B();
		C c = new C();
		D d = new D();
		E e = new E();
		// 다형성 : 부모는 자식 객체를 참조 할 수 없다.
		//         자식은 부모를 상속받아야지만 가능하다. 
		A a = b;
		a = c;
		a = d;
		a = e;
	}

}
