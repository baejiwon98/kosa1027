
public class Ex28 {

	public static void main(String[] args) {
		// 13. 1���� 10������ ���� ���Ͻÿ�.
		int sum = 0;
		for (int i = 1; i <= 10;i ++) {
			sum += i;
		}
		System.out.println(sum);

		// 14. 10���� 1000������ ���� �����ÿ�.
		sum = 0;
		for (int i = 1; i <= 1000;i ++) {
			sum += i;
		}
		System.out.println(sum);
		
		// 15. 6���� ����� �� 3������ 8�������� ����Ͻÿ�.
		for (int i = 3; i<=8; i++) {
			System.out.println("6 * " + i +" = " + 6*i);
		}
		
		// 16. Math.random()�Լ��� ����ؼ� 1���� 45������ ���� �� �� �ϳ��� ������ �ͼ� ���� �� ��ŭ 
	    // "������ ���Ϸ��� �ڹٸ� ���̼ž��մϴ�"�� ����Ͻÿ�. (���� ����, �ߺ� ���)
		int num;
		num = (int)(Math.random() * 45)+1;
		for (int i = 1; i <= num; i++) {
			System.out.println("������ ���Ϸ��� �ڹٸ� ���̼ž��մϴ�");
		}
		
		// 17. 1���� 45������ ���� �� �� ¦���ΰ͸� ���ϵ��� 3���� ����� �ݺ��� 10ȸ �Ѵ�.
		for (int i = 1; i <= 10; i++) {
			num = (int)(Math.random() * 45)+1;
			if (num % 2 == 0) {
				System.out.println("3 * " + num + " = " + 3* num);
			}
			else i--;
		}
		
		// 18. 1���� 45�� ������ 6���� ������ ���ÿ� (���� ����, �ߺ� ���)
		for (int i = 1; i<=6; i++) {
			num = (int)(Math.random() * 45)+1;
			System.out.println(num);
		}
		
		// 19. 3���� ����Ҷ� 2���� 5������ �� ����Ͻÿ�. ��, �ݺ� ������ ������� ���ÿ�.
		System.out.println("3 * 2 = 6");
		System.out.println("3 * 3 = 9");
		System.out.println("3 * 4 = 12");
		System.out.println("3 * 5 = 15");

		// 20. ���� x�� ���� z�� ���� �� �ݺ����� i�� x�� ������ �ִ� ������ z�� ������ �ִ� ������
		// ���� g��ŭ�� �����Ͽ� �ݺ��Ͽ� "�츮 �����Ͽ� ����� ���սô�"�� ����Ͻÿ�.
//		int x, z, g;
//		for(int i = x; i <= z; i+=g) {
//			System.out.println("�츮 �����Ͽ� ����� ���սô�");
//		}
		
		// 21. i�� 1���� 15���� 1�� �����Ͽ��� �ϸ� y�� 1000 ���� 10�� ���� �Ҷ��� ������ �̷������ �Ѵ�.
	    // �� �� "�ڹٴ� ���� ���"�̶�� ������ ��µǵ��� �Ͻÿ�.
		
		// 22. i�� 1����  1�� ������ ���� 15�̰ų�  y�� 1000 ���� 20�� ������ ���� 0�϶� ���� �ݺ��� �̷������ �Ѵ�.

		// 23. 3�ܺ��� 8�ܱ��� ���
		for(int y = 3 ;  y <= 8; y++) {
			System.out.println(y + "��");
			for(int i = 1; i <= 9; i++){
				System.out.println( y + " * " + i + "= " + y*i ); 
			}
		}
		
		// 24. 3�ܺ��� 7�ܱ��� ����� �ϴµ� 4������ 8�������� ����Ͻÿ�.
		for(int y = 3 ;  y <= 7; y++) {
			System.out.println(y + "��");
			for(int i = 4; i <= 8; i++){
				System.out.println( y + " * " + i + "= " + y*i ); 
			}
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
		7�� ��*/ 
		
		for (int i = 6; i<=7 ; i++) {
			System.out.println(i+ "�� ����");
			for (int j = 4; j<=6; j++) {
				System.out.println(i+ " * "+ j + " = " + i * j);
			}	
			System.out.println(i+ "�� ��");
		}
		
		/*
		 * 26. 
			6�� ����
			6 * 4= 24         6 * 5= 30         6 * 6= 36
			6�� ��
			7�� ����
			7 * 4= 28         7 * 5= 35         7 * 6= 42
			7�� ��
		 * */
		for (int i = 6; i<=7 ; i++) {
			System.out.println(i+ "�� ����");
			for (int j = 4; j<=6; j++) {
				System.out.print(i+ " * "+ j + " = " + i * j+ "   ");
			}
			System.out.println("");
			System.out.println(i+ "�� ��");
		}
		
		
		
		
	}

}
