
public class Member {
	int age;
	double height;
	String name;

	public Member() {} // ����Ʈ ������
	
	public Member(int age) { // �޼ҵ� �����ε�
		this.age = age;
	}
	
	public Member(String name) {
		this.name=name;
	}
	
	public Member (int age, double height, String name) {
		this.age = age;
		this.height = height;
		this.name = name;
	}
	
	public Member (double height, int age, String name) {
		this.age = age;
		this.height = height;
		this.name = name;
	}
	
	//Setter
	public void setAge(int age) {
		this.age = age;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public void setName(String name) {
		this.name= name;
	}
	//Getter
	public int getAge() {
		return this.age;
	}
	public double getHeight() {
		return this.height;
	}
	public String getName() {
		return this.name;
	}
}
