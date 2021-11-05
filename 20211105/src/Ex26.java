
public class Ex26 {

	public static void main(String[] args) {
		// 4. 반복이 10번 수행이 되는 동안 "이쓰앰님을 전적으로 믿으셔야합니다."를 출력하시오.
		for(int i = 1; i <= 10; i++) {
			System.out.println("이쓰앰님을 전적으로 믿으셔야합니다.");
		}
		// 5. 반복 변수 i가 초기값 10을 가지고 있으며 10회를 반복할 때
		// 변수 i를 출력할 때 2씩 증가한 값만 출력되도록 하시오.
		for (int i = 10; i<=19; i+=2) {
			System.out.println(i);
		}
		//6. 반복 변수 i가 초기값 10을 가지고 있으며 10회를 반복할 때
		//변수 i를 출력할 때 홀수 값만 출력되도록 하시오.
		for (int i = 10; i<=19; i++) {
			if (i % 2 != 0) {
				System.out.println(i);
			}
			continue;	
		}
		// 7. 반복 변수 i가 초기값 10을 가지고 있으며 25회를 반복할 때 
		//변수 i를 출력할 때 4씩 증가한 값만 출력되도록 하시오.
		for (int i = 10; i<=34; i+=4) {
			System.out.println(i);
		}
		// 8. 반복 변수 i가 12부터 20회를 반복할 때
		//"개발을 잘하려면 자바를 들이셔야합니다"를 4회만 출력되도록 하시오.(나이도 2.5)
		for (int i= 12; i<=31; i+=4) {
			System.out.println("개발을 잘하려면 자바를 들이셔야합니다");
		}


	}

}
