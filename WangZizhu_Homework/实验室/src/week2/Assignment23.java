package week2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Assignment23 {
	public static void main(String[] args) {
		String s = "�ҵ��ֻ�����18837112195�������ù�18888888888�����ù�18812345678";
		String regex = "[\\d]{11}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		m.find(0);
		System.out.println(m.group());
	}
 


}
