package maps;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapDemo {

	public static void main(String[] args) {
		// keyとvalueのデータ型を指定する
		Map<String, Integer> map = new LinkedHashMap<>();

		// putメソッドでMapに要素を入れることができる
		map.put("John", 70);
		map.put("Tom", 50);
		map.put("Lee", 99);
		map.put("Brad", 80);

		// keySetでキーだけを取得する
		Set<String> keySet = map.keySet();
		System.out.println("keys: " + keySet);
		// valuesで値だけを取得する
		Collection<Integer> values = map.values();
		System.out.println("values: " + values);

		for (String key : keySet) {
			System.out.println("key: " + key + "value: " + map.get(key));
		}
	}
}
