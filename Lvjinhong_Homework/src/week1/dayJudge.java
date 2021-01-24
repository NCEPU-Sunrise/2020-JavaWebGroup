package week1;

public class dayJudge {

    //判断闰年
    private int leap(int year){
        if(year%400 == 0)return 366;
        if(year%100 != 0 && year%4 == 0)return 366;
        return 365;
    }

    //通过 月/日 计算天数
    private int dayCalcul(int year,int month,int day){
        int sum = 0;
        for(int i = 1;i < month;i++){
            if(i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12)sum+=31;
            else if(i == 4 || i == 6 || i == 9 || i == 11)sum+=30;
            else if(i == 2 && leap(year) == 366)sum+=29;
            else sum+=28;
        }
        sum += day;
        return sum-1;
    }

    //判断星期几
    public int dayJudge(int year, int month, int day){
        //已知2000.1.1是星期六

        //计算距离2000.1.1的天数
        int sum = 0;
        for(int i = 2000;i < year;i++){
            sum+=leap(i);
        }
        sum+=dayCalcul(year,month,day);

        sum = sum % 7;//0:星期六
        return sum;
    }
}
