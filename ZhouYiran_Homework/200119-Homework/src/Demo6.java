import com.sun.org.apache.bcel.internal.generic.SWITCH;

import java.util.Scanner;

public class Demo6 {

    public static void main(String[] args) {
        Account account1 = new Account("周依然","123456789");
        account1.save(1000);
        account1.withdraw(500);
        account1.search();
        Account.open();

    }
}
class  Account{
    String name;
    String password;
    double balance = 0;
    Account(String name,String password){
        this.name = name;
        this.password = password;
    }
    public void save(double money){
        balance += money;
        System.out.println("存款成功！");
    }
    public void withdraw(double money){
        if(balance >= money) {
            balance -= money;
            System.out.println("取款成功!账户余额为" + balance + "元");
        }
        else
            System.out.println("余额不足！取款失败！");
    }
    public void search() {
        System.out.println("当前账户余额为" + balance + "元");
    }
    public static Account open() {
        Scanner sc;
        System.out.println("请输入姓名：");
        sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("请设置密码：");
        String password = sc.nextLine();
        System.out.println("开户成功！！");
        Account account = new Account(name,password);
        return account;
    }
}