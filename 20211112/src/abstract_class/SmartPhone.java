package abstract_class;

// 추상클래스는 상속해서 사용하고 추상메소드를 제정의해서 사용해야한다.
public class SmartPhone extends Phone{ 
	public SmartPhone(String owner) {
		super(owner);
	}
	// 자식클래스
	// 추상 클래스를 상속 받으면 추상 메소드를 재정희 하여 사용한다.
	@Override
	public void turnOn() {
		System.out.println("폰 전원을 켭니다.");
	}
	@Override
	public void turnOff() {
		System.out.println("폰 전원을 끕니다.");
	}
}
