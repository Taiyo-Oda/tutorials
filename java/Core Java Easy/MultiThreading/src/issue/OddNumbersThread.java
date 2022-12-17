package issue;

public class OddNumbersThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {
			System.out.println("OddNumber is " + i);
		}
	}

}
