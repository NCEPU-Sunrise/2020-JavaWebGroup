package Homework_12;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e1=new Employee("小强",2,5000);
		Employee e2=new Employee("小红",4,5000);
		Manager m=new Manager("大强", 5, 8000);
		e1.Add();
		e2.Add();
		m.Add();
		System.out.println(e1.getInfo());
		System.out.println(e2.getInfo());
		System.out.println(m.getInfo());
	}

}
