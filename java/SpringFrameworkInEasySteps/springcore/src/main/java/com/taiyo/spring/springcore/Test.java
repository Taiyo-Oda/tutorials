package com.taiyo.spring.springcore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// 新しい ClassPathXmlApplicationContext を作成し、与えられた XML ファイルから定義をロードし、自動的にコンテキストを更新
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		Employee emp = (Employee) ctx.getBean("emp");
		System.out.println("Employee ID : " + emp.getId());
		System.out.println("Employee Name : " + emp.getName());
	}
}
