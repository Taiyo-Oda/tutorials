package synchronization.classLock;

public class DisplayMessage {
	//一度にアクセスできるのは1スレッドのみ(スレッドの同期)
	public synchronized static void sayHello(String name) {
		for (int i = 1; i <= 10; i++) {
			System.out.println("How are you " + name);
		}
	}

}
