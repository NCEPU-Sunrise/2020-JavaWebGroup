import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        MyInvocationHandler demo = new MyInvocationHandler();
        Subject sub = (Subject) demo.bind(new RealSubject());
        sub.say("Rollen",23);
    }
}
interface Subject {
    public void say(String name,int age);
}

class RealSubject implements Subject{

    @Override
    public void say(String name, int age) {
        System.out.println(name + "今年已经" + age + "岁了。");
    }
}
class MyInvocationHandler implements InvocationHandler{
    Object target;
    public Object bind(Object target){
        this.target=target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
    public Object invoke(Object proxy, Method method,Object[]args) throws InvocationTargetException, IllegalAccessException {

        Object obj=method.invoke(this.target,args);//每调用一个方法如say（），该方法的调用就会被转发到这个方法来调用
        return obj;

    }


}