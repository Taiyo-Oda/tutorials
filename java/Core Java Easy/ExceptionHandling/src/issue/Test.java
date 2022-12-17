package issue;

public class Test {
	
	public static void main(String[] args){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new MyThreadException("message defined in the test");
		}
	}

}
