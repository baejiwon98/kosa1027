import java.util.Scanner;

public class Ex24 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String stop;
		do{
			System.out.println("시작 단 : ");
			int startdan = sc.nextInt();
			System.out.println("마지막 단 : ");
			int enddan = sc.nextInt();
			System.out.println("시작 곱 : ");
			int startgop = sc.nextInt();
			System.out.println("마지막 곱 : ");
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
			System.out.println("종료하려면 'y' 아니면 아무거나 : ");
			stop = sc.next();
		}while(!stop.equals("y"));
	}
}