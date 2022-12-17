package threadgroups;

public class ThreadGroupDemo {

	public static void main(String[] args) {
		//現在稼働しているスレッドのグループを取得する
		System.out.println(Thread.currentThread().getThreadGroup().getName());
		System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
		
		//新たにスレッドグループを作成する
		ThreadGroup parent = new ThreadGroup("parent");
		System.out.println(parent.getName());
		ThreadGroup child = new ThreadGroup(parent, "child");
		System.out.println(child.getName());
		System.out.println(child.getParent().getName());
		
		Thread thread1 = new Thread(child, "thread1");
		Thread thread2 = new Thread(child, "thread2");
		System.out.println(thread1.getThreadGroup().getName());
		System.out.println(thread1.getPriority());
	}

}
