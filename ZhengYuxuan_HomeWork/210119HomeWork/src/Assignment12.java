public class Assignment12 {
    public static void main(String[] args) {
        Manager a = new Manager();
        Employee b = new Employee();
        Employee c = new Employee();
        a.add(5);
        b.add(6);
        c.add(2);
    }
}
class Person{
    int year;
    double money = 5000.00;

void add(int year){
    if(year<3)
        money = money + money*0.08;
    else
        money = money + money*0.1;
    System.out.println("工资为" + money);
}
}
class Employee extends Person {
    int year;
    double money = 5000.00;


    @Override
    void add(int year) {
        super.add(year);
    }
}
class Manager extends Employee{
    int year;
    double money = 5000.00;

    @Override
    void add(int year) {
        if(year<3)
            money = money + money*0.08;
        else
            money = money + money*0.2;
        System.out.println("工资为" + money);
    }
}