package com.bharath.java8.methodref;

public class MyClass {

	// インターフェイスの引数と同じ引数を持つ自作メソッドを作成する
	public void myMethod123(int i) {
		System.out.println(i);
	}

	public static void main(String[] args) {
		// myMethodに指定した引数を返すラムダ式を表現している
		MyInterface f = i -> System.out.println(i);
		f.myMethod(10);

		// このクラスのインスタンスを作成し、ダブルコロンを使用して、自作のメソッドをマッピングする
		MyClass c = new MyClass();
		MyInterface f1 = c::myMethod123;
		f1.myMethod(20);
	}

}
