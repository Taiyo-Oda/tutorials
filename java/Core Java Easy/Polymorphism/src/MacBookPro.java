
public class MacBookPro extends MacBook {
	
	@Override
	public void start() {
		System.out.println("Inside MacBookPros start method");
	}
	
	@Override
	public void shutDown() {
		System.out.println("Inside MacBookPros shutDown method");
	}
	
	//このクラス独自のメソッド
	public void prosMethod() {
		System.out.println("Inside MacBookPros prosMethod method");
	}

}
