import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BufferedReaderDemo {

	public static void main(String[] args) {

		int count = 0;

		try (FileReader fr = new FileReader("/Users/odataiyou/test/test.txt");
				BufferedReader br = new BufferedReader(fr);) {

			String line;
			// ファイル内を1行ずつ読み取り、なくなったらnullを返す
			while ((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line);
				while (st.hasMoreTokens()) {
					System.out.println(st.nextToken());
					count++;
				}
			}
			System.out.println(count);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
