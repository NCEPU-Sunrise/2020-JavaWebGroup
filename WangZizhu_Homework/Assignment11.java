package 实验室;

//描述以下三个类,并在主方法调用输出他们的职能:
//·机器人:不休息，只知道补充能量和工作;
//·人类:需要休息、需要吃饭以及努力的工作;
//.·猪:需要休息、不需要工作只需要吃饭。.

class Robot {
	
	public Robot(String name) {
		System.out.println(name);;
		// TODO Auto-generated constructor stub
	}
	public void rest() {
		System.out.println("不休息");
	}
	public void intake() {
		System.out.println("补充能量");
	}
	public void work() {
		System.out.println("工作");
	}
}
class Human {
	
	public Human(String name) {
		System.out.println(name);;
		// TODO Auto-generated constructor stub
	}
	public void rest() {
		System.out.println("休息");
	}
	public void intake() {
		System.out.println("吃饭");
	}
	public void work() {
		System.out.println("努力工作");
	}
}
class Pig {
	
	public Pig(String name) {
		System.out.println(name);;
		// TODO Auto-generated constructor stub
	}
	public void rest() {
		System.out.println("休息");
	}
	public void intake() {
		System.out.println("吃饭");
	}
	public void work() {
		System.out.println("不用工作");
	}
}
public class Assignment11 {
    public static void main(String[] args) {
		Robot robot = new Robot("机器人");
		robot.rest();
		robot.intake();
		robot.work();
		Human human = new Human("人类");
		human.rest();
		human.intake();
		human.work();
		Pig pig = new Pig("猪");
		pig.rest();
		pig.intake();
		pig.work();
	}
}
