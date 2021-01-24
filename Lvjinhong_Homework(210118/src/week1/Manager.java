//作业12:Person与Employee还有Manager
package week1;

public class Manager extends Person{

    public Manager(float salary){
        super(salary,"经理");
    }

    void Add() {
        super.Add(20);
    }

    String info(){
        return getPosition() + "-" + getSalary();
    }
}
