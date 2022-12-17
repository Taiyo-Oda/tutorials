package p1;

public class B {

	public static void main(String[] args) {
		
		A aObject = new A();
		//修飾子なし（パッケージレベル）
		System.out.println(aObject.b);
		//protected
		System.out.println(aObject.c);
		//public
		System.out.println(aObject.d);
	}

}
