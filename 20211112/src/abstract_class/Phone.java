package abstract_class;

public abstract class Phone { // 부모클래스 : 추상클래스
	public String owner;
	public Phone(String owner) {
		this.owner = owner;
	}
	public abstract void turnOn(); // 추상화
	public abstract void turnOff(); //
}
