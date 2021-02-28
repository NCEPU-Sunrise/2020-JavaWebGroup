package cn.itcast.demo;/*
 *
 *
 *
 */
import java.util.Scanner;

public class ifdemon4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("a=");

        int a = sc.nextInt();
        System.out.println("b=");

        int b = sc.nextInt();

        if(a > b){
            System.out.println("a比b大");
        }
        else
            System.out.println("b比a大");
    }
}
