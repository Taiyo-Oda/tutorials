package com.taiyo.spring.springcore.properties;

import java.util.Properties;

public class CountriesAndLangages {

	private Properties countryAndLangs;

	public Properties getCountryAndLangs() {
		return countryAndLangs;
	}

	public void setCountryAndLangs(Properties countryAndLangs) {
		this.countryAndLangs = countryAndLangs;
	}

	@Override
	public String toString() {
		return "CountriesAndLangages [countryAndLangs=" + countryAndLangs + "]";
	}

}
