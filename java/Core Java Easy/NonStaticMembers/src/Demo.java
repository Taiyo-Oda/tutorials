
public class Demo {
	
	static Demo obj = new Demo();
	//静的ブロック
	static {
		//ローカル変数
		//Demo obj = new Demo();
		System.out.println(Demo.obj);
		Demo.init();
		Demo.obj = Demo.doit();
	}
	
	public static void main(String[] args) {
		System.out.println(Demo.obj);
	}
	
	//静的メソッド(戻り値なし)
	static void init() {
		Demo.obj = new Demo();
	}
	//静的メソッド(戻り値あり)
	static Demo doit() {
		return new Demo();
	}
}
