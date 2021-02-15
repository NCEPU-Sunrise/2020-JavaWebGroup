import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Scanner;

public class Homework_4 {
    public static void main(String[] args) throws IOException {
        Properties prop=new Properties();
        OutputStream output=null;
        output=new FileOutputStream("E:\\config.properties");
        prop.setProperty("url","jdbc:mysql://localhost:3306/");
        prop.setProperty("username","root");
        prop.setProperty("password","root");
        prop.setProperty("database","users");
        prop.store(output,"注释");

        System.out.println("***用户登录系统***");
        System.out.println("输入用户名：");
        Scanner sc=new Scanner(System.in);
        String username=sc.next();
        System.out.println("输入密码：");
        String password=sc.next();
        if(password.equals(prop.getProperty(username))){
            System.out.println("登录成功！");
        }
        else
        {
            System.out.println("密码错误！");

        }


    }

}
