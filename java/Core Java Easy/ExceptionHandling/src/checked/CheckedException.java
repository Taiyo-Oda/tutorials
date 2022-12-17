package checked;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CheckedException {

	//throws : メソッドが例外処理しないことを宣言する
	void readFile() throws FileNotFoundException {

		FileInputStream fis = new FileInputStream("");

	}

	//呼び出すメソッドがthrowを宣言しているため、呼び出しもとで例外処理できるようにしておく
	public static void main(String[] args) {

		CheckedException ce = new CheckedException();
		try {
			ce.readFile();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}

	}

}
