/*已知2000.1.1是星期六，根据任意给定的日期（2000年以后的），请编程计算出该天是星期几。*/
//考虑 是否闰年（闰年则2月为28填天），大小月
//1、在公历纪年法中，能被4整除的大多是闰年，除了能被100整除而不能被400整除的年份以外。
//
//2、普通年能被4整除，且不能被100整除的是闰年（如2004年是闰年，1900年不是闰年）。
//
//3、世纪年能被400整除的是闰年（如2000年是闰年，1900年不是闰年）。
package HomeWork1;
import java.util.Scanner;
public class Test1 {
    public static void main(String[] agrs){
        Scanner sc  = new Scanner(System.in);
        int year,month,day;
        System.out.println("请输入今天的年月日：");
        year = sc.nextInt();
        month = sc.nextInt();
        day = sc.nextInt();
        Just Jus  = new Just(year,month,day);
        int weekdays =1+ Jus.JustWeekDay();
        System.out.println("今天是星期"+weekdays);
    }
}
class Just{
    private int  year;
    private int  month;
    private int  day;
    public Just(int year,int month,int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }
    private int JustLeapYear(){
        if(((year%100)!=0)&&((year%4)==0)){
            return 1;
        }
        else if(((year%100)==0)&&((year%400)==0)){
            return 1;
        }
        else{
            return 0;
        }
    }
    private int JustMonth(){
        int days = switch (month){
            case 1,3,5,7,8,10,12 -> 31;
            case 4,6,9,11 -> 30;
            default -> 0;
        };
        if(JustLeapYear()==1){
            days = days+29;
        }
        else{
            days = days+28;
        }
        return days;
    }
    public int JustWeekDay()
    {
        int sumdays =0;
        for(int i =2020 ;i<year;i++)
        {
            if(JustLeapYear()==1) {
                sumdays = 366+sumdays;
            }
            else{
                sumdays = 365+sumdays;
            }
        }
        for(int i = 1;i<month-1;i++) {
            sumdays = sumdays+JustMonth();
        }
        int days = day -1;
        sumdays = sumdays+days;
        return  sumdays%7;
    }
}