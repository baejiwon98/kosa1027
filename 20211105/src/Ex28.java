
public class Ex28 {

	public static void main(String[] args) {
		// 13. 1부터 10까지의 합을 구하시오.
		int sum = 0;
		for (int i = 1; i <= 10;i ++) {
			sum += i;
		}
		System.out.println(sum);

		// 14. 10부터 1000까지의 합을 구히시오.
		sum = 0;
		for (int i = 1; i <= 1000;i ++) {
			sum += i;
		}
		System.out.println(sum);
		
		// 15. 6단을 출력할 때 3곱부터 8곱까지만 출력하시오.
		for (int i = 3; i<=8; i++) {
			System.out.println("6 * " + i +" = " + 6*i);
		}
		
		// 16. Math.random()함수를 사용해서 1부터 45까지의 랜덤 수 중 하나를 가지고 와서 랜덤 수 만큼 
	    // "개발을 잘하려면 자바를 들이셔야합니다"를 출력하시오. (복원 추출, 중복 허용)
		int num;
		num = (int)(Math.random() * 45)+1;
		for (int i = 1; i <= num; i++) {
			System.out.println("개발을 잘하려면 자바를 들이셔야합니다");
		}
		
		// 17. 1부터 45까지의 랜덤 값 중 짝수인것만 곱하도록 3단을 만들고 반복은 10회 한다.
		for (int i = 1; i <= 10; i++) {
			num = (int)(Math.random() * 45)+1;
			if (num % 2 == 0) {
				System.out.println("3 * " + num + " = " + 3* num);
			}
			else i--;
		}
		
		// 18. 1부터 45중 랜덤수 6개만 가지고 오시오 (복원 추출, 중복 허용)
		for (int i = 1; i<=6; i++) {
			num = (int)(Math.random() * 45)+1;
			System.out.println(num);
		}
		
		// 19. 3단을 출력할때 2부터 5곱까지 만 출력하시오. 단, 반복 변수는 사용하지 마시오.
		System.out.println("3 * 2 = 6");
		System.out.println("3 * 3 = 9");
		System.out.println("3 * 4 = 12");
		System.out.println("3 * 5 = 15");

		// 20. 변수 x와 변수 z가 있을 때 반복변수 i는 x가 가지고 있는 값부터 z가 가지고 있는 값까지
		// 변수 g만큼씩 증가하여 반복하여 "우리 열공하여 취업을 잘합시다"를 출력하시오.
//		int x, z, g;
//		for(int i = x; i <= z; i+=g) {
//			System.out.println("우리 열공하여 취업을 잘합시다");
//		}
		
		// 21. i는 1부터 15까지 1씩 증가하여야 하며 y는 1000 부터 10씩 감소 할때만 만복이 이루어져야 한다.
	    // 이 때 "자바는 나의 사랑"이라는 문구가 출력되도록 하시오.
		
		// 22. i는 1부터  1씩 증가한 값이 15이거나  y는 1000 부터 20씩 감소한 값이 0일때 까지 반복이 이루어져야 한다.

		// 23. 3단부터 8단까지 출력
		for(int y = 3 ;  y <= 8; y++) {
			System.out.println(y + "단");
			for(int i = 1; i <= 9; i++){
				System.out.println( y + " * " + i + "= " + y*i ); 
			}
		}
		
		// 24. 3단부터 7단까지 출력을 하는데 4곱부터 8곱까지만 출력하시오.
		for(int y = 3 ;  y <= 7; y++) {
			System.out.println(y + "단");
			for(int i = 4; i <= 8; i++){
				System.out.println( y + " * " + i + "= " + y*i ); 
			}
		}
		
		/*25. 
		6단 시작
		6 * 4= 24
		6 * 5= 30
		6 * 6= 36
		6단 끝
		7단 시작
		7 * 4= 28
		7 * 5= 35
		7 * 6= 42
		7단 끝*/ 
		
		for (int i = 6; i<=7 ; i++) {
			System.out.println(i+ "단 시작");
			for (int j = 4; j<=6; j++) {
				System.out.println(i+ " * "+ j + " = " + i * j);
			}	
			System.out.println(i+ "단 끝");
		}
		
		/*
		 * 26. 
			6단 시작
			6 * 4= 24         6 * 5= 30         6 * 6= 36
			6단 끝
			7단 시작
			7 * 4= 28         7 * 5= 35         7 * 6= 42
			7단 끝
		 * */
		for (int i = 6; i<=7 ; i++) {
			System.out.println(i+ "단 시작");
			for (int j = 4; j<=6; j++) {
				System.out.print(i+ " * "+ j + " = " + i * j+ "   ");
			}
			System.out.println("");
			System.out.println(i+ "단 끝");
		}
		
		
		
		
	}

}
