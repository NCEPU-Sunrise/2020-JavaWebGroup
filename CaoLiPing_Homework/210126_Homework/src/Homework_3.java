import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Homework_3 {
    public static void main(String[] args) {
        System.out.println("请输入:");
        Scanner sc=new Scanner(System.in);
        String phone=sc.next();
        String forstring="我的手机号是`([\\d]+)`，曾经用过`([\\d]+)`，还用过`([\\d]+)`";
        Pattern r=Pattern.compile(forstring);
        Matcher m=r.matcher(phone);
        String gettelephone=null;
        if(m.find()){
            gettelephone=m.group(1);
        }

        String telephone="^(1[3|4|5|7|8|9])\\d{9}$";
        Boolean b=Pattern.matches(telephone,gettelephone);

        if(b==true){

            String getfour=gettelephone.substring(3,7);
            String newtele=gettelephone.replaceAll(getfour,"****");
            String newstring=phone.replaceAll(gettelephone,newtele);
            System.out.println(newstring);

        }
        else{
            System.out.println("手机号不符合！");
        }


    }
}
