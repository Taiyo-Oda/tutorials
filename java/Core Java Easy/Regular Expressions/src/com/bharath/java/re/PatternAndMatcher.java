package com.bharath.java.re;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternAndMatcher {

	public static void main(String[] args) {
		// 文字列の正規表現を受け取り、patternオブジェクトを返す
		Pattern pattern = Pattern.compile("abc");
		// 作成したパターンを作成して、マッチパターンを得る
		Matcher matcher = pattern.matcher("abcdefghijabcdefgabcdefg");
		while (matcher.find()) {
			// マッチング開始インデックスを返してくれる
			System.out.println("start: " + matcher.start());
			// マッチング終了インデックス（abcの次のインデックス）を返してくれる
			System.out.println("end: " + matcher.end());
			// マッチング中に見つかった文字のグループを返す
			System.out.println("group: " + matcher.group());
		}
	}

}
