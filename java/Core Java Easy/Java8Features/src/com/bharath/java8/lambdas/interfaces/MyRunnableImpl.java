package com.bharath.java8.lambdas.interfaces;

public class MyRunnableImpl implements Runnable {
	// スレッドで出力したい内容を定義する
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("Child Thread");
		}
	}

}
