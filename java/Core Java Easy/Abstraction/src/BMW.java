//クラスの抽象化
public abstract class BMW {
	
	void commonFunc() {
		System.out.println("Inside commonFunc");
	}
	
	//抽象化メソッド
	abstract void accelerate();
	
	//抽象化クラスの中でも、mainメソッドは定義できる
	public static void main(String[] args) {
		System.out.println("Inside the main method");
	}
	
}
