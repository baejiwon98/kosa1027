
public abstract class Ex01 {
	int first; // ����ʵ�
	// ������
	public Ex01(int first) {
		this.first = first;
	}
	// �߻�޼ҵ�
	public abstract void method01();//���ǵǾ� ���� ���� �޼ҵ�
	// �Ϲ� �޼ҵ�
	public void method02() {
		System.out.println("Ex01-method");
	}
}
