package issue;

public class EvenNunmbersThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {
			System.out.println("EvenNumber is " + i);
		}
	}

}
