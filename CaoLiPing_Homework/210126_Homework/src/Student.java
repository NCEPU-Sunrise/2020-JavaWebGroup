public class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name,int age) {
        this.name = name;
        this.age = age;
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

    public void say(String str){
        System.out.println("学生说：" + str);
    }
}
