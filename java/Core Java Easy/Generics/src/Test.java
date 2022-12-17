public class Test {

	public static void main(String[] args) {
		
		MyGenericClass<String> s = new MyGenericClass<>("Bharaht");
		s.displayObjectDetails();
		System.out.println(s.getObject());

		MyGenericClass<Integer> i = new MyGenericClass<>(123);
		i.displayObjectDetails();
		System.out.println(i.getObject());
		
		MyGenericClass<Double> d = new MyGenericClass<>(12.34);
		d.displayObjectDetails();
		System.out.println(d.getObject());
	}
	
}
