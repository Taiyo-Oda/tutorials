package com.bharath.java8.lambdas.basics;


public class Test {

	public static void main(String[] args) {
		// ラムダ式で実装すると以下のような構文で処理を実装できる
		A a = () -> System.out.println("Inside MyMethod");
		a.myMethod();

	}

}
