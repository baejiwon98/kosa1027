package abstract_class;

// �߻�Ŭ������ ����ؼ� ����ϰ� �߻�޼ҵ带 �������ؼ� ����ؾ��Ѵ�.
public class SmartPhone extends Phone{ 
	public SmartPhone(String owner) {
		super(owner);
	}
	// �ڽ�Ŭ����
	// �߻� Ŭ������ ��� ������ �߻� �޼ҵ带 ������ �Ͽ� ����Ѵ�.
	@Override
	public void turnOn() {
		System.out.println("�� ������ �մϴ�.");
	}
	@Override
	public void turnOff() {
		System.out.println("�� ������ ���ϴ�.");
	}
}
