
public class Ex05 {

	public static void main(String[] args) {
		// 형변환
		// 자동형변환 : 작은 자료형이 큰 자료형으로 변환하는 것
		// 1byte -> 2byte -> 4byte -> 8byte
		// 1byte -> 8byte, 1byte -> 4byte
		short sh = 30000;
		int i = sh; //자동형 변환
		float f = sh;//자동형 변환 : 정수 ---> 실수
		System.out.println(i);
		System.out.println(f);
		double d = sh;
		System.out.println(d);
		// 강제형 변환 : 큰 자료형을 작은 자료형으로 변환하는 것
		// 실수 ==> 정수, 큰형 ==> 작은 형 : 강제 형변환
		double d1 = 174.5;
		float f1 = 174.5f;
		int i1 = (int)f1; 
		System.out.println(i1);
		i1 = (int)d1; // 실수 ==> 정수 
		System.out.println(i1);
		int i2 = 2100000000;
		short sh1 = (short)i2; //큰형 ==> 작은형
		System.out.println(sh1);
		/// 오버플로우가 발생해서 수가 달라질 수 있음
		int i3 = 32000;
		short sh3 = (short)i3;
		System.out.println(sh3);
	}

}
