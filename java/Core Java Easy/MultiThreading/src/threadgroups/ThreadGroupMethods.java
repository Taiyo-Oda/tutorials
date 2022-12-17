package threadgroups;

public class ThreadGroupMethods {
	
	public static void main(String[] args) {
		//新たにスレッドグループを作成
		ThreadGroup mtg = new ThreadGroup("MyThreadGroup");
		//作成したスレッドグループの子グループを作成
		CustomThread ct1 = new CustomThread(mtg, "Thread 1");
		CustomThread ct2 = new CustomThread(mtg, "Thread 2");
		//作成した子グループのスレッドをstartする
		ct1.start();
		ct2.start();
		
		System.out.println(mtg.activeCount());
		
		mtg.list();
	}

}
