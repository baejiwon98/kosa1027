
public class Ex27 {

	public static void main(String[] args) {
		// 9. 구구단 4단을 출력하시오.
		for (int i =1;i<=9;i++) {
			System.out.println("4 * "+i+" = "+ 4*i);
		}
		
		// 10. 구구단 6단 중 홀수 곱만 출력하시오.
		for (int i =1;i<=9;i+=2) {
			System.out.println("6 * "+i+" = "+ 6*i);
		}
		// 11. 구구단 7단을 출력하되 홀수만을 출력하되 반복변수는 사용하지 말것.
		System.out.println("7 * 1 = 7");
		System.out.println("7 * 3 = 21");
		System.out.println("7 * 5 = 35");
		System.out.println("7 * 7 = 49");
		System.out.println("7 * 9 = 63");
		
	}

}
