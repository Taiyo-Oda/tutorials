package customExceptions;

public class CheckedCustomException extends Exception{
	
	CheckedCustomException(String message) {
		//親クラスにメッセージを渡す
		super(message);
	}

}
