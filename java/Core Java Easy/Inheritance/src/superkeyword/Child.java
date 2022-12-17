package superkeyword;

public class Child extends Parent{
	
	int c, d;
	
	//Parentクラスを継承しているため、superメソッドを使用してa,bの引数も渡している。
	Child(int a, int b, int c, int d) {
		super(a,b);
		this.c = c;
		this.d = d;
	}
	
	void displayDetails() {
		//親クラスのメンバ（変数）にアクセスするために、superを使用できる
		System.out.println("Parents a" + super.a);
		System.out.println("Parents b" + super.b);
		System.out.println("Childs c" + this.c);
		System.out.println("Childs d" + this.d);
	}
	

}
