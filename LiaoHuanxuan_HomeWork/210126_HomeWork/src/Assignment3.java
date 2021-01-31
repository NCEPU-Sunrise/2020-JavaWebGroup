import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Xnhyacinth
 * @date 2021/1/31 - 16:04
 */
public class Assignment3 {
    public static void main(String[] args) {
        String per_phone = null;
        String per_phone_ = null;
        String phone = "aaa18073611917";
        Pattern p = Pattern.compile("1[3-9]\\d{9}");
        Matcher m = p.matcher(phone);
        while(m.find()) {
            System.out.println("现在的手机号是：" + m.group());
            per_phone = m.group();
        }
        boolean isPhone = per_phone.matches("1[3-9]\\d{9}");
        System.out.println("isPhone = " + isPhone);
        if(isPhone){
            per_phone_ = per_phone.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2");
            System.out.println("per_phone_ = " + per_phone_ );
        }
    }
}
