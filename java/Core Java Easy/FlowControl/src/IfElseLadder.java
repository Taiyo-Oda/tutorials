
public class IfElseLadder {
	
	public static void main(String[] args) {
		int maths = 75, physics = 55, chemistry = 85;
		
		int result = (maths+physics+chemistry)/3;
		
		if(result <= 35) {
			System.out.println("Result is Faild");
		} else if(result <= 59) {
			System.out.println("C");
		} else if(result <= 69) {
			System.out.println("B");
		} else {
			System.out.println("A");
		}
	}

}
