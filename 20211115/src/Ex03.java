
public interface Ex03 {
	//���, �߻�޼ҵ�
	static final int FIRST = 10;
	
	public void method01(); // �߻�޼ҵ�
	// �����ڰ� ����.	
	// �Ϲ� �޼ҵ尡 ����. // ����ʵ� ����.
	// �޼ҵ尡 �ϴ� ������ �ܺηκ��� ����ʵ忡 ���� ���� �ްų� 
	// ����ʺο� �ִ� ���� �ܺο� �����ϱ� ���ؼ� ���, setter, getter
	default void method02() {
		System.out.println("default-method");
	}
	static void method03() {
		System.out.println("static-method");
	}
}
