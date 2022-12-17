
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFotmatTest {

	public static void main(String[] args) {

		// 日付のインスタンスを作成（今日の日付を取得している）
		Date d = new Date();
		// Date Formatで日付のスタイルを指定する
		DateFormat usDF = DateFormat.getDateInstance(0, Locale.US);
		DateFormat ukDF = DateFormat.getDateInstance(0, Locale.UK);

		System.out.println("Date in US Format: " + usDF.format(d));
		System.out.println("Date in UK Format: " + ukDF.format(d));

		// getTimeInstance : 現在時刻を出力する
		DateFormat timeInstance = DateFormat.getTimeInstance();
		System.out.println(timeInstance.format(d));

		// getDateTimeInstance() : 日付と時刻を出力する
		DateFormat dateTimeInstance = DateFormat.getDateTimeInstance(0, 0);
		System.out.println(dateTimeInstance.format(d));

	}

}
