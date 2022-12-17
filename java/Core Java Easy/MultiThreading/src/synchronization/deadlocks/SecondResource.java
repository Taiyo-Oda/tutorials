package synchronization.deadlocks;

public class SecondResource {
	
	//スレッドの同期（一度にアクセスできるのは１スレッドのみ）
	public synchronized void method1(FirstResource fr) {
		System.out.println("Inside method1 of SR");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Invoking method2 of FR");
		//FRクラスのmethod2を呼び出し
		fr.method2();
	}
	
	//スレッドの同期（一度にアクセスできるのは１スレッドのみ）
	public synchronized void method2() {
		System.out.println("Inside method2 of SR");
	}

}
