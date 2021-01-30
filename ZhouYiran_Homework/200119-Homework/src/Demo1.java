import java.util.Scanner;

public class Demo1 {
    public static boolean isLeapyear(int year) {
        if (year % 4 == 0 && year % 100 == 0 || year % 400 == 0)
            return true;
        else
            return false;

    }

    public static void main(String[] args) {
        System.out.println("请输入日期，按年月日顺序输出");
        Scanner sc = new Scanner(System.in);
        int year0 = 2001;
        int month0 = 1;
        int day0 = 1;
        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();
        int gap = 0;
        int[][] mday = {{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}};
        String[] wday = {"六","日","一","二","三","四","五"};
        if (year0 < year) {
            for (int i = year0; i < year; i++) {
                if (isLeapyear(i) == false) {
                    gap = gap + 365;
                } else
                    gap += 366;
            }
            for (int i = month0; i < month; i++) {
                if (isLeapyear(year) == true) {
                    gap += mday[1][i - 1];
                } else
                    gap += mday[0][i - 1];

            }
            for (int i = day0; i < day; i++) {
                gap += 1;
            }
           int weekday = gap % 7;
            System.out.println(year + "." + month + "." +day + "是星期" + wday[weekday]);
        } else
            System.out.println("请输入2001.1.1之后的日期");

    }
}
