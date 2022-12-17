package p1;

import p1.p3.E;

//Aクラスと同じp1パッケージに所属しているため、Aクラスのメソッドを使用可能
public class B {
	
	public static void main(String[] args) {
		//静的メンバにはクラス名で直接アクセスできる
		A.a1();
		//非静的メンバにはオブジェクトでクラスのインスタンスを作成してアクセスする。
		A aObject = new A();
		aObject.a2();
		
		E eObject = new E();
		eObject.e1();
	}

}
