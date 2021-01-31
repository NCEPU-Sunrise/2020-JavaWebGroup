package T3;
import java.util.regex.*;

public class ReTest {
    public static void main(String[] args) {
        String content = "我的手机号是18837112195，曾经用过18888888888，还用过18812345678";

        String p1 = "\\d{11}";
        String p2 = "1(3|5|7|8|9)\\d{9}";

        Pattern pattern1 = Pattern.compile(p1);
        Matcher matcher1 = pattern1.matcher(content);
        if(matcher1.find()) System.out.println("现在的手机号是:" + matcher1.group());

        Pattern pattern2 = Pattern.compile(p2);
        Matcher matcher2 = pattern2.matcher(matcher1.group());
        if(matcher2.find()) System.out.println("该号码符合手机号格式.");


//        System.out.println(content.replaceFirst(matcher1.group(),));


    }
}
