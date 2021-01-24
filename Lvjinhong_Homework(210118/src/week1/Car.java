//作业7:汽车类设计
package week1;

import java.util.Scanner;

public class Car {
    String user;    //车主
    String brand;   //品牌
    String color;   //颜色

    public Car() {}

    public Car(String user,String brand,String color){
        this.user = user;
        this.brand = brand;
        this.color = color;
    }

    //启动
    public void start(){
        //启动后能执行的动作为:前进、后退、停止、熄火
        Scanner sc = new Scanner(System.in);
        System.out.println("汽车已启动.输入下一步指令:");
        String s = sc.nextLine();
        if(s.equals("前进"))moveForward();
        else if(s.equals("后退"))moveBack();
        else if(s.equals("停止"))stop();
        else if(s.equals("熄火"))flameOut();
        else System.out.println("指令无效，汽车已熄火.");
    }

    //前进
    public void moveForward(){
        //前进后能执行的动作为:后退、停止、熄火
        Scanner sc = new Scanner(System.in);
        System.out.println("汽车已前进.输入下一步指令:");
        String s = sc.nextLine();
        if(s.equals("后退"))moveBack();
        else if(s.equals("停止"))stop();
        else if(s.equals("熄火"))flameOut();
        else System.out.println("指令无效，汽车已熄火.");
    }

    //后退
    public void moveBack(){
        //后退后能执行的动作为:前进、停止、熄火
        Scanner sc = new Scanner(System.in);
        System.out.println("汽车已后退.输入下一步指令:");
        String s = sc.nextLine();
        if(s.equals("前进"))moveForward();
        else if(s.equals("停止"))stop();
        else if(s.equals("熄火"))flameOut();
        else System.out.println("指令无效，汽车已熄火.");
    }

    //停止
    public void stop(){
        //停止后能执行的动作为:前进、后退、熄火
        Scanner sc = new Scanner(System.in);
        System.out.println("汽车已停止.输入下一步指令:");
        String s = sc.nextLine();
        if(s.equals("前进"))moveForward();
        else if(s.equals("后退"))moveBack();
        else if(s.equals("熄火"))flameOut();
        else System.out.println("指令无效，汽车已熄火.");
    }

    //熄火
    public void flameOut(){
        //熄火后能执行的动作为:启动
        Scanner sc = new Scanner(System.in);
        System.out.println("汽车已熄火.输入下一步指令:");
        String s = sc.nextLine();
        if(s.equals("启动"))start();
        else System.out.println("指令无效，汽车已熄火.");
    }

    //打印出汽车对象的信息
    public void infoPrint(){
        String s = user + "-" + brand + "-" + color;
        System.out.println(s);
    }
}
