
public class ThisKeywordDemo {
	
	//非静的変数
	int x;
	
	//コンストラクタ
	ThisKeywordDemo(){
		//this: メモリ上のオブジェクトのアドレスを参照している
		System.out.println(this);
		System.out.println(this.x);
	}
	
	
	public static void main(String[] args) {
		new ThisKeywordDemo();
		new ThisKeywordDemo();
	}

}
