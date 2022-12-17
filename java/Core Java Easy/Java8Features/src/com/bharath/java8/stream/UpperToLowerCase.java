package com.bharath.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UpperToLowerCase {

	public static void main(String[] args) {

		List<String> l1 = new ArrayList<>();
		l1.add("JOHN");
		l1.add("BHARATH");
		l1.add("JIM");

		System.out.println(l1);

		List<String> l2 = l1.stream().map(s -> s.toLowerCase()).collect(Collectors.toList());
		/*
		 * l1.stream().map(s -> s.toLowerCase())
		 * →streamの設定（mapメソッドを使用して、コレクション内の各要素を与えられた関数に変換する）
		 * .collect(Collectors.toList())
		 * →処理ステップ(変換後の全ての要素を受け取り、コレクションの中に入れる)
		 */
		System.out.println(l2);
	}

}
