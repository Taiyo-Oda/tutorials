
public class Test {

	public static void main(String[] args) {
		Passenger passenger = new Passenger();
		passenger.setFirstName("Taiyo");
		passenger.setLastName("Oda");
		passenger.setId(123);
		
		Passenger passenger2 = new Passenger();
		passenger2.setFirstName("Taiyo");
		passenger2.setLastName("Oda");
		passenger2.setId(123);
		
		System.out.println(passenger.equals(passenger2));
		
	}

}
