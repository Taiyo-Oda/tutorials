package collectionsutil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortedList {

	public static void main(String[] args) {

		List<String> l = new ArrayList<>();

		l.add("Z");
		l.add("A");
		l.add("Q");
		l.add("F");

		System.out.println("Before Sorting: " + l);
		// Listを自然な順番で並び替える
		Collections.sort(l);
		// Comparatorを引数として渡して、sortメソッドをオーバーロードする
		// Collections.sort(l, new MyComparator());

		System.out.println("After Sorting: " + l);
		// リスト内の要素を検索し、要素のインデックス（整数）を返す
		int result = Collections.binarySearch(l, "X");
		System.out.println("Index is: " + result);
	}

}
