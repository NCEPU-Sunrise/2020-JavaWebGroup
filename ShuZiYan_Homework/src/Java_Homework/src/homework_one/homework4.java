package homework_one;

import java.util.Scanner;

public class homework4 {
    public static void main(String[] args) {
        Address place = new Address() ;
        Scanner sc = new Scanner(System.in) ;
        String name ;
        System.out.println("请输入国家名称：");
        name = sc.next();
        place.setCountry(name);
        System.out.println("请输入省份名称：");
        name = sc.next();
        place.setProvince(name);
        System.out.println("请输入城市名称：");
        name = sc.next();
        place.setCity(name);
        System.out.println("请输入街道名称：");
        name = sc.next();
        place.setStreet(name);
        System.out.println("请输入邮编：");
        name = sc.next();
        place.setNumber(name);
        System.out.println(place.getCountry()+"，"+place.getProvince()+"省"+place.getCity()+"市"+place.getStreet()+","+"邮编："+place.getNumber());
    }
}
