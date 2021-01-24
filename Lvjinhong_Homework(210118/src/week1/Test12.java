package week1;

public class Test12 {
    public static void main(String[] args) {
        Employee e1 = new Employee(1000,1);
        Employee e2 = new Employee(1000,3);
        Manager m = new Manager(1000);

        e1.Add();e2.Add();m.Add();
        System.out.println(e1.info());
        System.out.println(e2.info());
        System.out.println(m.info());
    }
}
