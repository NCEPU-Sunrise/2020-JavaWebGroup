package T4;

import java.io.FileReader;
import java.util.Properties;
import java.util.Scanner;

public class ProrertiesT4 {
    public static void main(String[] args) throws Exception{
        String s1 ="",s2="";
        Scanner sc = new Scanner(System.in);
        while(!check(s1,s2)){
            System.out.println("输入正确的用户名与密码进行登陆：");
            System.out.println("输入用户名:");
            s1 = sc.nextLine();
            System.out.println("输入密码:");
            s2 = sc.nextLine();
        }
        System.out.println("登陆成功!");
    }

    public static boolean check(String user,String password) throws Exception{
        Properties prop = new Properties();

        FileReader fr = new FileReader("dataT4.txt");
        prop.load(fr);
        fr.close();

//        System.out.println(prop);

        if(user.equals(prop.getProperty("user")) && password.equals(prop.getProperty("password")))
            return true;
        return false;
    }
}
