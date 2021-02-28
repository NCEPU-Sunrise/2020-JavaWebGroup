package HomeWork1;

/*已知2000.1.1是星期六，根据任意给定的日期（2000年以后的），请编程计算出该天是星期几。*/
import java.util.*;

public class Corr {

    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);

            System.out.println("请输入给定日期，以空格相隔：");
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();

            if (year < 2000) {
                System.out.println("请输入2000年以后的年份！");
            } else {
                int monthday[][] = { { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, // 平年每月天数
                        { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } }; // 闰年每月天数

                String[] weekday = { "六", "日", "一", "二", "三", "四", "五" };

                int days = 0;

                if (year > 2000) // “相差的年”，增加天数
                {
                    for (int i = 2000; i < year; i++) {
                        if (leapYear(i) == 1) {
                            days += 366;
                        } else
                            days += 365;

                    }

                }

                if (month > 1) // “相差的月”，增加天数
                {
                    for (int j = 1; j < month; j++) {
                        days += monthday[leapYear(year)][j]; // 根据输入年份是平年 或 闰年选择数组
                    }

                }
                days = days + day - 1; // “相差的日”，增加的天数
                System.out.println(year + "年" + month + "月" + day + "日 是 星期" + weekday[days % 7]);
                sc.close();
                break;
            } // else
        } // while
    }
    // 判断是否为闰年，若为闰年，返回1；若为平年，返回0
    public static int leapYear(int year) {
        if (year % 100 == 0 && year % 400 == 0)
            return 1;
        if (year % 100 != 0 && year % 4 == 0)
            return 1;
        return 0;
    }
}