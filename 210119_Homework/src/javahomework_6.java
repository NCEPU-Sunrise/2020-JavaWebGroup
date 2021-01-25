import java.sql.Statement;
import java.util.Scanner;

class Account{
    int money;
    String name;
    String password;
    Account(String name,String password){
        money=0;
        this.name=name;
        this.password=password;

    }

}
public class javahomework_6 {
    static int count=0;
    static Account account[]=new Account[1000];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("输入要选择的功能：");
            int num=sc.nextInt();
            switch (num){
                case 1:
                    System.out.println("用户名和密码：");
                    account[count]=new Account(sc.next(),sc.next());
                    count++;
                    break;
                case 2:
                    System.out.println("输入正确的用户名和密码");
                    String name=sc.next();
                    String password=sc.next();
                    int number=0;
                    for(int i=0;i<count;i++){
                        if(account[i].password.equals(password)&&account[i].name.equals(name)){
                            System.out.println("登陆成功！");
                            System.out.println("输入存钱金额：");
                            int money=sc.nextInt();
                            account[i].money+=money;
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("输入正确的用户名和密码");
                    String namestring=sc.next();
                    String passwordstring=sc.next();
                    int n=0;
                    for(int i=0;i<count;i++){
                        if(account[i].password.equals(passwordstring)&&account[i].name.equals(namestring)){
                            System.out.println("登陆成功！");
                            System.out.println("输入取钱金额：");
                            int money=sc.nextInt();
                            account[i].money-=money;
                            break;
                        }

                    }
                    break;

                case 4:
                    System.out.println("输入正确的用户名和密码");
                    String names=sc.next();
                    String passwords=sc.next();
                    for(int i=0;i<count;i++){
                        if(account[i].password.equals(passwords)&&account[i].name.equals(names)){
                            System.out.println("登陆成功！");
                            System.out.println(account[i].money);
                            break;
                        }

                    }
                    break;

            }
        }
    }
}
