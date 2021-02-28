import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Xnhyacinth
 * @date 2021/2/4 - 19:14
 */
public class Assignment6 {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Student.class;/*Class.forName("Student");*/
        System.out.println(cls.getName());
        Student stu1 = (Student) cls.getDeclaredConstructor().newInstance();
        Student stu2 = (Student) cls.getConstructor(String.class, int.class).newInstance("小强", 12);
        System.out.println(cls.getDeclaredMethods());
        System.out.println(cls.getDeclaredField("age"));
        Field f = cls.getDeclaredField("name");
        System.out.println(f);
        System.out.println(f.getName());
        System.out.println(f.getType());
        System.out.println(f.getModifiers());
        f.setAccessible(true);
        f.set((Object) stu1, "xuanxuan");
        System.out.println(f.get((Object) stu1));
        String setMethodName = "display";
        Method setMethod = cls.getDeclaredMethod(setMethodName);
        setMethod.invoke((Object) stu2);
        String getMethodName = "say";
        Method getMethod = cls.getDeclaredMethod(getMethodName, String.class);
        getMethod.invoke((Object) stu1, "你好");
        f.set((Object) stu2, "Bob");
        setMethod.invoke((Object) stu2);
    }
}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void display() {
        System.out.println("学生信息： name=" + name + " age=" + age);
    }

    public void say(String str) {
        System.out.println("学生说：" + str);
    }
}


