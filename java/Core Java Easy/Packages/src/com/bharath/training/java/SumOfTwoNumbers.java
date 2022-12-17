package com.bharath.training.java;

//静的インポート
import static java.lang.Integer.*;
import static java.lang.System.*;

//組み込みライブラリからScannerクラスを使用
import java.util.Scanner;

public class SumOfTwoNumbers {

	public static void main(String[] args) {

		out.println("Enter to Scanner");
		//System.inでコンソールに入力されたデータを読み取る（System：クラス、in：Systemクラスの静的変数）
		Scanner scanner = new Scanner(System.in);
		
		//入力ストリームから一度に一つの文字列を読み取ることができる
		int num1 = parseInt(scanner.next());
		int num2 = parseInt(scanner.next());
		int result = num1 + num2;
		out.println(result);
	}

}
