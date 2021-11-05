
public class Ex25 {

	public static void main(String[] args) {
		//1. 반복을 위한 변수 i의 초기값이 1이고 10번을 반복 수행을 할 때
		//i가 출력되도록 하시오.
		for(int i = 1;i<=10;i++) {
			System.out.println(i);
		}
		// 2. 반복을 위한 변수 i의 초기값이 1이고 10번을 반복 수행을 할 때 
		// 변수 y가 반복될 때마다 1씩 증가하는 값이 출력되도록 하시오.
		int y = 0;
		for (int i = 1;i<=10;i++) {
			System.out.println(y);
			y++;
		}
		// 3. 반복을 위한 변수 i가 5회 수행하는 동안 초기 값 0을 가지는 변수y1를
		// 반복문 안에서 1증가 하도록 하되 변수y1 계속 반복문안에서
		// 한번만 1증가 된 값이 출력되도록 하시오.
		// 변수 y1에 0을 대입해서는 안된다. 단 초기화는 가능.
		
		for (int i = 1; i<=5; i++) {
			int y1 = 0;
			y1++;
			System.out.println(y1);
		}
	}
}
