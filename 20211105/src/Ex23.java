import java.util.Scanner;

public class Ex23 {
	public static void main(String[] args) {
		//num = int (input("첫번째숫자를 입력해주세요."))
		//Scanner
		/*
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력하세요. : ");
		String name = sc.next();
		System.out.println("이름은 : " + name);
		System.out.println("숫자를 입력해주세요 : ");
		int num = sc.nextInt();
		System.out.println("숫자 : "+num);
		*/
		//문제 : 단과 곱의 범위를 입력 받아 구구단을 출력하시오.
		Scanner sc = new Scanner(System.in);
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
//			System.out.println("종료하려면 'y' 아니면 아무거나 : ");
//			String stop = sc.next();
//			if (stop.equals("y")) {
//				System.out.println("프로그램 종료");
//				break;
		}
		
//		while(true) { // 무조건 실행하기 위해서 true를 사용
//			System.out.println("시작 단 : ");
//			int startdan = sc.nextInt();
//			System.out.println("마지막 단 : ");
//			int enddan = sc.nextInt();
//			System.out.println("시작 곱 : ");
//			int startgop = sc.nextInt();
//			System.out.println("마지막 곱 : ");
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
//			System.out.println("종료하려면 'y' 아니면 아무거나 : ");
//			String stop = sc.next();
//			if (stop.equals("y")) {
//				System.out.println("프로그램 종료");
//				break;
//			}
//		}
	}		
}