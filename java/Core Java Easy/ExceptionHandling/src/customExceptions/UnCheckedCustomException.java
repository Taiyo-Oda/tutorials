package customExceptions;

public class UnCheckedCustomException extends RuntimeException{
	
	/*
	 * このコンストラクタは文字列メッセージを受け取ることができる
	 */
	UnCheckedCustomException(String message) {
		//親クラスにメッセージを渡す
		super(message);
	}

}
