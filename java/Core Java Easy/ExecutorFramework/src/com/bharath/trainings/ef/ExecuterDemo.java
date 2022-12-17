package com.bharath.trainings.ef;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuterDemo {

	public static void main(String[] args) {

		CheckProcessorTask[] cps = { 
				new CheckProcessorTask("ATM"), 
				new CheckProcessorTask("Bank"),
				new CheckProcessorTask("Mobile"), 
				new CheckProcessorTask("Web"), 
			};
		
		//スレッドプールの作成(引数でスレッドプールの大きさを指定する)
		ExecutorService service = Executors.newFixedThreadPool(2);

		//作成した配列の中から、スレッドプールの大きさの分だけタスクが実行される
		for (CheckProcessorTask checkProcessorTask : cps) {
			service.submit(checkProcessorTask);
		}

		//すべてのタスクが終わったら、スレッドプールをシャッドダウンする
		service.shutdown();

	}

}
