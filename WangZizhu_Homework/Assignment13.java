package ʵ����;
import java.util.*;

//���һ��BankAccount�࣬ʵ������ĳ�˺ŵ��ʽ�������Ŀ�����������˺š����롢ȡ���ȡ�BankAccount��������˺ţ�BankAccountId������������Date(����)��Rest(���)��Ҫ�����þ�̬����ʵ���˺ſ���ʱ�˺��Զ���š�
class BankAccount {
    float money = 0f;
    
	public BankAccount() {
		
	}
	public void open(String name) {
		Calendar calendar = Calendar.getInstance();
		System.out.println("�����ɹ��������ˣ�"+"С��"+"��  �˻���"+(int)((Math.random()*9+1)*100000));
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
public class Assignment13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount account1 = new BankAccount();
		System.out.println("�����ȴ���...");
		account1.open("С��");
		account1.save(100);
		account1.withdraw(36);
		System.out.print("��ѯ���:");
		account1.inquiry();
		BankAccount account2 = new BankAccount();
		System.out.println("�����ȴ���...");
		account2.open("С��");
		account2.save(500);
		account2.withdraw(182);
		System.out.print("��ѯ���:");
		account2.inquiry();
		
	}

}
