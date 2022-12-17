package maps;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapDemo {

	public static void main(String[] args) throws InterruptedException {
		
		//Map<User, String> map = new HashMap<>();
		
		/*
		 * キーが弱参照で格納される
		 * →このマップ以外のどこからもキーが参照されなくなるとガベージコレクションの対象となる
		 */
		Map<User, String> map = new WeakHashMap<>();
		
		User u = new User();
		map.put(u, "Tom");
		
		//参照型が引数に指定された場合は、そのオブジェクトのtoString()が実行される。
		System.out.println(map);
		
		u = null;
		
		System.gc();
		Thread.sleep(2000);
		
		System.out.println(map);
		
	}
}
