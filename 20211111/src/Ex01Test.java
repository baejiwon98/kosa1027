
public class Ex01Test {

	public static void main(String[] args) {
		Ex01 ex01 = new Ex01();
		Ex01 ex02 = new Ex01();
		Ex01 ex03 = new Ex01();
		if (ex01 == ex02) {
			System.out.println("����.");
		}else {
			System.out.println("�ٸ���.");
		}
		ex01.first=20;
		System.out.println(ex02.first);
		System.out.println(ex01.first);
		
//		Singleton s1 = Singleton.getInstance();///20000
//		Singleton s2 = Singleton.getInstance();
//		if(s1==s2) {
//			System.out.println("s1�� s2�� ����.");
//		}else {
//			System.out.println("s1�� s2�� �ٸ���.");
//		}
		//static Ű���尡 �̾��� ��� ������ ��ü ���� ���� Ŭ���������� ����� �� �ִ�.
		int result  = Singleton.val;	
		System.out.println(result);
		Singleton s = Singleton.getInstance(); // s = 30000
		Singleton s1 = Singleton.getInstance(); // s1 = 30000
		if(s== s1) {
			System.out.println("s�� s1�� ���� ��ü�̴�.");
		}else {
			System.out.println("s�� s1�� �ٸ� ��ü�̴�.");
		}
	}

}
