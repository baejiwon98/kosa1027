package WrapperExample;

public class StringToPrimitiveValueEx {

	public static void main(String[] args) {
		int i = Integer.parseInt("10");
		double d1 = Double.parseDouble("10.5");
		boolean b = Boolean.parseBoolean("true");
		
		System.out.println(i);
		System.out.println(d1);
		System.out.println(b);
	}

}
