package classloading;

import java.lang.reflect.Method;

public class Test {
	// クラスを動的にメモリにロードし、その情報を取得する
	public static void main(String[] args) throws ClassNotFoundException {
		/*
		 * 引数でクラス名を受け取り、それをメモリにロードする。 クラスが見つからなければ例外を投げる
		 */
		Class c = Class.forName("User");

		// getDeclaredMethods()：メソッドの配列を返す(今回はUserクラスで定義したメソッド)
		Method[] methods = c.getDeclaredMethods();

		for (Method method : methods) {
			// getName(): メソッド名を取得する
			System.out.println(method.getName());
		}
		System.out.println(methods.length);

	}

}
