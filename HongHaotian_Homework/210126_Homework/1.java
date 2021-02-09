import java.util.Calendar;
import java.util.Scanner;
class Scratch {
    public static void main(String[] args) {
        int y=0;
        Scanner scan=new Scanner(System.in);
        if(scan.hasNextInt()) y=scan.nextInt();
        Calendar canl=Calendar.getInstance();
        canl.set(y,Calendar.MARCH,1);
        canl.add(Calendar.DATE,-1);
        System.out.println(canl.get(Calendar.DATE));
    }
}