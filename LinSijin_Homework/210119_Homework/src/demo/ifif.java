package cn.itcast.demo;/*
 *
 *
 *
 */

//1.导包
import java.util.Random;
import java.util.Scanner;

public class ifif {
    public static void main(String[] args) {


        //创建键盘录入对象
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int num = r.nextInt(100)+1;


        while(true) {
            System.out.println("请猜一个数字：");
            int gussesnum = sc.nextInt();
            if (gussesnum > num) {
                System.out.println("猜大了");

            } else if (gussesnum < num) {
                System.out.println("猜小了");

            } else {
                System.out.println("猜对了");
                break;
            }
        }


    }
    }




