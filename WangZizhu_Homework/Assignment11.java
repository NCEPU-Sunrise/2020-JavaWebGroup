package ʵ����;

//��������������,��������������������ǵ�ְ��:
//��������:����Ϣ��ֻ֪�����������͹���;
//������:��Ҫ��Ϣ����Ҫ�Է��Լ�Ŭ���Ĺ���;
//.����:��Ҫ��Ϣ������Ҫ����ֻ��Ҫ�Է���.

class Robot {
	
	public Robot(String name) {
		System.out.println(name);;
		// TODO Auto-generated constructor stub
	}
	public void rest() {
		System.out.println("����Ϣ");
	}
	public void intake() {
		System.out.println("��������");
	}
	public void work() {
		System.out.println("����");
	}
}
class Human {
	
	public Human(String name) {
		System.out.println(name);;
		// TODO Auto-generated constructor stub
	}
	public void rest() {
		System.out.println("��Ϣ");
	}
	public void intake() {
		System.out.println("�Է�");
	}
	public void work() {
		System.out.println("Ŭ������");
	}
}
class Pig {
	
	public Pig(String name) {
		System.out.println(name);;
		// TODO Auto-generated constructor stub
	}
	public void rest() {
		System.out.println("��Ϣ");
	}
	public void intake() {
		System.out.println("�Է�");
	}
	public void work() {
		System.out.println("���ù���");
	}
}
public class Assignment11 {
    public static void main(String[] args) {
		Robot robot = new Robot("������");
		robot.rest();
		robot.intake();
		robot.work();
		Human human = new Human("����");
		human.rest();
		human.intake();
		human.work();
		Pig pig = new Pig("��");
		pig.rest();
		pig.intake();
		pig.work();
	}
}
