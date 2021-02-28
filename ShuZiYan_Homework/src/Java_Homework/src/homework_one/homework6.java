package homework_one;

import java.util.Scanner;

public class homework6 {
    public static void main(String[] x) {
        Scanner sc = new Scanner(System.in) ;
        Car a = new Car() ;
        System.out.println("请输入车主姓名：");
        a.setOwner(sc.next());
        System.out.println("请输入车辆名称：");
        a.setBrand(sc.next());
        System.out.println("请输入车辆颜色：");
        a.setColor(sc.next());
        System.out.println("请输入车辆是否启动(true/false)");
        a.setActive(sc.hasNext());
        System.out.print("车主："+a.getOwner()+","+"品牌："+a.getBrand()+","+"颜色："+a.getColor());
        System.out.println("");
        a.start(a.isActive());
        a.go(a.isActive());
        a.stop(a.isActive());
    }
}
