package com.bharath.java8.lambdas.interfaces;

public class Test {

	public static void main(String[] args) {
		// 以下は通常の方法で実装した場合
		/*
		 * // Runnable実装クラスを別で作成し、インスタンス化する 
		 * Runnable r = new MyRunnableImpl(); 
		 * // Runnable実装クラスのインスタンスを引数にThreadクラスをインスタンス化する 
		 * Thread t = new Thread(r);
		 * t.start();
		 * 
		 * for (int i = 1; i <= 10; i++) { System.out.println("Main Thread"); }
		 */
		
		// ラムダ式で実装した場合
		Runnable r = () -> {
			for (int i = 1; i <= 10; i++) {
				System.out.println("Child Thread");
			}
		};

		Thread t = new Thread(r);
		t.start();

		for (int i = 1; i <= 10; i++) {
			System.out.println("Main Thread");
		}
	}

}
