package com.bharath.java8.lambdas.basics;

// @FunctionalInterfaceでマークすることで抽象的なメソッドを１つ以上定義できなくする(必須ではない)
@FunctionalInterface
public interface A {

	void myMethod();
	
}
