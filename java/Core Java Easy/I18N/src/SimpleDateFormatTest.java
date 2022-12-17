import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {

	public static void main(String[] args) {

		// SimpleDateFormat : 引数に指定したフォーマットで日付を出力できる
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/dd hh:mm:ss");
		String date = sdf.format(new Date());
		System.out.println(date);

		// parse日付の文字表現を変換する 例）DBから読み取ったデータを変換する
		String dateAsString = "10-12-2022";
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-M-yyyy");
		try {
			Date date1 = sdf1.parse(dateAsString);
			System.out.println(date1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
