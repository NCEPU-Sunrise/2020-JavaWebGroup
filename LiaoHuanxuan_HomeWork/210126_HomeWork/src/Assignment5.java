import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Xnhyacinth
 * @date 2021/2/6 - 19:12
 */
public class Assignment5 {
    public static void main(String[] args) {
        System.out.println("请输入形如name-ID（18位）的字符串：");
        Scanner sc = new Scanner(System.in);
        String info = sc.next();
        String[] s = info.split("-");
        StringBuffer sb = new StringBuffer("姓名：" + s[0] + ",");
        Pattern p = Pattern.compile("^(\\d{6})(\\d{4})(\\d{2})(\\d{2})(\\d{4})$");
        Matcher m = p.matcher(s[1]);
        String year0 = null;
        String month0 = null;
        String day0 = null;
        if (m.find()) {
            year0 = m.group(2);
            month0 = m.group(3);
            day0 = m.group(4);
        }
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, -(Integer.parseInt(year0)));
        if ((Integer.parseInt(month0) < c.get(Calendar.MONTH)))
            System.out.println("年龄：" + c.get(Calendar.YEAR));
        if ((Integer.parseInt(month0) > c.get(Calendar.MONTH)))
            System.out.println("年龄：" + (c.get(Calendar.YEAR) - 1));
        if ((Integer.parseInt(month0) == c.get(Calendar.MONTH))) {
            if ((Integer.parseInt(day0) <= c.get(Calendar.DAY_OF_MONTH)))
                System.out.println("年龄：" + c.get(Calendar.YEAR));
            else System.out.println("年龄：" + (c.get(Calendar.YEAR) - 1));
        }
    }
}
