package Homework;

class Vehicle {
    String owner, brand, color;
    Vehicle(String O, String B, String C) {
        owner = O;
        brand = B;
        color = C;
    }

    boolean isStart;

    {
        isStart = false;
    }


    void Start() {
        if (true == isStart) {
            System.out.println("汽车已启动,不要重复启动!!!");
        } else {
            isStart = true;
            System.out.println("启动成功!!!");
        }
        return;
    }

    void Advance() {
        if (false == isStart) {
            System.out.println("还未启动,无法前进!!!");
            return;
        }
        System.out.println("汽车前进!!!");

    }

    void Retreat() {
        if (false == isStart) {
            System.out.println("未启动,无法后退!!!");
            return;
        }
        System.out.printf("汽车后退中!");
    }

    void Stop() {
        if (false == isStart) {
            System.out.println("未启动,不需熄火!!!");
            return;
        }
        System.out.println("熄火成功!!!");
    }
        public String toString () {
            return "车主:" + owner + "  品牌:" + brand + "  颜色:" + color;
    }
}

public class HomeWork_7 {
    public static void main(String[] args){
        Vehicle a=new Vehicle("天天","大众","金色");
        System.out.println(a);
        a.Start();
        a.Advance();
        a.Retreat();
        a.Stop();


    }
}
