package homework1;
import java.util.Scanner;
public class text1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入日期:");
        int y=sc.nextInt();
        int m=sc.nextInt();
        int d=sc.nextInt();
        int w=0;
        if(m==1||m==2){
                    m+=12;y--;//一月二月当成上年的13,14月算
                }
        w=(d+2*m+3*(m+1)/5+y+y/4-y/100+y/400+1)%7;
        System.out.println("星期"+w);
        sc.close();
    }
}
