package ʵ����;

//����һ�������˻��࣬��ʵ�ֿ�������Ǯ��ȡǮ����ѯ���Ĺ���
import java.util.Random;

class Account {
    float money = 0f;
    
	public Account() {
		
	}
	public void open(String name) {
		Random dRandom = new Random();
		System.out.println("�����ɹ���"+'\n'+"�����ˣ�"+name+",  id��"+(dRandom.nextInt()*9+1)*10000);
	}
	public void save(float money) {
		this.money+=money;
		System.out.println("���룺"+money); 
		
	}
	public void withdraw(float money) {
		this.money-=money;
		System.out.println("ȡ����"+money);
		
	}
	public void inquiry() {
		System.out.println(this.money);
	}
}
public class Assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account1 = new Account();
		System.out.println("�����ȴ���...");
		account1.open("С��");
		account1.save(100);
		account1.withdraw(36);
		System.out.print("��ѯ���:");
		account1.inquiry();
	}

}
