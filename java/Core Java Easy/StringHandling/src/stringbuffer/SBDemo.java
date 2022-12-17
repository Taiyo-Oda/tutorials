package stringbuffer;

public class SBDemo {
	
	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer();
		System.out.println(sb.capacity());
		
		sb.append("All the power is with in you");
		sb.append("You can do anything and everyThing");
		System.out.println(sb);
		
		System.out.println(sb.capacity());
		
	}

}
