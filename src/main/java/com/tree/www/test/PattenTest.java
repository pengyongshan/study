package com.tree.www.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PattenTest {

	public static void main(String[] args) {
		String str = "急急急18989487274,教大家13577778888, 哈哈10000222233";
		Matcher m = Pattern.compile("((18)|(13))\\d{9}").matcher(str);
		while (m.find()) {
			System.out.println(m.group());
		}

		String[] msgs = { "jajajja rehshaa sreajjas saaska", "renaak kaa sakaax cdkaks akda",
				"sajdja jasjda jsajasdkaaj" };
		Pattern p = Pattern.compile("re\\w*");
		Matcher matcher = null;
		for (int i = 0; i < msgs.length; i++) {
			if (matcher == null) {
				matcher = p.matcher(msgs[i]);
			} else {
				matcher.reset(msgs[i]);
			}
			System.out.println(matcher.replaceAll("哈哈:)"));
		}
	}
}
