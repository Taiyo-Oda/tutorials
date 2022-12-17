
import java.text.NumberFormat;

public class NumberFormatTest {

	public static void main(String[] args) {

		// NumberFormatを使用して、与えられた数値をLocaleに従って表現する（以下はフランス表記に変更している）
		Double d = 1232322.3434;
		NumberFormat nf = NumberFormat.getInstance();

		// 分数桁を４桁に設定する（デフォルトは３桁）
		nf.setMinimumFractionDigits(4);
		// 分数桁の最大値を制御する
		nf.setMaximumFractionDigits(3);
		// 整数桁の桁数を設定する
		nf.setMaximumIntegerDigits(4);
		System.out.println(nf.format(d));

	}

}
