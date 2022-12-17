package com.bharath.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterEvenNumbers {

	public static void main(String[] args) {
		/*
		 * 以下はコレクションデータの処理方法 偶数のみを出力できるようにフィルタリングを行う
		 */
		List<Integer> l1 = new ArrayList<>();
		for (int i = 0; i <= 10; i++) {
			l1.add(i);
		}
		System.out.println(l1);

		// 通常の方法
		List<Integer> l2 = new ArrayList<>();
		for (Integer i : l1) {
			if (i % 2 == 0) {
				l2.add(i);
			}
		}
		System.out.println(l2);

		// streamを使用
		List<Integer> collect = l1.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
		/*
		 * li.stream().filter(i -> % 2 == 0)
		 * →streamの設定（filterメソッドで偶数番号のみをフィルタリングする）
		 * .collect(Collectors.toList())
		 * →処理ステップ(CollectoreクラスのtoList()メソッドを使用してフィルタからの出力をリストに集めている)
		 */

	}

}
