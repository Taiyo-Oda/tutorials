public class PrimitiveAndObject {
	public static void main(String[] args) {
		int x = 100;
		//プリミティ型のintegerを受け取り、オブジェクト型のIntegerを返す。
		Integer y = Integer.valueOf(x);
		//オブジェクト型のIntegerを受け取り、プリミティブ型のIntegerを返す。
		int z = y.intValue();
	}
}
