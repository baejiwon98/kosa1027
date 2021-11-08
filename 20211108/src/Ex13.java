
public class Ex13 {

	public static void main(String[] args) {
		// For Each: for 확장
		int [] i = {1,2,3,4,5};
		int sum = 0;
		/// 합계를 구하시오.
		for (int j = 0; j<i.length; j++) {
			sum+= i[j];
		}
		System.out.println(sum);
		System.out.println("====================");
		
		int ii[][] = {{1,2,3,4},{5,6},{7,8,9,10,11}};
		sum = 0;
		for(int row = 0; row<ii.length; row++) {
			for(int col=0; col<ii[row].length; col++) {
				sum += ii[row][col];
			}
		}
		System.out.println(sum);
		System.out.println("=============================");
		for (int [] row : ii) { // row = ii[0], row=ii[1]
			for(int col : row) {
				sum += col;
			}
		}
		
	}

}
