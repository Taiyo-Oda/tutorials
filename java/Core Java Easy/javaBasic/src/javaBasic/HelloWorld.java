package javaBasic;

public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("Hello World!");
	}
	
	//静的ブロック。mainメソッドが呼ばれる前に一度だけロードされる
	static {
		System.out.println("Static Block");
	}

}
