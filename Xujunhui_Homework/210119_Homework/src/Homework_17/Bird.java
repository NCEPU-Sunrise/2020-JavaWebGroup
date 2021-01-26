package Homework_17;

public class Bird extends Animal implements A{
	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("鸟儿飞翔");
	}
	void eat() {
		System.out.println("鸟儿 吃虫");
	}
}
