package TestCaoGao;

public class Person {
    private String name;
    private int age;

    public String a;
    protected String b;
    String c;
    private String d;

    public Person() {}

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void eat(){
        System.out.println("eat...");
    }
}
