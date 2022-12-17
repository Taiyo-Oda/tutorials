
//カプセル化の実装
public class Customer {
	/*
	 * クラスレベルの変数を宣言
	 * このクラスの特定のメソッドを通じてのみ、このフィールドにアクセスできる
	 */
	private String firstName;
	private String lastName;
	private String creditCard;
	
	/*
	 * セキュリティ
	 * 以下のメソッド内で、バリデーションを行い、無効な値を拒否できる
	 * 
	 * 保守性（拡張性）
	 * これらのメソッドを拡張することが容易である（他のコードに影響を与えづらい）
	 */
	public void setFirstName(String firstName) {
		if(firstName == null) {
			System.out.println("Invalid First Name");
		}
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	

}
