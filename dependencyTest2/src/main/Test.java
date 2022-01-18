package main;

public class Test {

	public static void main(String[] args) {
		NumberClass num = new NumberClass();
		num.setI(1);
		System.out.println(num.getI());
		NumberClass num1 = new NumberClass(10, 20);
		System.out.println(num1.getI());
		NumberClass num2= new NumberClass(new Test1())
	}

}
