package com.bharath.java8.methodref;

public class MethodRefDemo {

	// Runnableのrunメソッドには引数がないため、引数を指定しない
	public static void myMethod() {
		for (int i = 0; i <= 10; i++) {
			System.out.println("Child Thread");
		}
	}

	public static void main(String[] args) {
		/*
		 * RunnableのrunメソッドにmyMethodをマッピングする
		 * →ダブルコロン演算子を使って、自作のメソッドを機能インターフェイスのメソッドにマッピングする
		 */
		Runnable r = MethodRefDemo::myMethod;

		Thread t = new Thread(r);
		t.start();

		for (int i = 0; i <= 10; i++) {
			System.out.println("Parent Thread");
		}
	}

}
