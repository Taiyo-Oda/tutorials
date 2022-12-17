package com.bharath.trainings.ef;

import java.util.concurrent.Callable;

//callableインターフェイスを実装したクラス
public class MyCallable implements Callable<Integer> {

	int num;

	MyCallable(int num) {
		this.num = num;
	}

	@Override
	public Integer call() throws Exception {
		System.out.println(
				Thread.currentThread().getName() 
				+ " is calculating the same of all the numbers up to " 
				+ num
			);

		int sum = 0;

		for (int i = 0; i <= num; i++) {
			sum += i;
		}

		return sum;
	}

}
