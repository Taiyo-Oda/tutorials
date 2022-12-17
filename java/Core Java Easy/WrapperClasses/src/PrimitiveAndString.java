
public class PrimitiveAndString {

	public static void main(String[] args) {
		byte x = 100;
		
		//基本型(プリミティブ型)から、ラッパー型（オブジェクト型）に変換
		String s = Byte.toString(x);
		//ラッパー型から、基本型に変換
		byte y = Byte.parseByte(s);
	}

}
