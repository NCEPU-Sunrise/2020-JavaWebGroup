//人类
class Person {
    private String name;//名字
    private int age;//年龄
    
    public void setName(String name) {
        this.name=name;
    }
    public void setAge(int age) {
        this.age=age;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
}
//学生类 学生 is a 人  , 学生继承人类
//学生类自动添加了name age 属性以及相关方法
class Student extends Person {
    //学生在人类基础上独有的属性和方法
    private String school;//学校
    
    public String getSchool() {
        return school;
    }
    public void setSchool(String school) {
        this.school =school;
    } 
}
//main
public class ExtendTest {
    public static void main(String arg[]){
        //创建学生对象
        Student student = new Student();
        //调用从父类继承下来的方法
        student.setName("John");
        student.setAge(18);
        //子类独有的方法
        student.setSchool("SCH");
        //输出student信息
        System.out.println(student.getName());//John
        System.out.println(student.getAge());//18
        System.out.println(student.getSchool());//SCH
    }
}