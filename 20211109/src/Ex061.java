
public class Ex061 {
	String name;
	int age;
	double height;
	// �ڹٿ��� �����ڴ� Ŭ������� ���ƾ��Ѵ�.
	// ������ (���̽��� ������ ������ �ϳ�)
	// ���������� Ŭ������ (�Ű�����,...)
	public Ex061(String name, int age, double height) {
		this.name = name;
		this.age = age;
		this.height = height;
		System.out.println("������ ����");
	}
	// �޼��� : Ŭ�����ȿ� �ִ� �Լ�
	// ���������� ��ȯ�� �Լ��� (�Ű�����)
	// setter
	       //��ȯ��(void : ��ȯ�Ұ��� ����)
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	//getter
	public String getName() {
		return this.name;
	}
	public int getAge() {
		   // ������ ��ȯ
		return this.age;
	}
	public double getHeight() {
		return this.height;
	}
}
