//マルチスレッドの実装
//1.java.langパッケージのThreadクラスを拡張する
public class MultiThreaded extends Thread {

	// 以下の処理では、mainとrunの処理が切り替わりながら実行される

	public static void main(String[] args) throws InterruptedException {

		MultiThreaded mt1 = new MultiThreaded();
		mt1.setPriority(MIN_PRIORITY);
		mt1.setName("mt1");
		// 別のスレッドを作成し、そのスレッドがMultiThreadedクラスのrunメソッドを呼び出す
		mt1.start();
		
		MultiThreaded mt = new MultiThreaded();
		mt.setPriority(MAX_PRIORITY);
		mt.setName("mt");
		// 別のスレッドを作成し、そのスレッドがMultiThreadedクラスのrunメソッドを呼び出す
		mt.start();
		
		/*
		 * for (int j = 0; j <= 200; j++) { System.out.print("j : " + j + "\t");
		 * Thread.sleep(1000); }
		 */
	}

	public void run() {
		System.out.println("Thread Name: " + Thread.currentThread().getName());
		/*
		 * for (int i = 0; i <= 200; i++) { System.out.print("i : " + i + "\t"); try {
		 * //このスレッドの処理を、指定した時間だけ停止させる Thread.sleep(1000); } catch (InterruptedException
		 * e) { System.out.println("Child Thread Exiting"); } }
		 */
	}

}
