public class Assignment17 {
    public static void main(String[] args) {
        Animal a = new Bird();
        a.eat();
        Bird b = (Bird) a ;
        b.eat();
        b.fly();
    }
}
interface A {
    public void fly();

}
class Animal {
    public void eat(){
        System.out.println("吃东西");
    }
}
class Bird extends Animal implements A {
    public  void fly(){
        System.out.println("鸟儿飞翔");
    }
    public void eat(){
        System.out.println("鸟儿吃虫");
    }
}

