
public class OverridingTest {
	
	public static void main(String[] args) {
		Car car = new Car();
		Bus bus = new Bus();
		
		System.out.println(car.fuel());
		System.out.println(bus.fuel());
	}

}
