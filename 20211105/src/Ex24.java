import java.util.Scanner;

public class Ex24 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String stop;
		do{
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
			}
			System.out.println("�����Ϸ��� 'y' �ƴϸ� �ƹ��ų� : ");
			stop = sc.next();
		}while(!stop.equals("y"));
	}
}