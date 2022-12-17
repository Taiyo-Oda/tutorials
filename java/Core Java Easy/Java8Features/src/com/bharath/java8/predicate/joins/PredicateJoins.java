package com.bharath.java8.predicate.joins;

import java.util.function.Predicate;

public class PredicateJoins {

	public static void main(String[] args) {

		int[] x = { 0, 7, 10, 20, 30, 40, 50, 60, 70, 73 };

		// 与えられた数字が10より大きい場合はtrue
		Predicate<Integer> p1 = i -> i > 10;
		// 与えられた数字が、偶数がどうかチェックする
		Predicate<Integer> p2 = i -> i % 2 == 0;

		System.out.println("Greater than 10:");
		method1(p1, x);
		System.out.println("Even Numbers:");
		method1(p2, x);

		// negate() : 否定演算子（今回の場合は10より小さい場合trueとなる）
		System.out.println("Not greater 10:");
		method1(p1.negate(), x);
		// and() : AND演算子(p1かつp2の場合にtrueを返す)
		System.out.println("Greater than 10 AND Even");
		method1(p1.and(p2), x);
		// or() : OR演算子(p1かp2のどちらかに一致する場合はtrueを返す)
		System.out.println("Greater than 10 OR Even");
		method1(p1.or(p2), x);

	}

	// 関数にPredicateを渡す
	static void method1(Predicate<Integer> p, int[] x) {

		for (int eachValue : x) {
			if (p.test(eachValue)) {
				System.out.println(eachValue);
			}
		}

	}

}
