package synchronization.blocks;

public class DisplayMessage {

	public void sayHello(String name) {
		//ブロックレベルの同期
		synchronized (this) {
			for (int i = 1; i <= 10; i++) {
				System.out.println("How are you " + name);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
