import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * FileInputStreamで
 * ファイルの内容を読み取る
 */
public class FileInputStreamDemo {

	public static void main(String[] args) {

		FileInputStream fis = null;
		try {
			// 読み取るファイルを開く
			fis = new FileInputStream(new File("/Users/odataiyou/test/test.txt"));
			System.out.println("File Opened");

			int i;
			// ファイル内の文字を1byteずつ読み取り、末端に来たら-1を返す
			while ((i = fis.read()) != -1) {
				System.out.println((char) i);
			}

			// FileInputStreamの例外処理
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			// readの例外処理
		} catch (IOException e) {
			e.printStackTrace();
			// 開いたファイルを閉じる
		} finally {
			try {
				fis.close();
				System.out.println("File Closed");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
