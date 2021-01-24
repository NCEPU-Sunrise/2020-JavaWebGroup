//作业12:Person与Employee还有Manager
package week1;

public class Employee extends Person{
    private int year;           //工龄

    public Employee(float salary,int year){
        super(salary,"普通员工");
        this.year = year;

    }

    public int getYear() {
        return year;
    }

    public void Add() {
        if(year < 3)super.Add(8);
        else super.Add(10);
    }

    String info(){
        return getPosition() + "-" +getYear()+ "-" + getSalary();
    }
}
