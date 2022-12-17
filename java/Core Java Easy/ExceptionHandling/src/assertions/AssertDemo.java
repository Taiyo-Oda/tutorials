package assertions;

public class AssertDemo {

	public static void main(String[] args) {

		int widthdrowAmount = 100;
		int currentBalance = 90;
		
		assert(widthdrowAmount <= currentBalance):"Withdrowl amount is more than current balance";
	}

}
