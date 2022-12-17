package navigable;

import java.util.TreeSet;

public class NavigableTreeSetDemo {

	public static void main(String[] args) {
		// SortedSetの子インターフェースで、TreeSetクラスで実装される
		TreeSet<Integer> s = new TreeSet<Integer>();

		s.add(10);
		s.add(20);
		s.add(30);
		s.add(40);
		s.add(50);

		System.out.println(s);
		// 渡した要素以上の値を持つ、最も小さい要素を返す
		System.out.println(s.ceiling(20));
		// 渡した要素より大きい、最小の要素を返す
		System.out.println(s.higher(40));
		// 渡した要素以下の最大の値を返す
		System.out.println(s.floor(10));
		// 渡した要素より小さい、最も大きい値を返す
		System.out.println(s.lower(30));
		// セット内の最初の要素を削除して返す
		System.out.println(s.pollFirst());
		// セット内の最後の要素を削除して返す
		System.out.println(s.pollLast());
		// セットを降順で返す
		System.out.println(s.descendingSet());

		System.out.println(s);
	}
}
