
public class ObjectReferenceDemo {
	
	//Non-static variable
	int x;
	
	//constructor
	ObjectReferenceDemo() {
		
	}
	
	public static void main(String[] args) {
		//オブジェクトの参照
		ObjectReferenceDemo ord = new ObjectReferenceDemo();
		//参照しているオブジェクトのメンバー(変数やメソッド)にアクセスすることができる
		System.out.println(ord.x);
	}

}
