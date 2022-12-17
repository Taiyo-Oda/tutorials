
public class Test {
	
	public static void main(String[] args) {
		
		PaymentType pt = PaymentType.CREDITCARD;
		// デフォルトでEnumのtoStringメソッドは定数の名前を返すようにオーバーライドされている
		//System.out.println(pt);
		
		// values() : Enumで定義した定数の配列が返される
		PaymentType[] paymentTypes = PaymentType.values();
		for(PaymentType paymentType : paymentTypes) {
			System.out.println(paymentType);
			// ordinal() : Enum内の定数の位置を返す
			System.out.println(paymentType.ordinal());
			System.out.println(paymentType.getFee());
		}
	}
	
}
