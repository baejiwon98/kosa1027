import java.util.Scanner;

public class Ex23 {
	public static void main(String[] args) {
		//num = int (input("ù��°���ڸ� �Է����ּ���."))
		//Scanner
		/*
		Scanner sc = new Scanner(System.in);
		System.out.println("�̸��� �Է��ϼ���. : ");
		String name = sc.next();
		System.out.println("�̸��� : " + name);
		System.out.println("���ڸ� �Է����ּ��� : ");
		int num = sc.nextInt();
		System.out.println("���� : "+num);
		*/
		//���� : �ܰ� ���� ������ �Է� �޾� �������� ����Ͻÿ�.
		Scanner sc = new Scanner(System.in);
		System.out.println("���� �� : ");
		int startdan = sc.nextInt();
		System.out.println("������ �� : ");
		int enddan = sc.nextInt();
		System.out.println("���� �� : ");
		int startgop = sc.nextInt();
		System.out.println("������ �� : ");
		int endgop = sc.nextInt();
		int i = startdan;
		while (i <= enddan) {
			int j = startgop;
			while (j <= endgop) {
				System.out.println(i +" * " + j +" = "+ i*j);
				j++;
			}
			i++;
//			System.out.println("�����Ϸ��� 'y' �ƴϸ� �ƹ��ų� : ");
//			String stop = sc.next();
//			if (stop.equals("y")) {
//				System.out.println("���α׷� ����");
//				break;
		}
		
//		while(true) { // ������ �����ϱ� ���ؼ� true�� ���
//			System.out.println("���� �� : ");
//			int startdan = sc.nextInt();
//			System.out.println("������ �� : ");
//			int enddan = sc.nextInt();
//			System.out.println("���� �� : ");
//			int startgop = sc.nextInt();
//			System.out.println("������ �� : ");
//			int endgop = sc.nextInt();
//			int i = startdan;
//			while (i <= enddan) {
//				int j = startgop;
//				while (j <= endgop) {
//					System.out.println(i +" * " + j +" = "+ i*j);
//					j++;
//				}
//				i++;
//			}
//			System.out.println("�����Ϸ��� 'y' �ƴϸ� �ƹ��ų� : ");
//			String stop = sc.next();
//			if (stop.equals("y")) {
//				System.out.println("���α׷� ����");
//				break;
//			}
//		}
	}		
}