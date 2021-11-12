
public class RheeAirplane extends Airplane{
	static final int NORMAL = 1; // 일반비행
	static final int SUPERSONIC = 2; // 초음속 비행
	
	int flyMode = NORMAL;
	
	public void fly() {
		if(flyMode == SUPERSONIC) {
			System.out.println("초음속 비행을 한다.");
		}else {
			super.fly();
		}
	}
}
