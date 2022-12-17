package outputstreams;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReaderAndWriterDemo {

	public static void main(String[] args) {

		FileReader fr = null;
		FileWriter fw = null;

		try {
			fr = new FileReader("/Users/odataiyou/test/test.txt");
			fw = new FileWriter("/Users/odataiyou/test/newTest.txt");

			int ch;
			// ファイル内の文字を1byteずつ読み取り、末端に来たら-1を返す
			while ((ch = fr.read()) != -1) {
				fw.write(ch);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
