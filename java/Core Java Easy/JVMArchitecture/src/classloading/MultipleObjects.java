package classloading;

public class MultipleObjects {

	public static void main(String[] args) {

		User u1 = new User();
		Class c1 = u1.getClass();

		User u2 = new User();
		Class c2 = u2.getClass();

		/*
		 * u1とu2のhashcodeは同一 →アプリケーションで特定のクラスを何度使っても、クラス自体は一度だけメモリにロードされる
		 */
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
		System.out.println(c1 == c2);
		// このクラス(c1)を読み込んでいるクラスローダーの情報を表示する
		// →アプリケーションクラスローダーで読み込んでいることがわかる
		System.out.println(c1.getClassLoader());
	}

}
