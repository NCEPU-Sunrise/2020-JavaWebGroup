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
		return "["+"Ա����"+name+"�����䣺"+age+"���Ա�"+sex+"�����䣺"+workage+"��нˮ��"+salary+"]";
		
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
		return "["+"����"+name+"�����䣺"+age+"���Ա�"+sex+"�����䣺"+workage+"��нˮ��"+salary+"]";
		
	}
}
public class Assignment12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Manager m = new Manager("С��", 35, '��', 10, 5000);
		Employee e1 = new Employee("С��", 24, '��', 2, 2000);
		Employee e2 = new Employee("С��", 26, 'Ů', 4, 3000);
		m.add();
		e1.add();
		e2.add();
		System.out.println(m);
		System.out.println(e1);
		System.out.println(e2);
	}

}
