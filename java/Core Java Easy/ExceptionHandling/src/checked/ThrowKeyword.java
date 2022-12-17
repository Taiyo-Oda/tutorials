package checked;

public class ThrowKeyword {
	
	public static void main(String[] args) {
		
		//ロジック上想定していないことが起きた場合は、この例外を投げる
		throw new RuntimeException("Founds not available");
		
	}

}
