package method_polymorphism;

public abstract class Vehicle { // 추상클래스 
	public abstract void run(); // 추상메소드
	// 부모클래스에 있는 메소드의 내용을 사용하지 않고 자식클래스에서 재정의해서 사용하므로
	// 부모클래스에 있는 메서드 내용이 필요없어서 내용이 없는 메소드를 만듬
}
