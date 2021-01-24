import java.util.Scanner;

/**
 * @author Xnhyacinth
 * @date 2021/1/24 - 15:23
 */
public class Assignment1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("请输入给定日期，以空格相隔：");
        int year=sc.nextInt();
        int month=sc.nextInt();
        int day=sc.nextInt();

        int year0=2000;
        int month0=1;
        int day0=1;

        int monthday[][]={{0,31,28,31,30,31,30,31,31,30,31,30,31},
                {0,31,29,31,30,31,30,31,31,30,31,30,31}};
        String [] weekday={"六","日","一","二","三","四","五"};
        int days=0;
        if(year>year0)
        {
            for(int i=year0;i<year;i++)
            {
                if(leapYear(i)==1)
                {
                    days+=366;
                }
                else
                {
                    days+=365;
                }
            }
        }
        if(month>month0)
        {
            for(int j=month0;j<month;j++)
            {
                days+=monthday[leapYear(year)][j];
            }
        }
        days=days+day-day0;

//      System.out.println("和2000.1.1  星期六相差"+days+"天");
        System.out.println(year+"年"+month+"月"+day+"日 是 星期"+weekday[days%7]);
        sc.close();
    }

    public static int leapYear(int year) {
        int leap=0;
        if(year%4==0)
        {
            if(year%100==0)
            {
                if(year%400==0)
                {
                    leap=1;
                }
                else
                {
                    leap=0;
                }
            }
            else
            {
                leap=1;
            }
        }
        else
        {
            leap=0;
        }
        return leap;
    }
}

