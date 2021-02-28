package homework_one;

import java.util.Scanner;

public class homework7 {
    public static void main(String[] args) {
        Point a = new Point();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入X轴坐标");
        a.setX(sc.nextFloat());
        System.out.println("请输入Y轴坐标");
        a.setY(sc.nextFloat());
        System.out.println("请输入Z轴坐标");
        a.setZ(sc.nextFloat());
        double distant = Math.sqrt(a.getX() * a.getX() + a.getY() * a.getY() + a.getZ() * a.getZ()) ;
        System.out.println("三维坐标：（"+ a.getX()+","+ a.getY()+","+ a.getZ()+"）");
        System.out.println("与原点距离："+distant);
    }
}
