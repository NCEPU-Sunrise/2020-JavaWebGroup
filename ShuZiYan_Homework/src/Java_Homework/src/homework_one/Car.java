package homework_one;

public class Car {
    private String owner, brand, color;
    private boolean isActive ;
    void start(boolean isActive) {
        if (isActive) {
            System.out.println("汽车不能重复启动！");
            return;
        }
        System.out.println("汽车启动！");
    }
    void go(boolean isActive) {
    if (!isActive) {
            System.out.println("汽车未启动，不能前进/后退！");
            return;
        }
        System.out.println("汽车前进！");
        System.out.println("汽车后退！");
    }
    void stop(boolean isActive) {
        if (!isActive) {
            System.out.println("汽车未启动，不能熄火！");
            return;
        }
        System.out.println("汽车熄火！");
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

}

