package maps;

public class User {
	
	@Override
	public String toString() {
		return "user";
	}
	
	//ガベージコレクタが実行された時に呼び出される
	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize Called");
	}

}
