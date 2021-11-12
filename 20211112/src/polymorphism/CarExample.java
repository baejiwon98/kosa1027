package polymorphism;

public class CarExample {

	public static void main(String[] args) {
		Car car = new Car();
		for(int i = 1; i<=5; i++) {
			int problemLocation = car.run();
			switch(problemLocation) {
			case 1 : 
				System.out.println("�տ��� HankookTire ��ü");
				car.frontLeftTire= new HankookTire("�տ���", 6);
				break;
			case 2 : 
				System.out.println("�տ����� KumhoTire ��ü");
				car.frontRightTire = new KumhoTire("�տ�����", 4);
				break;
			case 3 : 
				System.out.println("�޿��� HankookTire ��ü");
				car.backLeftTire= new HankookTire("�޿���", 6);
				break;
			case 4 : 
				System.out.println("�޿����� KumhoTire ��ü");
				car.backRightTire = new KumhoTire("�޿�����", 4);
				break;
			}
		}

	}

}
