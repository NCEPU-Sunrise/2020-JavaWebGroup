package T1;
import java.util.Calendar;
import java.util.Scanner;
//import java.util.Calendar;

public class CalendarTest {
    public static void main(String[] args) throws Exception {
        //输入年份
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年份：");
        int year = sc.nextInt();

        //设置日历对象的年月日
        Calendar c = Calendar.getInstance();
        c.set(year,2,1);
        c.add(Calendar.DATE,-1);
        System.out.println(c.get(Calendar.DATE));
    }
}
