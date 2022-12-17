
public class Test {
	
	public static void main(String[] args) {
		Customer c = new Customer();
		c.setFirstName("Taro");
		c.setLastName("Yamada");
		c.setCreditCard("123456");
		
		System.out.println(c.getFirstName());
		System.out.println(c.getLastName());
		System.out.println(c.getCreditCard());
	}

}
