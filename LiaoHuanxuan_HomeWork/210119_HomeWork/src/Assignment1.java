import java.util.Scanner;

/**
 * @author Xnhyacinth
 * @date 2021/1/24 - 15:23
 */
public class Assignment1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入给定日期，以空格相隔：");
        int year = sc.nextInt();                  //输入的年
        int month = sc.nextInt();                 //输入的月
        int day = sc.nextInt();                   //输入的日

        int year0 = 2000;                         //初始年份
        int month0 = 1;                           //初始月份
        int day0 = 1;                             //初始日期

        int monthday[][] = {{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},  //平年每月天数
                {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}};           //闰年每月天数

        String[] weekday = {"六", "日", "一", "二", "三", "四", "五"};

        int days = 0;                             //输入和给定相差的天数

        if (year > year0)                          //“相差的年”，增加天数
        {
            for (int i = year0; i < year; i++) {
                if (leapYear(i) == 1) {
                    days += 366;
                } else {
                    days += 365;
                }
            }
        }

        if (month > month0)                        //“相差的月”，增加天数
        {
            for (int j = month0; j < month; j++) {
                days += monthday[leapYear(year)][j];//根据输入年份是平年 或 闰年选择数组
            }
        }

        days = days + day - day0;                     //“相差的日”，增加的天数

//      System.out.println("和2000.1.1  星期六相差"+days+"天");//输出输入和给定相差的天数
        System.out.println(year + "年" + month + "月" + day + "日 是 星期" + weekday[days % 7]);

        sc.close();
    }
    //若为闰年，返回1；若为平年，返回0
    public static int leapYear(int year) {
        int leap = 0;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    leap = 1;
                } else {
                    leap = 0;
                }
            } else {
                leap = 1;
            }
        } else {
            leap = 0;
        }
        return leap;
    }
}

