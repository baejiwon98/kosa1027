
public class Ex18 {

	public static void main(String[] args) {
		// 3�� ~ 7�� ��� while
		int dan = 3;
		while(dan <= 7) {
			int gop = 1;
			while (gop <= 9) {
				System.out.println(dan + " * " + gop + " = " + dan*gop);
				gop ++;
			}
			dan ++;
		}
	}
}
