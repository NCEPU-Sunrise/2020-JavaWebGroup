package homework_one;

import java.util.Scanner;

public class homework5 {
    public static void main(String[] args) {
        Bank person = new Bank();
        Scanner sc = new Scanner(System.in) ;
        System.out.println("请输入户主名称：");
        person.setName(sc.next());
        System.out.println("请输入存钱金额：");
        int a = sc.nextInt();
        System.out.println("请输入取钱金额：");
        int b = sc.nextInt();
        int c = a - b ;
        person.setMoney(c);
        if (c >= 0)
            System.out.println("户主：" + person.getName()+","+"账户余额：" + c + "元");
        else
            System.out.println("户主：" + person.getName() + "," + "账户余额不足");
    }
}
