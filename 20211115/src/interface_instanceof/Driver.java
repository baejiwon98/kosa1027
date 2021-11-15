package interface_instanceof;

public class Driver {
	// instanceof�� Ŭ������ ��ü�� ������ ���� �� ���
	public void drive(Vehicle vehicle) {
		if(vehicle instanceof Bus) { // instanceof ��ü�� ���� �� ���
			// vehicle ��ü�� BusŬ������ ������� ��ü�ΰ�?
			// instanceof�� ������� boolean�̴�.
			Bus bus = (Bus) vehicle;
			bus.checkFare();
		}
		vehicle.run();
	}
}
