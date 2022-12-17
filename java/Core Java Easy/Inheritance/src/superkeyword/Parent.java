package superkeyword;

public class Parent {
	
	int a, b;
	//Parentクラスを継承しているクラスのインスタンスが作成されると、Parentクラスのコンストラクタも読み込まれる。
	Parent(int a, int b) {
		this.a = a;
		this.b = b;
	}

}
