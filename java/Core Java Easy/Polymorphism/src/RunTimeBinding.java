
public class RunTimeBinding {

	public static void main(String[] args) {
		
		//子クラスのインスタンスを作成し、親クラスに代入する(アップキャスティング)
		AppleLaptop m1 = new MacBookPro();
		AppleLaptop m2 = new MacBookAir();
		
		m1.start();
		m1.shutDown();
		
		/*
		 * m1(親インターフェイスの参照変数)をMacBookProクラスの参照変数に戻す
		 * （ダウンキャスト：明示的に行う必要がある）
		 */
		MacBookPro m3 = (MacBookPro)m1;
		m3.prosMethod();
		
		m2.start();
		m2.shutDown();
		
		/*
		 * m2(親インターフェイスの参照変数)をMacBookAirクラスの参照変数に戻す
		 * （ダウンキャスト：明示的に行う必要がある）
		 */
		MacBookAir m4 = (MacBookAir)m2;
		
	}

}
