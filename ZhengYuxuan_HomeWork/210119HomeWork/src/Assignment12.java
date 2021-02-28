public class Assignment12 {
    Manager a = new Manager(5);
    Employee b = new Employee(6);
    Employee c = new Employee(2);
}
class Person{
    int year;
    double money;

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
    Employee(){

    }
    Employee(int year){
        this.year = year;
    }

    @Override
    void add(int year) {
        super.add(year);
    }
}
class Manager extends Employee{
    int year;
    double money = 5000.00;
    Manager(int year){
        super();
        this.year = year;
    }

    @Override
    void add(int year) {
        if(year<3)
            money = money + money*0.08;
        else
            money = money + money*0.2;
        System.out.println("工资为" + money);
    }
}