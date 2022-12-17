package com.bharath.lambdas.anonymous;

public class Test {

	public static void main(String[] args) {
		/*
		 * // 以下は匿名インナークラスをラムダ式を使わずに実装した場合 
		 * Thread t = new Thread(new Runnable() {
		 * 
		 * @Override 
		 * public void run() { 
		 * 	for(int i=1; i<=10; i++) {
		 * 		System.out.println("Child Thread"); 
		 * 	} 
		 * }); t.start();
		 * 
		 * for (int i = 1; i <= 10; i++) { System.out.println("Main Thread"); }
		 */

		// 以下はラムダ式を用いて匿名インナークラスを実装した場合
		Thread t = new Thread(() -> {
			for (int i = 1; i <= 10; i++) {
				System.out.println("Child Thread");
			}
		});
		t.start();
		
		for(int i=1; i<=10; i++) {
			System.out.println("Main Thread");
		}
	}

}
