package abstractionIssue;

public class Test {

	public static void main(String[] args) {
		HPNotebook hpn = new HPNotebook();
		hpn.scroll();
		hpn.click();
		
		/*
		 *抽象クラスのインスタンスは作成できないため、抽象クラスを継承したクラスのインスタンスを作成
		 *抽象クラスと、インターフェイスにアクセスできる。
		 */
		DELLNotebook den = new DELLNotebook();
		den.scroll();
		den.click();
	}
	
}
