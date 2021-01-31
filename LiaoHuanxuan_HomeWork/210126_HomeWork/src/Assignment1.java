import java.util.Calendar;
import java.util.Scanner;

/**
 * @author Xnhyacinth
 * @date 2021/1/31 - 17:41
 */
public class Assignment1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年份:");
        int year = sc.nextInt();
        Calendar c = Calendar.getInstance();
        c.set(year, 2, 1);
        c.add(Calendar.DATE, -1);
        System.out.println(c.get(Calendar.DATE));
    }
}
