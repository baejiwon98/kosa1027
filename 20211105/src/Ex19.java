
public class Ex19 {
	public static void main(String[] args) {
		///for문 3단부터 7단까지 4곱부터 6곱까지
		for(int dan = 3; dan <= 7; dan++) {
			for(int gop = 4; gop <= 6 ; gop++) {
				System.out.println(dan + " * " + gop +" = " + dan * gop);
			}
		}
		System.out.println("=====while=====");
		int dan = 3;
		while(dan <= 7) {
			//3
			int gop = 4;
			while(gop <= 6) { 
				System.out.println(dan + " * " + gop + " = " + dan*gop);
				gop ++;
			}
			dan ++;//4
		}
	}
}
