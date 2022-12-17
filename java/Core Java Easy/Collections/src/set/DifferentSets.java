package set;

import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

public class DifferentSets {

	public static void main(String[] args) {
		
		Random obj = new Random();
		
		//HashSet<Integer> set = new HashSet<>();
		
		//順序を維持する
		//LinkedHashSet<Integer> set = new LinkedHashSet<>();
		
		//要素を昇順に並べ替える
		TreeSet<Integer> set = new TreeSet<>();
		
		for(int i = 0; i<5; i++) {
			int number = obj.nextInt(100);
			set.add(number);
			System.out.println(number);
		}
		
		System.out.println(set);
		
		Iterator<Integer> itr = set.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
			itr.remove();
		}
		System.out.println(set);
		
	}
}
