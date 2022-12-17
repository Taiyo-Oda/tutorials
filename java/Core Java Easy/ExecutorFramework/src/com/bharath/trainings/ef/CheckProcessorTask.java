package com.bharath.trainings.ef;

public class CheckProcessorTask implements Runnable {

	String name;

	// タスクの作成時に変数が初期化されるようにする
	public CheckProcessorTask(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		// 現在のスレッドがどれか確認用
		System.out.println(name + " Check Processor has began processing the check" + Thread.currentThread().getName());

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//どのスレッドが終了したか確認用
		System.out.println(
				name + "Check Processor has compleated proccesing the check" + Thread.currentThread().getName());
	}

}
