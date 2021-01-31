package T6;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class StudentTest {
    public static void main(String[] args) throws Exception{
        //1.创建Student类的Class对象
        Class stuc = Class.forName("T6.Student");

        //2.获取完整Student类名并输出
        System.out.println(stuc.getClass());

        //3.调用无参构造方法创建Student类的实例化对象stu1
        Constructor c1 = stuc.getDeclaredConstructor();
        Object stu1 = c1.newInstance();

        //4.调用有参构造方法创建Student类的实例化对象stu2
        Constructor c2 = stuc.getConstructor(String.class, int.class);
        Object stu2 = c2.newInstance("小明",18);

        //5.获取类的全部属性信息，并修改
        Field fields[] = stuc.getDeclaredFields();
        Field name = stuc.getDeclaredField("name");
        name.setAccessible(true);

        //6.获取全部方法信息
        Method methods[] =stuc.getDeclaredMethods();

        //7.调用类中无参方法display
        Method method1 = stu1.getClass().getDeclaredMethod("display");
        method1.invoke(stu1);

        //8.调用类中有参方法say
        Method method2 = stu1.getClass().getDeclaredMethod("say",String.class);
        method2.invoke(stu1,"C语言是世界上最好的语言!");

        //9.通过反射来操作属性，设置名字为Bob
        name.set(stu1,"Bob");


    }
}
