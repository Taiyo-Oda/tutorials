package com.taiyo.spring.springcore.properties;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"com/taiyo/spring/springcore/properties/config.xml");
		CountriesAndLangages cal = (CountriesAndLangages) context.getBean("countryAndLangs");
		System.out.println(cal);
	}

}
