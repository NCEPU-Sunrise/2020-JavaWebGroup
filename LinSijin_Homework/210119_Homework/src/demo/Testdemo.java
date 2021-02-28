package cn.itcast.demo;/*
 *
 *
 *
 */

public class Testdemo {
    public static void main(String[] args) {
        phone p = new phone();


        p.brand = "苹果";
        p.model = "X";
        p.name = "乔布斯";

        System.out.println(p.brand);
        System.out.println(p.model);
        System.out.println(p.name);


        System.out.println("-----------");


        p.call("乔布斯");
        p.sendmassage();
        p.playgame();




    }
}
