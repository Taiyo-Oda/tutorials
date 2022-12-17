package collectionsutil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsReverseDemo {

	public static void main(String[] args) {
		
		List<Integer> l = new ArrayList<>();
		
		l.add(10);
		l.add(5);
		l.add(59);
		l.add(32);
		
		System.out.println("Before Reversing: " + l);
		// Listの並びを反転させる
		Collections.reverse(l);
		
		System.out.println("After Reversing: " + l);
	}
}
