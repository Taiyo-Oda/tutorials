package p1;

public class A {

	//クラスレベル
	private int a = 30;
	//パッケージレベル
			int b = 40;
	//パッケージ内と継承先クラス内
	protected int c = 50;
	//どこからでも
	public int d = 60;
	
	public static void main(String[] args) {
		//非静的メンバにアクセスするため、コンストラクタ(ここではデフォルトコンストラクタ)を呼び出すためのインスタンスを作る
		A aObject = new A();
		System.out.println(aObject.a);
		System.out.println(aObject.b);
		System.out.println(aObject.c);
		System.out.println(aObject.d);
	}

}
