package homework_two;

import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;
public class homework4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int  a=sc.nextInt();
        int  b=sc.nextInt();
        int  c=sc.nextInt();
        Test  ts=new Test();
        ts.triangle(a, b, c);
    }

}
