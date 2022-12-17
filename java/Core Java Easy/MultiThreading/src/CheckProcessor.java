
public class CheckProcessor implements Runnable {

	@Override
	public void run() {
		System.out.println("Processed the Checks");
	}

	public static void main(String[] args) {
		
		CheckProcessor cp = new CheckProcessor();
		//Threadコンストラクタは、runnable型の引数を取得する。
		Thread t = new Thread(cp);
		t.start();

	}

}
