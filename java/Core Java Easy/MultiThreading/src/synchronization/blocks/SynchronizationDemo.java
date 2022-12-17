package synchronization.blocks;

public class SynchronizationDemo {

	public static void main(String[] args) {
		DisplayMessage dm = new DisplayMessage();
		
		MyThread t1 = new MyThread(dm, "Steve");
		MyThread t2 = new MyThread(dm, "Mark");
		
		//t1がsayHelloメソッドをロックするため、t2はt1の処理が終わるまで待機する
		t1.start();
		t2.start();
	}

}
