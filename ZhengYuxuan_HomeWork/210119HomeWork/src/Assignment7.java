public class Assignment7 {
    public static void main(String[] args) {
        Car c = new Car("Stacy","黑色","辉腾");
        System.out.println(c);
        c.getcar();
        c.start();
        c.forward();
        c.backward();
        c.flameout();
        c.stop();
    }
}
class Car {
    String owner, color, brand;
    boolean isStart = false;

    Car(String owner, String color, String brand) { //构造函数
        this.owner = owner;
        this.color = color;
        this.brand = brand;
    }

    void start() {
        if (isStart == true) {
            System.out.println("汽车已在启动状态！");
            return;
        }
        isStart = true;
        System.out.println("汽车启动！");
    }

    void confirm() {
        if (isStart == false) {
            System.out.println("汽车未启动，不能前进！");
            return;
        }
    }

    void forward() {
        confirm();
        System.out.println("汽车前进！");
    }

    void backward() {
        confirm();
        System.out.println("汽车后退！");
    }

    void stop() {
        confirm();
        isStart = false;
        System.out.println("汽车停止！");
    }

    void flameout() {
        confirm();
        System.out.println("汽车熄火！");
    }

    void getcar() {
        System.out.println("车主：" + owner + " 颜色：" + color + " 品牌：" + brand);
    }
}