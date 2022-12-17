
public class BankAccount {
	
	//銀行名はこのクラスのオブジェクトで共通のため、静的なフィールド(メンバ変数)とする
	static String bankName ="Bank Of America";
	//以下の３つはこのクラスの各オブジェクトに対して一意であるため、非静的なフィールド(メンバ変数)としている
	String accountHoldersName;
	String accountNumber;
	float balance;

	public static void main(String[] args) {
		//ローカル変数。デフォルトで初期化する必要がある。
		double loanInterestRate = 7.5;
		
		//className.fieldNameとすることで、静的フィールドであるとわかりやすい
		System.out.println(BankAccount.bankName);
		//オブジェクトのインスタンスを作成（参照しているメンバーにアクセスできるようにする）
		BankAccount bankAccount = new BankAccount();
		bankAccount.accountHoldersName = "John";
		bankAccount.accountNumber = "123456789";
		bankAccount.balance = 20000f;
		System.out.println(bankAccount.accountHoldersName);
		System.out.println(bankAccount.accountNumber);
		System.out.println(bankAccount.balance);
	}

}
