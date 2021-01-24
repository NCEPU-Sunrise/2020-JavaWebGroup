import java.util.Scanner;

class getDate{
    int getWeek(int year,int month,int day){
        int sumdays = 0;
        for(int i = 1;i < year;i++){
            sumdays +=isLeap(i) ? 366:365;
        }
        for(int i = 1;i < month;i++){
            sumdays += getDays(year,month);
        }
        sumdays += day;
        return sumdays % 7;
    }
    boolean isLeap(int y){
        return (y % 4== 0 && y % 100 != 0 || y % 400 ==0) ? true : false;
    }
    int getDays(int y,int m){
        int days = 0;
        switch (m){
            case 1:
            case 10:
            case 3:
            case 5:
            case 8:
            case 7:
            case 12:
                days = 31; break;

            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;break;
            case 2:
                days = isLeap(y) ? 29:28;break;
            default:;
        }
        return days;
    }
    getDate(){}
}

public class WorkSpace {
    public static void main(String args[]){
        getDate gde = new getDate();
        int year,month,day,k;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年 月 日(用空格隔开)");
        year = sc.nextInt();
        month = sc.nextInt();
        day = sc.nextInt();
        //System.out.println(year+"  "+month+"  "+day);
        k=gde.getWeek(year,month,day);
        switch (k){
            case 0:System.out.println("该日期是星期天");break;
            case 1:System.out.println("该日期是星期一");break;
            case 2:System.out.println("该日期是星期二");break;
            case 3:System.out.println("该日期是星期三");break;
            case 4:System.out.println("该日期是星期四");break;
            case 5:System.out.println("该日期是星期五");break;
            case 6:System.out.println("该日期是星期六");break;
        }
    }
}
