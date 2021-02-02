public class Person {
	/*成员变量*/
	private String name;  //具体程序编写时成员变量能够私有就私有,能够保护就不要公有(存放在堆内存，线程共享) 	
	private char sex = '男';//在定义成员变量是可以对其初始化，如果不对其初始化，Java默认地对其初始化。
	private int age;  
	
	Person(String name,char sex,int age){
		this(name,sex);
		this.age = age;
	}
	Person(String name,char sex){
		this(name);
		this.sex = sex;
	}
	Person(String name){
		this(name,sex,age);

	}
	Person(){}

	/*成员方法*/
	void setName(String name){
		this.name = name;
	}
	String getName(){
		return this.name;
	}
	void setSex(char sex){
		this.sex = sex;
	}
	char getSex(){
		return this.sex;
	}
	void setAge(int age){
		this.age = age;
	}
	int getAge(){
		return this.age;
	}
	
	String getInfo() {	
		String info;
		info = "姓名为"+name +" 年龄为"+age+" 性别为"+sex; //成员方法可以直接调用成员变量
		return info;
	}
	public static void main(String[] args){
		Person per = new Person("Lily",'女');
		System.out.println(per.getInfo());
		// System.out.println(per.getName());
	}
}