import java.util.Scanner;

public class Division {

	public static void main(String[] args) {

		int a, b, c;

		try {
			System.out.println("Enter Two Integers");
			Scanner obj = new Scanner(System.in);
			a = obj.nextInt();
			b = obj.nextInt();
			c = a / b;
			System.out.println("Result " + c);
		} catch (ArithmeticException e) {
			System.out.println("ERROR : Please Not Enter a 0");
		} finally {
			System.out.println("Fianlly");
		}

		System.out.println("More code can go here");

	}

}
