/* ����һ�������˻��࣬��ʵ�ֿ�������Ǯ��ȡǮ����ѯ���Ĺ��� */
package HomeWork_210119;
class Bank {

	private String name = null;
	private float money = 0;

	// ����
	public Bank() {
	}

	public Bank(String name) {
		this.name = name;
	}

	public Bank(String name, float money) {
		this(name);
		this.money = money;
	}

	public String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	public float getMoney() {
		return money;
	}

	void setMoney(float money) {
		this.money = money;
	}

	// ��Ǯ
	float save(float money) {
		this.money += money;
		return money;
	}

	// ȡǮ
	float get(float money) {
		this.money -= money;
		return money;
	}

	public String check() { // ��ѯ���
		return "�û�����" + this.name + "  ��" + this.money;
	}

}

public class HomeWork_6 {

	public static void main(String[] args) {
		Bank b = new Bank("����", 60000);
		System.out.println("�ѳɹ�����" + b.save(1000) + "Ԫ");
		System.out.println("�ѳɹ�ȡ��" + b.get(500) + "Ԫ");
		System.err.println(b.check());
		
	}

}
