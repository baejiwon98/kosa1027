
public class Ex17 {

	public static void main(String[] args) {
		// 모두 for문과 foreach문 두가지 방법을 사용해서 출력하시오.
		int [] i = {1,2,3,4,5,6};
		
		for (int j = 0; j < i.length; j++) {
			System.out.println(i[j]);
		}
		
		for (int num : i) {
			System.out.println(num);
		}
		
		
		String [] str = {"이숭무", "이상범", "이장범", "김찬중"};
		
		for (int j = 0; j < str.length; j++) {
			System.out.println(str[j]);
		}
		
		for (String string : str) {
			System.out.println(string);
		}
		
		double[] d = {10.5, 20.6, 40.7, 200.8};
		
		for (int j = 0; j < d.length; j++) {
			System.out.println(d[j]);
		}
		
		for (double dou : d) {
			System.out.println(dou);
		}
		
		WEEK1 [] days = WEEK1.values();
		
		for (int j = 0; j < days.length; j++) {
			System.out.println(days[j]);
		}
		
		for(WEEK1 w : days) {
			System.out.println(w);
		}
		
		String[][] locations = {{"영등포","노량진", "종로"},
								{"가","나","다"},
								{"모란","수내","미금"}};
		for (int j = 0; j < locations.length; j++) {
			for(int k = 0; k < locations[j].length; k++) {
				System.out.println(locations[j][k]);
			}
		}
		
		for (String [] row : locations) {
			for(String col: row) {
				System.out.println(col);
			}
		}
		
		int [][] vals = {{1,2,3},{4,5},{6,7,8,9}};
		for (int j = 0; j < vals.length; j++) {
			for(int k = 0; k < vals[j].length; k++) {
				System.out.println(vals[j][k]);
			}
		}
		
		for(int [] row: vals) {
			for(int col : row) {
				System.out.println(col);
			}
		}
		

	}

}
