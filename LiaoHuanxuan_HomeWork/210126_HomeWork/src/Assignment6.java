/**
 * @author Xnhyacinth
 * @date 2021/2/4 - 19:14
 */
public class Assignment6 {
    public static void main(String[] args) {

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


