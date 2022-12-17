package com.bharath.java8.methodref.constructors;

public class Test {

	public static void main(String[] args) {
		// MyClassのインスタンスを返すラムダ式を表現している
		MyInterface f1 = s -> new MyClass(s);
		f1.get("Using Lambdas");

		// コンストラクタのマッピングを行う場合は、クラス名::new演算子を使用する
		MyInterface f2 = MyClass::new;
		f2.get("Using Constructor Mapping");
	}
}
