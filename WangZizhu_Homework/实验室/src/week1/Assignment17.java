package week1;

interface A{
	abstract public void fly();
}
class Animal {
	public void eat() {
		System.out.println("�Զ���");
	}
}
class Bird extends Animal implements A{

	@Override
	public void fly() {
		// TODO Auto-generated method stub
			System.out.println("�������");
	}
	public void eat() {
		System.out.println("����Գ�");
	}
}
public class Assignment17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal b = new Bird();
		b.eat();
		if(b instanceof Animal){
			Bird a = (Bird)b;
			a.eat();
			a.fly();
		}
	}

}
