package T7;

class RealSubject implements Subject{

    @Override
    public void say(String name, int age) {
        System.out.println(name + "今年已经" + age + "岁了。");
    }
}

public class InvocationTest {
    public static void main(String[] args) {

    }
}
