package default_method;

public interface MyInterface {
	public void method1(); // ������
	
	// �������̵带 �� ���� �ְ� ���� ���� �ִ� �޼ҵ�
	public default void method2() {
		System.out.println("MyInterface-method2 ����");
	}
}
