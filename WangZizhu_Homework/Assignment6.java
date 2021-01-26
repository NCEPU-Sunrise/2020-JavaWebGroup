package 实验室;

//构造一个银行账户类，并实现开户、存钱、取钱、查询余额的功能
import java.util.Random;

class Account {
    float money = 0f;
    
	public Account() {
		
	}
	public void open(String name) {
		Random dRandom = new Random();
		System.out.println("开户成功！"+'\n'+"开户人："+name+",  id："+(dRandom.nextInt()*9+1)*10000);
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
public class Assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account1 = new Account();
		System.out.println("开户等待中...");
		account1.open("小明");
		account1.save(100);
		account1.withdraw(36);
		System.out.print("查询余额:");
		account1.inquiry();
	}

}
