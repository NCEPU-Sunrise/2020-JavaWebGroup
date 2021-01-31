import java.util.Calendar;
import java.util.Scanner;

public class Homework_1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入年份：");
        int year=sc.nextInt();
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,2);
        c.set(Calendar.DAY_OF_MONTH,1);
        c.add(Calendar.DAY_OF_MONTH,-1);
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
    }
}
