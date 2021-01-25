import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class javahomework_1 {
    public static void main(String arg[]) throws ParseException {
        System.out.println("请输入日期：yyyy-mm-dd");
        Scanner sc=new Scanner(System.in);
        String data1=sc.next();
        String data2="2000-01-01";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");//格式化
        Date d1=sdf.parse(data1);
        Date d2=sdf.parse(data2);
        long datebetween=(d1.getTime()-d2.getTime())/(60*60*24*1000);
        long remainder=datebetween%7;
        int remain=(int)remainder;
        switch (remain) {
            case 0:
                System.out.println("星期六");
                break;
            case 1:
                System.out.println("星期日");
                break;
            case 2:
                System.out.println("星期一");
                break;
            case 3:
                System.out.println("星期二");
                break;
            case 4:
                System.out.println("星期三");
                break;
            case 5:
                System.out.println("星期四");
                break;
            case 6:
                System.out.println("星期五");
                break;
        }
    }

}
