package concurrentcollections;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class ArraySetProblem extends Thread {
	
	// 反復中の配列セットに修正を加えようとすると配列セットのコピーを作成し、変更はそのコピーに対して行われる
	static CopyOnWriteArraySet<String> courses = new CopyOnWriteArraySet<>();
			
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		courses.add("Kubernetes");
	}

	public static void main(String[] args) throws InterruptedException {
		
		ArraySetProblem arrayListProblem = new ArraySetProblem();
		arrayListProblem.start();
		
		courses.add("Java");
		courses.add("Python");
		courses.add("AWS");
		courses.add("Docker");

		// Iterator : 集合の要素に順番にアクセスするインターフェイス
		Iterator<String> iterator = courses.iterator();

		// hasNex() : 次の要素がある場合true, ない場合false 
		while (iterator.hasNext()) {
			Thread.sleep(2000);
			String course = iterator.next();
			System.out.println(course);
		}
		
		System.out.println(courses);
	}

}
