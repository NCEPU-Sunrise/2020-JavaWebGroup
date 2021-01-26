package 实验室;
import java.util.*;

//设计一个BankAccount类，实现银行某账号的资金往来账目管理，包括建账号、存入、取出等。BankAccount类包括，账号（BankAccountId）、开户日期Date(日期)，Rest(余额)。要求：利用静态变量实现账号开户时账号自动编号。
class BankAccount {
    float money = 0f;
    
	public BankAccount() {
		
	}
	public void open(String name) {
		Calendar calendar = Calendar.getInstance();
		System.out.println("开户成功！开户人："+"小明"+"，  账户："+(int)((Math.random()*9+1)*100000));
	}
	public void save(float money) {
		this.money+=money;
		System.out.println("存入："+money); 
		
	}
	public void withdraw(float money) {
		this.money-=money;
		System.out.println("取出："+money);
		
	}
	public void inquiry() {
		System.out.println(this.money);
	}
}
public class Assignment13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount account1 = new BankAccount();
		System.out.println("开户等待中...");
		account1.open("小明");
		account1.save(100);
		account1.withdraw(36);
		System.out.print("查询余额:");
		account1.inquiry();
		BankAccount account2 = new BankAccount();
		System.out.println("开户等待中...");
		account2.open("小红");
		account2.save(500);
		account2.withdraw(182);
		System.out.print("查询余额:");
		account2.inquiry();
		
	}

}
