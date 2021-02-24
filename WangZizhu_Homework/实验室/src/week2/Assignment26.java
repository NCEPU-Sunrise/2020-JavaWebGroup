package week2;

import java.lang.reflect.*;

class Student {
		private String name;
		private int age;

		public Student() {
		}

		public Student(String name,int age) {
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public void display() {
			System.out.println("学生信息： name=" + name + " age=" + age);
		}

		public void say(String str){
			System.out.println("学生说：" + str);
		}
}
public class Assignment26 {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException {
		// TODO Auto-generated method stub
		Class<Student> cls = Student.class; 
		System.out.println(cls.getName());
		Object stu1 = cls.getDeclaredConstructor().newInstance();
		Object stu2 = cls.getDeclaredConstructor(String.class, int.class).newInstance("小明", 12);
		for(int i=0;i<cls.getDeclaredFields().length;i++) {
			Field f = cls.getDeclaredFields()[i];
			f.setAccessible(true);
			if(i==0)
				f.set(stu1, "小敏");
			else {
				f.set(stu1, 15);
			}
			System.out.println(f);
		}
		System.out.println("---------------------------------");
		for(int i=0;i<cls.getMethods().length;i++) {
			System.out.println(cls.getMethods()[i]);
		}
		System.out.println("---------------------------------");
		Method m = cls.getMethod("display",null);
		m.invoke(stu2, null);
		System.out.println("---------------------------------");
		m.invoke(stu1, null);
		System.out.println("---------------------------------");
		Method n = cls.getMethod("say",String.class);
		n.invoke(stu1, "你好啊！");
		System.out.println("---------------------------------");
		Method o = cls.getDeclaredMethod("setName", String.class);
		o.invoke(stu2, "Bob");
		m.invoke(stu2, null);
	}

}
