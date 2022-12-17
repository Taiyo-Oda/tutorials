package com.bharath.training.java;

import java.util.Scanner;

public class StaticImport {
	
	public static void main(String[] args) {
		System.out.println("Enter two Scanner");
		
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		//1番目の引数を、2番目の引数で累乗した値を返す。
		double result1 = Math.pow(num1, num2);
		//double値の正しく丸めた正の平方根を返す。
		double result2 = Math.sqrt(36);
		System.out.println(result1);
		System.out.println(result2);
	}
}
