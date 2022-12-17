package com.bharath.java.re;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

	public static void main(String[] args) {
		// Eメールアドレスのチェックを行う
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9_.-]+$");
		Matcher matcher = pattern.matcher("noda.0630@gmail.com");
		if (matcher.matches()) {
			System.out.println("valid email id");
		} else {
			System.out.println("invalid email");
		}
	}

}
