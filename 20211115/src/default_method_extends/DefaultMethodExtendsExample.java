package default_method_extends;

public class DefaultMethodExtendsExample {

	public static void main(String[] args) {
		ChildInterface1 ci1 = new ChildInterface1() {
			@Override
			public void method1() { // 추상메소드
				System.out.println("ChildInterface1-method1-재정의");
			}
			@Override
			public void method3() {
				System.out.println("ChildInterface1-method3-재정의");
			}
		};
		ci1.method1();
		ci1.method2(); // 재정의 안한 default 메소드
		ci1.method3();
		ChildInterface2 ci2 = new ChildInterface2() {
			@Override
			public void method1() {
				System.out.println("ChildInterface2-method1-재정의");
			}
			@Override
			public void method3() {
				System.out.println("ChildInterface2-method3-재정의");
			}
		};
		ci2.method1();
		ci2.method2(); // ChildInterface2에서 재정의한 default 메소드
		ci2.method3();
		ChildInterface3 ci3 = new ChildInterface3() {
			@Override
			public void method1() {
				System.out.println("ChildInterface3-method1-재정의");
			}
			@Override
			public void method3() {
				System.out.println("ChildInterface3-method3-재정의");
			}
			@Override
			public void method2() {
				System.out.println("ChildInterface3-method2-재정의");
			}
		};
		ci3.method1();
		ci3.method2(); 
		ci3.method3(); // default 메소드를 추상 메소드로 만들어져 재정의, 꼭 재정의해야하는 메소드가 됨
	}
}
