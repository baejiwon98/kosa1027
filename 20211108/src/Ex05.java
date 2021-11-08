
public class Ex05 {

	public static void main(String[] args) {
		// 배열의 크기 (배열명.length)
		int i [] = new int[] {1, 2, 3, 4, 5};
		System.out.println(i.length);
		// 배열에 있는 값의 합계를 구하시오.
		int sum = 0;
		for(int j = 0; j< i.length; j++) {
			sum += i[j];
		}
		System.out.println(sum);
		System.out.println("==============");
		// 크기가 10인 배열을 만들고 Math.random을 이용하여
		// 배열에 임의의 값을 저장하시오. for 문 사용
		// 랜덤 값은 1 ~ 100
		int num [] = new int [10];
		for (int j = 0; j<num.length; j++) {
			num[j] = (int)(Math.random()*100) + 1;
			System.out.println(num[j]);
		}
		sum = 0;
		for (int j = 0; j<num.length; j++) {
			System.out.println(num[j]);
			sum += num[j];
		}
		System.out.println(sum);
		
		
	}

}
