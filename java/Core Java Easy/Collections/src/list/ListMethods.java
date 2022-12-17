package list;

import java.util.ArrayList;
import java.util.List;

public class ListMethods {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < 100; i = i + 10) {
			list.add(i);
		}
		// 指定された位置に要素を追加する
		list.add(2, 100);
		// 指定された位置の要素を置き換える
		list.set(3, 300);
		System.out.println(list);

		// size(): listの要素数を返す
		for (int i = 0; i < list.size(); i++) {
			// get(): listの指定された位置にある要素を返す
			System.out.println(list.get(i));
		}

	}

}
