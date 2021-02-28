import java.util.Scanner;

public class Assignment6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        count a = new count();
        System.out.println("姓名：" + a.name);
        System.out.print("请输入账号:");
        int m = sc.nextInt();
        if (m == a.user) {
            System.out.print("请输入密码:");
            int n = sc.nextInt();
            {
            if (n == a.code) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                System.out.println("请选择您想办理的业务：1.存款 2.取款 3.查询余额");
                int aa = sc.nextInt();
                switch(aa) {
                    case 1:
                        a.in(x);
                        break;
                    case 2:
                        a.out(y);
                        break;
                    case 3:
                        a.check();
                        break;
                }
            } else
                System.out.println("密码错误");
        }
    }
        else
     System.out.println("账号错误");
}
    }
class count
        {
        int user = 30206;
        int code = 11111;
        String name = "Stacy" ;
        int balance = 10000;
public void in(int add){
        balance = balance + add;
        System.out.println("你存了"+add+"元");
        }
public void out(int out){
    if(balance >= out) {
        balance = balance - out;
        System.out.println("你取了" + out + "元");
    }
    else
        System.out.println("余额不足");
 }
public void check() {
    System.out.println("你现在的余额是"+balance);
 }
        }
