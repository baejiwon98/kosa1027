
public class Ex14 {

	public static void main(String[] args) {
		//3행 4열인 2차원 배열에 1~100까지 사용하는 Math.random()을 이용하여
		//값을 입력한 후 합계를 출력하시오.
		int i [][] = new int [3][4];
		int sum =0;
		for(int j=0; j<i.length;j++) {
			for(int k=0; k<i[j].length; k++) {
				int num = (int)(Math.random()*100)+1;
				i[j][k] = num;
				sum += num;
				System.out.print(i[j][k]+"  ");
			}
			System.out.println();
		}
//		System.out.println(i);
		System.out.println(sum);
		
		int[] score = {60,89,56,73,66,90,95};
		// 합계와 평균을 for each문을 사용해서 구하시오.
		sum = 0;
		for (int num : score) {
			sum += num;
		}
		System.out.println("합계는 "+ sum);
		System.out.println("평균은 "+ sum/score.length);
		
	}
	
}
