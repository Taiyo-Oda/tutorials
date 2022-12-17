package maps;

import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapDemo {

	public static void main(String[] args) {
		
		//Map<Integer, String> map = new HashMap<>();
		Map<Integer, String> map = new IdentityHashMap<>();
		
		Integer id1 = new Integer(10);
		Integer id2 = new Integer(10);
		
		//HashMap: .equals()メソッドを使用しているため値が同じだと上書きされる
		//IdentityHashMap: ＝＝で２つのキーを比較する（参照先(メモリ上の同じオブジェクトをさしているか)の比較）ため、値が同じでも上書きされない
		map.put(id1, "Bharath");
		map.put(id2, "Sarath");
		
		System.out.println(map);
	}
	
}
