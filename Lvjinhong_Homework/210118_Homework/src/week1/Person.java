//作业12:Person与Employee还有Manager
package week1;

public class Person {
    private float salary;         //薪水
    private String position;    //职位

    //构造方法
    public Person(float salary,String position){
        this.salary = salary;
        this.position = position;
    }

    //get
    public float getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    //Add
    void Add(float percent){
        this.salary = this.salary * (1 + percent/100);
    }
}
