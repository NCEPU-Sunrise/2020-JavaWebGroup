import java.awt.dnd.InvalidDnDOperationException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class NewTest {
    public static void main(String[] args) {
        Fruit apple=new Apple();
        Fruit orange=new Orange();
        InvocationHandler handler=new MynewInvocationHandler(apple);
        InvocationHandler handler1=new MynewInvocationHandler(orange);
        Fruit fruit=(Fruit) Proxy.newProxyInstance(handler.getClass().getClassLoader(), apple.getClass().getInterfaces(),handler);
        Fruit fruit1=(Fruit) Proxy.newProxyInstance(handler1.getClass().getClassLoader(), orange.getClass().getInterfaces(),handler1);
        fruit.eat();
        fruit1.eat();


        Vegetables carrot=new Carrot();
        Vegetables tomato=new Tomoto();
        InvocationHandler handler2=new MynewInvocationHandler(carrot);
        InvocationHandler handler3=new MynewInvocationHandler(tomato);
        Vegetables vegetables=(Vegetables) Proxy.newProxyInstance(handler2.getClass().getClassLoader(), carrot.getClass().getInterfaces(),handler2);
        Vegetables vegetables1=(Vegetables) Proxy.newProxyInstance(handler3.getClass().getClassLoader(),tomato.getClass().getInterfaces(),handler3);

        vegetables.make();
        vegetables1.make();
    }
}
interface Fruit {
    public abstract void eat();
}
class Apple implements Fruit{
    public void eat(){
        System.out.println("苹果被吃了！");

    }
}
class Orange implements Fruit{
    public void eat(){
        System.out.println("橙子被吃了！");
    }
}
interface Vegetables{
    public abstract void make();
}
class Carrot implements Vegetables{
    public void make(){
        System.out.println("胡萝卜做好啦！");
    }
}
class Tomoto implements Vegetables{
    public void make(){
        System.out.println("西红柿做好啦！");
    }
}
class MynewInvocationHandler implements InvocationHandler{
    Object target;
    MynewInvocationHandler(Object target){
        this.target=target;
    }
    public Object invoke(Object proxy, Method method,Object []args) throws InvocationTargetException, IllegalAccessException {
        Object obj=method.invoke(target,args);
        return obj;

    }
}
