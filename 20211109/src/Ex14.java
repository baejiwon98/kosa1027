
public class Ex14 {
	int result;
	int first;
	int second;
	int add; // ����
	
	public Ex14(int first, int second) {
		this.first = first;
		this.second = second;
	}
	// �޼ҵ��� 4���� ����
	// 1. �Է°��� �ְ�, �����(��ȯ��)�� �ִ� �޼ҵ�
	public int add(int num1, int num2) {
		return num1 + num2;
	}
	// �޼ҵ� �����ε� 
	public int div(int num1, int num2){
		return num1/ num2;
	}	
	// 2. �Է°��� �ְ�, �����(��ȯ��)�� ���� �޼ҵ�
	public void sub(int num1, int num2) {
		this.result = num1 - num2;
		System.out.println(this.result);
	}
	// ��ȯ���� �ٸ��ٰ� �ٸ� �Լ��� �ƴϴ�. �Ű������� ������, Ÿ���� �޶�� �����ε� ����
//	public int sub(int num1, int num2) {
//		return 0;
//	}
	// �޼ҵ� �����ε� // �Ű������� ������ �ٸ���.
	public int sub(int num1, double num2) {
		return num1 - (int)num2;
	}
	// 3. �Է°��� ����, �����(��ȯ��)�� �ִ� �޼ҵ�
	public int mul() {
		return this.first * this.second;
	}
	// 4. �Է°��� ����, �����(��ȯ��)�� ���� �޼ҵ�
	public void div() {
		System.out.println(this.first/this.second);
	}
}
