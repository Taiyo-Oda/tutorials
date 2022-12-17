
public class NonStaticMembersDemo {

	//Non-static variable（staticをつけない）
	int num;
	
	//constructor（クラス名と同じ名前のメソッド）
	NonStaticMembersDemo(){
		System.out.println("Inside the constructer");
	}
	
	//Non-static block
	//objectのインスタンスを生成するたびに呼び出される
	{
		System.out.println("Inside the Non-static block");
	}
	
	public static void main(String[] args) {
		System.out.println("Inside the main method");
		//ローカル変数
		//newでクラスのインスタンスを生成する(オブジェクト参照型)
		NonStaticMembersDemo obj = new NonStaticMembersDemo();
		
		obj.doSomething();
	}
	
	//static Block
	//クラスがロードされたとき、一度だけ実行される
	static {
		System.out.println("Inside the static block");
	}
	
	void doSomething() {
		System.out.println("Inside the doSomething");
	}
}
