
public class MacBook implements AppleLaptop{
	
	//親インターフェイスをオーバーライドしている
	public void start(){
		System.out.println("Inside MacBook start()");
	}
	
	//親インターフェイスをオーバーライドしている
	public void shutDown(){
		System.out.println("Inside MacBook shutDown()");
	}

}
