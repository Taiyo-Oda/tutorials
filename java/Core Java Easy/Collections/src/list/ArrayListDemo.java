package list;
//ArrayListクラスで動的な配列を作成する
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo {

	public static void main(String[] args) {
		/*
		 * 作成したlistはデータ型を指定していないため、あらゆる種類のオブジェクトを追加したり、取り出したりできる。
		 * →ランタイムの問題を引き起こす可能性が大きい
		 */
		ArrayList list = new ArrayList();
		list.add(new Integer(20));
		list.add(10);
		list.add(30.45);
		list.add("Hello World!");
		
		/*
		 * ジェネリックという概念を使用して、データ型の制限を行う
		 */
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(new Integer(20));
		list2.add(10);
		list2.add(30);
		
		Iterator<Integer> itr = list2.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
			itr.remove();
		}
		System.out.println(list2);
	}

}
