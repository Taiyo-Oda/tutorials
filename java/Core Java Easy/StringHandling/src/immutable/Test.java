package immutable;

public class Test {
	
	public static void main(String[] args) {
		
		//immutable
		User user = new User(1, "John");
		System.out.println(user);
		
		//mutable
		String s = new String("Bharath");
		System.out.println(s);
		//mutable
		Integer i = new Integer(30);
		System.out.println(i);
	}

}
