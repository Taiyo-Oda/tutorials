package com.bharath.java8.predicate;

import java.util.function.Predicate;

public class GreaterThanTwenty {

	public static void main(String[] args) {
		
		// Predicateインターフェイスをラムダ式で表現
		Predicate<Integer> p = i -> (i > 20);
		
		System.out.println(p.test(15));
		System.out.println(p.test(20));
		System.out.println(p.test(25));
	}

}
