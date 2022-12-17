import java.util.Scanner;

public class JoinDemo extends Thread {

	static int n, sum = 0;

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		System.out.println("Sum of first 'n' numbers");
		System.out.println("Enter a value");
		Scanner scanner = new Scanner(System.in);
		JoinDemo.n = scanner.nextInt();

		JoinDemo jd = new JoinDemo();
		jd.start();
		//runメソッドの処理が終了するまで、mainメソッドの処理を待機させる
		try {
			jd.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Sum of first " + JoinDemo.n + " Number is " + JoinDemo.sum);
		
		long end = System.currentTimeMillis();
		
		System.out.println("The total time taken is " + (end - start)/1000 + " seconds.");
	}

	public void run() {
		for (int i = 0; i <= JoinDemo.n; i++) {
			JoinDemo.sum += i;
			System.out.println(sum);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
