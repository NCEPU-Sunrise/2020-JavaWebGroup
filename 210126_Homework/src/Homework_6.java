import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.*;
public class Homework_6 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        Student student=new Student();
        Class<Student> cls = (Class<Student>) student.getClass();
        System.out.println("完整类名"+cls.getName());

        Student stu1=new Student();
        Student stu2=new Student("clp",20);

        Class<?>cls1=Student.class;//获取指定类的对象
        Package pack=cls1.getPackage();//获取指定类的包定义
        System.out.println("包名称"+pack.getName());
        Constructor<?>constructor=cls1.getConstructor();//创建Constructor实例
        Student student1=(Student)constructor.newInstance();
        System.out.println("获取成员：");
        Field field[]=cls1.getDeclaredFields();
        for(Field f:field){
            System.out.println(f.getName());
            f.setAccessible(true);
        }

        System.out.println("9:设置name为Bob");
        field[0].set(student1,"Bob");//设置成员的属性
        field[1].set(student1,20);

        Object value1=field[0].get(student1);
        Object value2=field[1].get(student1);

        System.out.println(value1);
        System.out.println(value2);

        Class<?>cls2=Class.forName("Student");

        Method m1[]=cls2.getMethods();

        System.out.println("获取方法：");
        for(Method i :m1){
            System.out.println(i.toString());
        }

        Object obj2=cls2.getConstructor().newInstance();//实例化对象
        String getMethod="display";
        Method setMethod=cls2.getDeclaredMethod(getMethod);
        setMethod.setAccessible(true);
        setMethod.invoke(obj2);

        String getMethod2="say";
        Method setMethod2=cls2.getDeclaredMethod(getMethod2,String.class);
        setMethod2.setAccessible(true);
        setMethod2.invoke(obj2,"hello");




    }
}
