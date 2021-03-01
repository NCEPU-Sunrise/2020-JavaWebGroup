/**
 * @author Xnhyacinth
 * @date 2021/3/1 - 21:05
 */
public class Assignment7 {
        public static void main(String[] args) {
            MyInvocationHandler demo = new MyInvocationHandler();
        }
}

interface Subject {
    public void say(String name, int age);
}

class RealSubject implements Subject {
    @Override
    public void say(String name, int age) {
        System.out.println(name + "今年已经" + age + "岁了。");
    }
}
class MyInvocationHandler implements Subject{
    public void say(String name, int age) {
        System.out.println(name + "今年已经" + age + "岁了。");
    }
}
