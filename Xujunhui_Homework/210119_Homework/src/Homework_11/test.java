package Homework_11;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Robot r=new Robot();
		Human h=new Human();
		Pig p=new Pig();
		System.out.println(r.getInfo());
		System.out.println(h.getInfo());
		System.out.println(p.getInfo());
	}
}
class Robot {
		String name,function;
		public Robot() {
			// TODO Auto-generated constructor stub
			name="机器人";
			function="不休息，只知道补充能量和工作";
		}
		String getInfo() {
			String str=name+":"+function;
			return str;
		}
	}
	class Human {
		String name,function;
		public Human() {
			// TODO Auto-generated constructor stub
			name="人类";
			function="需要休息、需要吃饭以及努力的工作";
		}
		String getInfo() {
			String str=name+":"+function;
			return str;
		}
	}
	class Pig {
		String name,function;
		Pig(){
			name="猪";
			function="需要休息、不需要工作只需要吃饭";
		}
		String getInfo() {
			String str=name+":"+function;
			return str;
		}
	}