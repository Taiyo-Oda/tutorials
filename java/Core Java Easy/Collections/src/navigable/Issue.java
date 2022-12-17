package navigable;

import java.util.TreeMap;

public class Issue {

	public static void main(String[] args) {

		TreeMap<String, String> map = new TreeMap<String, String>();

		map.put("A", "Apple");
		map.put("B", "Butter");
		map.put("C", "Cake");
		map.put("D", "Dog");
		map.put("E", "English");

		System.out.println(map.floorKey("B"));
		System.out.println(map.lowerKey("D"));
		System.out.println(map.ceilingKey("C"));
		System.out.println(map.higherKey("A"));
		System.out.println(map.pollFirstEntry());
		System.out.println(map.pollLastEntry());
		System.out.println(map.descendingMap());
		
	}
}
