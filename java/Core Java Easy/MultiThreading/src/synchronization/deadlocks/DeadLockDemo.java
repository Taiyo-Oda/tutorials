package synchronization.deadlocks;

//Runnableインターフェイスを実装できるようにする
public class DeadLockDemo implements Runnable{
	
	//フィールド変数に、インスタンスを定義
	FirstResource fr = new FirstResource();
	SecondResource sr = new SecondResource();
	
	DeadLockDemo(){
		//
		new Thread(this).start();
	}

	public static void main(String[] args) {
		
	}
	
	@Override
	public void run() {
		
	}

}
