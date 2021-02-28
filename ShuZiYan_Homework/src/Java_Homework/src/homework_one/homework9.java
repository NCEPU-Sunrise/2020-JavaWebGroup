package homework_one;

import java.util.Scanner;

public class homework9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        String regex = "[+]|i" ;
        System.out.println("请输入第一个复数：（格式：a + b i）[a,b为参数]");
        String num = sc.next() ;
        String[] pattern =num.split(regex);
        int a = Integer.parseInt(pattern[0]);
        int b = Integer.parseInt(pattern[1]);
        System.out.println("请输入第二个复数：（格式：a + b i）[a,b为参数]");
        num = sc.next() ;
        pattern =num.split(regex);
        int c = Integer.parseInt(pattern[0]);
        int d = Integer.parseInt(pattern[1]);
        System.out.println("结果："+(a+c) + "+" + (b+d) +"i");
    }
}
