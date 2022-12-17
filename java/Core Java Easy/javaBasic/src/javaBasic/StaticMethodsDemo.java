package javaBasic;

public class StaticMethodsDemo {

	public static void main(String[] args) {
		System.out.println("Inside method");
		StaticMethodsDemo.method1();
	}

	//何も返さないメソッド。他の関数やメソッドを定義して呼び出さなければならない
	static void method1() {
		System.out.println("Inside method1");
	}
	
	//最初に呼び出される静的ブロック
	static {
		System.out.println("Inside The Static Block");
		StaticMethodsDemo.method1();
	}
}
