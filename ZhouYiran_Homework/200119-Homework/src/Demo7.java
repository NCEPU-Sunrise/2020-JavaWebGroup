 class Demo7 {
     public static void main(String[] args) {
         Car car1 = new Car("周依然","兰博基尼","蓝色");
         car1.start();
         car1.forward();
         car1.backward();
         car1.start();
         car1.stop();
         car1.close();
         car1.forward();
     }

}


class Car {
    String owner;
    String brand;
    String color;
    boolean is_start = false;
    boolean is_close = false;
    Car(String owner, String brand, String color) {
        this.owner = owner;
        this.brand = brand;
        this.color = color;
        System.out.println("车主：" + owner + "  品牌：" + brand + "  颜色" + color);
    }

    public void start() {
        if (this.is_start == false) {
            System.out.println("启动ing...");
            this.is_start = true;
        }
        else
            System.out.println("汽车已启动，请不要重复启动！！");
    }
    public void close(){
        System.out.println("熄火ing...");
        this.is_close = true;
        this.is_start = false;
    }
    public void forward() {
        if(this.is_close == false){
            System.out.println("前进ing...");
        }
        else
            System.out.println("汽车已熄火！");
    }
    public void backward(){
        if(this.is_close == false){
            System.out.println("后退ing...");
        }
        else
            System.out.println("汽车已熄火！");
    }
    public void stop(){
        if(this.is_close == false){
            System.out.println("停止ing...");
        }
        else
            System.out.println("汽车已熄火！");
    }
}