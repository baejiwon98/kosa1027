package multi_implement;

public class RemoteControlExample {

	public static void main(String[] args) {
		SmartTelevision st = new SmartTelevision();
		
		RemoteControl rc = (RemoteControl)st;
		Searchable sc = (Searchable)st;
		rc.turnOn();
		rc.turnOff();
		sc.search("ÀÌ¼þ¹«");
	}

}
