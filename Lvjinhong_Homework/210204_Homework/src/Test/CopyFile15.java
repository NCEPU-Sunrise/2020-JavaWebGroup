package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CopyFile15 {
    public static void in() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("请输入一个整数：");
        int integer = Integer.parseInt(br.readLine());
        System.out.println("您输入的整数是：" + integer);
        System.out.println();

        System.out.println("请输入一个小数");
        double decimal = Double.parseDouble(br.readLine());
        System.out.println("您输入的小数是：" + decimal);
        System.out.println();

        System.out.println("请输入一个字符串：");
        String line = br.readLine();
        System.out.println("您输入的字符串是：" + line);

        //释放资源
        br.close();
    }

    //上面方法虽然也能实现从控制台输入任意类型数据，但是比较麻烦，
    //需要我们自己将字符串解析成任意类型数据，也可能出现NumberFormatException异常，
    //所以一般我们不这样用。
    //JDK1.5给我们提供了Scanner，我们可以很方便地使用Scanner从控制台输入任意类型数据。

    public static void in2() throws IOException{
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入一个整数：");
        int integer = sc.nextInt();
        System.out.println("您输入的整数是：" + integer);
        System.out.println();

        System.out.print("请输入一个小数 ： " );
        double decimal = sc.nextDouble();
        System.out.println("您输入的小数是 ： " + decimal);
        System.out.println();

        System.out.print("请输入一个字符串：");
        sc.nextLine();
        String line = sc.nextLine();
        System.out.println("您输入的字符串是 ： " + line);
        System.out.println();

        // 释放资源
        sc.close();
    }

    public static void main(String[] args) throws IOException {
//        in();
        in2();
    }
}
