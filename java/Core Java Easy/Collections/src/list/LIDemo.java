package list;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LIDemo {

	public static void main(String[] args) {

		List<String> list = new LinkedList<>();

		list.add("abc");
		list.add("xrz");
		list.add("def");

		ListIterator<String> itr = list.listIterator();

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		while (itr.hasPrevious()) {
			System.out.println(itr.previous());
		}

	}
}
