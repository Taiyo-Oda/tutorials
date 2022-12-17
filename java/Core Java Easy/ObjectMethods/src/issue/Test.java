package issue;

public class Test {

	public static void main(String[] args) {
		ElectricityBill eb = new ElectricityBill();
		eb.setMeterNum(123);
		eb.setName("billName");
		eb.setAddress("Tokyo");

		ElectricityBill eb2 = new ElectricityBill();
		eb2.setMeterNum(123);
		eb2.setName("billName");
		eb2.setAddress("Tokyo");

		System.out.println(eb);
		System.out.println(eb.equals(eb2));
		System.out.println(eb.hashCode());
	}

}
