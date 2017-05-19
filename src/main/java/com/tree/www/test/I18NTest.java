package com.tree.www.test;

import java.util.Locale;

public class I18NTest {
	public static void main(String[] args) {
		Locale[] localList = Locale.getAvailableLocales();
		for (Locale locale : localList) {
			System.out.println(locale.getDisplayCountry() + "=" + locale.getCountry() + " "
					+ locale.getDisplayLanguage() + "=" + locale.getLanguage());
		}
	}
}
