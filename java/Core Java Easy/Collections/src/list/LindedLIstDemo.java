package list;

import java.util.LinkedList;
import java.util.List;

public class LindedLIstDemo {

	public static void main(String[] args) {

		Object objects[] = new Object[100000];
		for (int i = 0; i < objects.length; i++) {
			objects[i] = new Object();
		}
		
		//要素をノードという形で格納する
		List<Object> list = new LinkedList<>();
		long start = System.currentTimeMillis();
		for (Object object : objects) {
			list.add(object);
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

}
