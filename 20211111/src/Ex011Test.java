
public class Ex011Test {

	public static void main(String[] args) {
		Ex01 ex01 = new Ex01();
		Ex01 ex02 = ex01;
		
		Ex01 ex03 = new Ex01();
		
		ex01.first = 30;
		System.out.println(ex01.first);
		System.out.println(ex02.first);
		System.out.println(ex03.first);
		if(ex01==ex02) {
			System.out.println("ex01�� ex02�� ����.");
		}else {
			System.out.println("�ٸ���.");
		}
		if(ex01==ex03) {
			System.out.println("ex01�� ex02�� ����.");
		}else {
			System.out.println("�ٸ���.");
		}

	}

}
