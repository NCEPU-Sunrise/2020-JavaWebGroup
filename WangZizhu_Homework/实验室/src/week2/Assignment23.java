package week2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Assignment23 {
	public static void main(String[] args) {
		String s = "我的手机号是18837112195，曾经用过18888888888，还用过18812345678";
		String regex = "[\\d]{11}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		m.find(0);
		System.out.println(m.group());
	}
 


}
