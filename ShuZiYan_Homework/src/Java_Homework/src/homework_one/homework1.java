package homework_one;
import java.util.Scanner ;
public class homework1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int month , day , i , j , k ;
        System.out.println("请输入年");
        int year = in.nextInt() ;
        System.out.println("请输入月");
        month = in.nextInt() ;
        System.out.println("请输入日");
        day = in.nextInt() ;
        i = count_year(year);
        j = count_month(month , year);
        k = count_day(day , month);
        planA(i , j , k );
    }
    public static int count_year(int year)
    {
        int j , i , n=0 ;
        for(j=0,i=2000;i<year;i++)
        {   {if(i%4==0)
                j++;
            }
            n=year-2000;}
            i=365*n+j;
        return i;
    }

    public static int count_month(int month,int year)
    {
        int j = 0;
        switch(month)
        {  case 1:j=0;break;
            case 2:j=31;break;
            case 3:j=31+28;
                if(year%4==0)
                    j=31+29;break;
            case 4:j=31+28+31;
                if(year%4==0)
                    j=31+29+31;break;
            case 5:j=31+28+31+30;
                if(year%4==0)
                    j=31+29+31+30;break;
            case 6:j=31+28+31+30+31;
                if(year%4==0)
                    j=31+29+31+30+31;break;
            case 7:j=31+28+31+30+31+30;
                if(year%4==0)
                    j=31+29+31+30+31+30;break;
            case 8:j=31+28+31+30+31+30+31;
                if(year%4==0)
                    j=31+29+31+30+31+30+31;break;
            case 9:j=31+28+31+30+31+30+31+31;
                if(year%4==0)
                    j=31+29+31+30+31+30+31+31;break;
            case 10:j=31+28+31+30+31+30+31+31+30;
                if(year%4==0)
                    j=31+29+31+30+31+30+31+31+30;break;
            case 11:j=31+28+31+30+31+30+31+31+30+31;
                if(year%4==0)
                    j=31+29+31+30+31+30+31+31+30+31;break;
            case 12:j=31+28+31+30+31+30+31+31+30+31+30;
                if(year%4==0)
                    j=31+29+31+30+31+30+31+31+30+31+30;break;
        }
        return j ;
    }

    public static int count_day(int day,int month)
    {
        int k = 0;
        if(month==1)
            k=day-1;
        if(month!=1)
            k=day;
        return k;
    }

    public static void planA(int i,int j,int k)
    {
        int sum , n ;
        sum=i+j+k;
        n=sum%7;
        switch(n)
        {   case 0:
                System.out.println("星期6");break;
            case 1:
                System.out.println("星期7");break;
            case 2:
                System.out.println("星期1");break;
            case 3:
                System.out.println("星期2");break;
            case 4:
                System.out.println("星期3");break;
            case 5:
                System.out.println("星期4");break;
            case 6:
                System.out.println("星期5");break;
        }
    }
}
