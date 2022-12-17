package issue;

public class MainThread {

	public static void main(String[] args) {
		EvenNunmbersThread en = new EvenNunmbersThread();
		OddNumbersThread on = new OddNumbersThread();

		en.start();
		on.start();
	}

}
