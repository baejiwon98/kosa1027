package method_polymorphism;

public class DriverExample {

	public static void main(String[] args) {
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		bus.run();
		taxi.run();
		Vehicle v = bus;
		v.run();
		v = taxi;
		v.run();
		Driver driver = new Driver();
		driver.drive(taxi);
		driver.drive(bus);
		drive(bus);
		drive(taxi);
	}
	public static void drive(Vehicle v) {
		v.run();
	}

}
