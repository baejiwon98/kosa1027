
public class Ex01 {

	public static void main(String[] args) {
		// 1. �ݺ��� ���� ���� i�� �ʱⰪ�� 1�̰� 10���� �ݺ� ������ �� �� i�� ��µǵ����Ͻÿ�
		for (int i = 1; i<=10; i++) {
			System.out.println(i);
		}
		
		// 2. �ݺ��� ���� ���� i�� �ʱⰪ�� 1�̰� 10���� �ݺ� ������ �� �� ���� y�� �ݺ��� ������ 1�� �����ϴ� ���� ��µǵ����Ͻÿ�
		int y = 1;
		for (int i = 1; i <= 10; i++) {
			System.out.println(y);
			y++;
		}
		// 3.
		for(int i =1; i <=10 ; i++) {
			int y1 = 0; // �ݺ��� �ȿ� ���� ������ ����
			y1++; // y1�� 0���� �ʱ�ȭ�� �Ǿ����Ƿ� �׻� 1�� �ȴ�. 
			System.out.println(y1);
			System.out.println(i); // 1�� ����
		}
		
		// 4.
		for(int i = 11; i<=20;i++) { // i�� �ݺ�����
			System.out.println("�̾��ڴ��� �������� �����ž��մϴ�.");
		}
		
		// 5. �ݺ����� i�� �ʱⰪ�� 10�̰� 10�� �ݺ�
		for (int i = 10; i <=19;i +=2) {
			System.out.println(i);
		}
		
		// 6. continue�� ���
		for (int i =10; i <=19; i++) {
			if (i % 2 != 0) continue;
			System.out.println(i);
		}
		
		// 7.
		int y2 = 1;
		for (int i=10; i<=109; i+=4) {
			System.out.println(y2);
			y2++;
		}
		
		// 8.
		for (int i = 12; i <=31; i +=5) {
			System.out.println("�����ڴ� �鿩���⸦ ���ؾ��մϴ�.");
		}

		// 11.
		int y3 = 1;
		for(int i = 1; i <= 9; i++) {
			System.out.println("7 * " + y3 + " = " + 7*y3);
			y3++;
		}
		
		// 16.
		int num = (int)(Math.random()* 45) + 1;
		for (int i =1; i<=num;i++) {
			System.out.println(i);
		}
		
		// 17.
		for (int i = 1; i<=10; i++) {
			int num1 = (int)(Math.random() *45)+1;
			if(num %2 != 0) {
				System.out.println(" 3 * "+num1 + " = " + 3 * num1);
			} else i--;
		}
		
		// 20. x = 10 ;y = 19; z = 2 �� �� i�� �ʱⰪ x�� ������ y���� �ݺ��� �ϵ� z��ŭ ������ �Ͻÿ�.
		int x = 10;
		y = 19;
		int g = 2;
		for(int i = x; i <= y;i += g) {
			System.out.println(i);
		}
		
		// ���� i�� 1���� 10���� �ݺ��� �ϰ� ���� j = 100���� 90�� �� ������ �ݺ��� �Ͽ� 
		// "���α׷��� �� �� ���� �鿩���⸦ ������" �� ���
		for(int i = 1, j = 100 ; i <=10 && j >= 90; i++, j--) {
			System.out.println("���α׷��� ���Ϸ��� �鿩���⸦ ������.");
		}
		/*25. 
		6�� ����
		6 * 4= 24
		6 * 5= 30
		6 * 6= 36
		6�� ��
		7�� ����
		7 * 4= 28
		7 * 5= 35
		7 * 6= 42
		7�� ��
		*/
		for(int i = 4; i<=6; i++) {
			System.out.println(i + "�� ����");
			for (int j = 3;j<=8;j++) {
				System.out.println(i+ " * "+ j +" = "+i*j);
			}
			System.out.println(i + "�� ��");
		}
		
		System.out.println("======================");
		
		for(int i = 4; i<=6; i++) {
			System.out.println(i + "�� ����");
			for (int j = 3;j<=8;j++) {
				System.out.print(i+ " * "+ j +" = "+i*j+ "  ");
			}
			System.out.println();
			System.out.println(i + "�� ��");
		}
	}

}
