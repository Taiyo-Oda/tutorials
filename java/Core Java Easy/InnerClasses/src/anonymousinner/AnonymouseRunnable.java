package anonymousinner;

public class AnonymouseRunnable {

	public static void main(String[] args) {
		
		//どんなインターフェイスにも匿名内部クラスを作成することができる
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Anonymouse Inner classes method");
			}
		});
		
		t.start();
		
	}

}
