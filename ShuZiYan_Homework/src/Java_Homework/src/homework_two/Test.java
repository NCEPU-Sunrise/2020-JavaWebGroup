package homework_two;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Test {
    void triangle(int a,int b,int c){
        try{
            if((a+b>c&&a-b<c)||(a+c>b&&a-c<b||b+c>a&&b-c<a)){
                System.out.println("能构成三角形");
            }
        }
        catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            System.out.println("不能构成三角形");
        }
    }
}
