
import java.util.Locale;

public class LocaleTest {

	public static void main(String[] args) {

		// JVMがシステムの起動時にシステムの設定を使ってデフォルトのLocaleを設定する

		// デフォルトのlocale情報を表示する
		Locale l = Locale.getDefault();
		System.out.println(l.getCountry() + " " + l.getLanguage());
		System.out.println(l.getDisplayCountry() + " " + l.getDisplayLanguage());

		// デフォルトの情報を変更することもできる
		Locale.setDefault(Locale.UK);
		System.out.println(Locale.getDefault().getDisplayCountry());

		// サポートされている国の一覧を取得できる
		String[] isoCountries = Locale.getISOCountries();
		for (String eachCountry : isoCountries) {
			System.out.println(eachCountry);
		}

		// サポートされている言語情報を全て取得する
		String[] languages = Locale.getISOLanguages();
		for (String eachLanguage : languages) {
			System.out.println(eachLanguage);
		}
	}

}
