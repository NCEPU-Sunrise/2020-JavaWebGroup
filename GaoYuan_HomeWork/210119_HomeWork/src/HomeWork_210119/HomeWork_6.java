/* 构造一个银行账户类，并实现开户、存钱、取钱、查询余额的功能 */
package HomeWork_210119;
class Bank {

	private String name = null;
	private float money = 0;

	// 开户
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

	// 存钱
	float save(float money) {
		this.money += money;
		return money;
	}

	// 取钱
	float get(float money) {
		this.money -= money;
		return money;
	}

	public String check() { // 查询余额
		return "用户名：" + this.name + "  余额：" + this.money;
	}

}

public class HomeWork_6 {

	public static void main(String[] args) {
		Bank b = new Bank("张三", 60000);
		System.out.println("已成功存入" + b.save(1000) + "元");
		System.out.println("已成功取出" + b.get(500) + "元");
		System.err.println(b.check());
		
	}

}
