package inheritance;

public class Ex05Test {

	public static void main(String[] args) {
		Ex05 ex05 = new Ex05();
		ex05.setFirst(20);
		ex05.setSecond(30);
		ex05.add();
		System.out.println(ex05.getResult());
		ex05.sub();
		System.out.println(ex05.getResult());

	}

}
