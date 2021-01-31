import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Homework_5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String ID=sc.next();
        Calendar c=Calendar.getInstance();
        int nowyear=c.get(Calendar.YEAR);
        String r="350424200107182027";
        String yearstring=ID.substring(6,10);
        int year=Integer.valueOf(yearstring);
        System.out.println(nowyear-year);



    }
}
