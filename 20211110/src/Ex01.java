
public class Ex01 {
	// ĸ��ȭ
	// ��� �ʵ�, ��� ����
	private int first;
	private int second;
	int result;
	
	public Ex01() {}// default ������
	// �ٸ� �����ڰ� ���� ��� byte �ڵ� ���̷� �ڵ����� ����� ������
	// �ٸ� �����ڰ� �ִ� ��� default �����ڸ� �����ؾ� �Ѵ�.
	public Ex01(int first) { // ������ �����ε�
		this.first = first;
		this.second = 20;
	}
	public Ex01(int first, int second) {
		this.first = first;
		this.second = second;
	}
	// �޼ҵ�
	public void setFirst(int first ) {
		this.first = first;
	}
	public int getFirst() {
		return this.first;
	}
	public void setSecond(int second) {
		this.second = second;
	}
	public int getSecond() {
		return this.second;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public int getResult() {
		return this.result;
	}
	public int add() { // �޼��� �����ε�
		return this.first + this.second;
	}
	public int add(int num1, int num2) {
		return num1 + num2;
	}
	public void add(int num1) {
		System.out.println(num1 + this.first);
	}
}