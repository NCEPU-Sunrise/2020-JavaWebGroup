package week1;

class Person {
	protected String name;
	protected int age;
	protected char sex;
	public Person(String name, int age, char sex) {
		this.age=age;
		this.name=name;
		this.sex=sex;
	}
	
}
class Employee extends Person {
	protected double salary;
	protected int workage;
	public Employee(String name, int age, char sex, int workage, double salary) {
		super(name, age, sex);
		this.workage=workage;
		this.salary=salary;
	}
	public void add() {
		if(workage<3) {
			salary=salary*(1+0.08);
		}
		else if(workage>=3) {
			salary=salary*(1+0.1);
		}
	}
	public String toString() {
		return "["+"员工："+name+"，年龄："+age+"，性别："+sex+"，工龄："+workage+"，薪水："+salary+"]";
		
	}
}
class Manager extends Employee {

	public Manager(String name, int age, char sex, int workage, double salary) {
		super(name, age, sex, workage, salary);
	}
	public void add() {
		salary=salary*(1+0.2);
	}
	public String toString() {
		return "["+"经理："+name+"，年龄："+age+"，性别："+sex+"，工龄："+workage+"，薪水："+salary+"]";
		
	}
}
public class Assignment12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Manager m = new Manager("小明", 35, '男', 10, 5000);
		Employee e1 = new Employee("小张", 24, '男', 2, 2000);
		Employee e2 = new Employee("小王", 26, '女', 4, 3000);
		m.add();
		e1.add();
		e2.add();
		System.out.println(m);
		System.out.println(e1);
		System.out.println(e2);
	}

}
