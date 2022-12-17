package nonstaticinner;

public class Outer {

	private static int x = 10;
	private int y;

	Outer(int y) {
		this.y = y;
	}

	void f1() {
		System.out.println("Outer");
	}

	// 非静的な内部クラス
	class Inner {
		//内部クラス内のメンバ変数
		private int y;

		// 内部クラスのコンストラクタ
		Inner(int y) {
			this.y = y;
		}

		private void f2() {
			//外部クラスの静的変数にアクセス
			System.out.println("Outer Classes X " + Outer.x);
			//外部クラスの非静的変数にアクセス
			System.out.println("Outer Classes Y " + Outer.this.y);
			//内部クラスの非静的変数にアクセス
			System.out.println("Inner Classes Y " + this.y);
		}

	}

	public static void main(String[] args) {
		Outer outer = new Outer(20);
		outer.f1();

		// 親のインスタンスを使用して、非静的クラスの内部メソッドを呼び出す
		Outer.Inner inner = outer.new Inner(30);
		inner.f2();
	}

}
