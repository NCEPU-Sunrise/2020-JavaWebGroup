/**
 * ����ĳ������Ϸ�У������漰�������ݣ�������Ʒ�ơ���ɫ���ܹ�����������ǰ�������ˡ�ֹͣ��Ϩ��ȶ����� ��Ҫ���������Ѿ��������Ͳ����ظ�������
 * ����������Ϩ��״̬������ִ�г������������������ ���⣬Ҫ�ܹ�ֱ�Ӵ�ӡ�������������Ϣ�� ��������������ƣ����и�������������Ϣ��ʾ���ɡ�
 */
class Car {

	String owner, brand, color;// ������Ʒ�ơ���ɫ
	boolean isActive = false; // ��������Ƿ�����,boolean��ֻ������ֵ��true��false

	Car(String o, String b, String c) {
		owner = o;
		brand = b;
		color = c;
	} // ���캯��

	void start() {
		if (isActive == true) {
			System.out.println("���������ظ�������");
			return;
		} // ���Ѿ��������ͽ���
		isActive = true;
		System.out.println("����������");
	}

	void go() {
		if (isActive == false) {
			System.out.println("����δ����������ǰ����");
			return;
		}
		System.out.println("����ǰ����");
	}

	void stop() {
		if (isActive == false) {
			System.out.println("����δ����������Ϩ��");
			return;
		}
		isActive = false;
		System.out.println("����Ϩ��");
	}

	public String toString() {// �˺����Ĺ��ܣ��ᱻSystem.out.print()�ڡ���ӡ����ʱ���Զ����ã�
		return " Ʒ�ƣ�" + brand + " ��ɫ��" + color;
	}
}

public class HomeWork_7 {
	public static void main(String[] x) {
		Car c = new Car("����", "����", "��ɫ");
		System.out.print(c);
		c.go();
		c.stop();
		c.start();
		c.stop();
	}
}
