package staticinner;

public class Outer {
	//静的クラスの外にある静的メソッド
	static void f1() {
		System.out.println("Outers static method");
	}
	
	//静的な内部クラスを作成
	static class Inner {
		//静的クラス内の、静的メソッド
		static void f2() {
			System.out.println("Inner static method");
		}
		//静的クラス内の、非静的メソッド
		void f3() {
			System.out.println("Non static method Inside the inner class");
		}
		
	}
	
	public static void main(String[] args) {
		//静的メソッドの呼び出し
		Outer.f1();
		Outer.Inner.f2();
		
		//非静的メソッドの呼び出し
		Outer.Inner inner = new Outer.Inner();
		inner.f3();
	}

}
