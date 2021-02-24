package week1;

abstract class Role {
	protected String name;
	protected int age;
	protected char sex;
	
	public Role(String name, int age, char sex) {
		this.age=age;
		this.name=name;
		this.sex=sex;
	}
	public Role(String name, int age) {
		this(name, age, '��');
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param nameString the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the sex
	 */
	public char getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(char sex) {
		this.sex = sex;
	}
	
	abstract public void play();
	
}
class emp extends Role{
	protected static int ID;
	protected float salary;
	public emp(String name, int age, char sex, int ID, float salary) {
		super(name,age,sex);
		emp.ID=ID;
		this.salary=salary;
	}
	public emp(String name, int age, char sex, int ID) {
		this(name, age, sex, ID, 2000);
	}
	public emp(String name, int age, int ID, float salary) {
		super(name, age, '��');
		emp.ID=ID;
		this.salary=salary;
	}
	@Override
	public void play() {
		System.out.println(this.getName()+"��Ա��");
	}
	final void sing() {
		System.out.println(this.getName()+"�ᳪ�裡");
	}
}
class manag extends emp {
	private final String vehicle = "����";
	public manag(String name, int age, char sex, int ID, int salary) {
		super(name, age, sex, ID, salary);
	}
	public void drive() {
		System.out.println(this.getName()+"����"+vehicle);
	}
}
public class Assignment19 {
	public static void main(String[] args) {
		emp a = new emp("С��", 25, 'Ů', 100001, 3000); 
		a.play();
		emp b = new emp("С��", 28, 100002, 3000); 
		b.sing();
		manag c = new manag("С��", 30, '��', 100011, 10000);
		c.drive();
	}
}
