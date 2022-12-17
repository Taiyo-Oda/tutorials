package com.bharath.trainings.ef;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureDemo {

	public static void main(String[] args) {
		
		MyCallable[] callables = {
			new MyCallable(10),
			new MyCallable(20),
			new MyCallable(30),
			new MyCallable(40),
			new MyCallable(50),
			new MyCallable(60),
		};
		
		//スレッドプールの作成（引数でスレッドプールの大きさを指定する）
		ExecutorService service = Executors.newFixedThreadPool(3);
		
		//callableのインスタンスをプールに渡す
		for (MyCallable myCallable : callables) {
			Future<Integer> future = service.submit(myCallable);
			
			try {
				//getメソッドで戻り値を取得する
				System.out.println(future.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		service.shutdown();
		
	}

}
