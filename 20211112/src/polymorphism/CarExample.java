package polymorphism;

public class CarExample {

	public static void main(String[] args) {
		Car car = new Car();
		for(int i = 1; i<=5; i++) {
			int problemLocation = car.run();
			switch(problemLocation) {
			case 1 : 
				System.out.println("¾Õ¿ÞÂÊ HankookTire ±³Ã¼");
				car.frontLeftTire= new HankookTire("¾Õ¿ÞÂÊ", 6);
				break;
			case 2 : 
				System.out.println("¾Õ¿À¸¥ÂÊ KumhoTire ±³Ã¼");
				car.frontRightTire = new KumhoTire("¾Õ¿À¸¥ÂÊ", 4);
				break;
			case 3 : 
				System.out.println("µÞ¿ÞÂÊ HankookTire ±³Ã¼");
				car.backLeftTire= new HankookTire("µÞ¿ÞÂÊ", 6);
				break;
			case 4 : 
				System.out.println("µÞ¿À¸¥ÂÊ KumhoTire ±³Ã¼");
				car.backRightTire = new KumhoTire("µÞ¿À¸¥ÂÊ", 4);
				break;
			}
		}

	}

}
