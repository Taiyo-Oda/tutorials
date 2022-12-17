package synchronization.deadlocks;

public class FirstResource {
	
	//スレッドの同期（一度にアクセスできるのは１スレッドのみ）
	public synchronized void method1(SecondResource sr) {
		System.out.println("Inside method1 of FR");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Invoking method2 of SR");
		//Rクラスのmethod2を呼び出し
		sr.method2();
	}
	
	//スレッドの同期（一度にアクセスできるのは１スレッドのみ）
	public synchronized void method2() {
		System.out.println("Inside method2 of FR");
	}

}
