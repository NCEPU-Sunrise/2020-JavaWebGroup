/**
 * @author Xnhyacinth
 * @date 2021/3/1 - 20:47
 */
public class Assignment8 {
    public static void main(String[] args) throws Exception {
        Fruit f1 = Factory.getInstance("Apple");
        Fruit f2 = Factory.getInstance("Orange");
        Vegetables v1 = Factory.getInstance("Carrot");
        Vegetables v2 = Factory.getInstance("Tomato");
        f1.eat();
        f2.eat();
        v1.make();
        v2.make();
    }
}
interface Fruit {
    public abstract void eat();
}
class Apple implements Fruit{
    public void eat(){
        System.out.println("吃苹果");
    }
}
class Orange implements Fruit{
    public void eat(){
        System.out.println("吃橘子");
    }
}
interface Vegetables {
    public abstract void make();
}
class Carrot implements Vegetables{
    public void make(){
        System.out.println("做胡萝卜");
    }
}
class Tomato implements Vegetables{
    public void make(){
        System.out.println("做土豆");
    }
}
class Factory {
    private Factory() {}
    public static <T>T getInstance(String className) {
        T instance = null;
        try {
            instance = (T) Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }
}