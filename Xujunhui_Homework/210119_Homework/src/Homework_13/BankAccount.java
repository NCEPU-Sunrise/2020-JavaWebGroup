package Homework_13;
import java.text.SimpleDateFormat;
import java.util.*;
public class BankAccount {
	int bankAccountId;
	String Date;
	float Rest;
	static int sum=0;
	public BankAccount() {
		// TODO Auto-generated constructor stub
		BankAccount.sum++;
		this.Rest=0;
		Date date=new Date();
		SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
		Date=formatter.format(date);
		this.bankAccountId=1000+sum;
	}
	void Save() {
		float save;
		System.out.println("请输入所存入的金额：");
		Scanner sc=new Scanner(System.in);
		save=sc.nextFloat();
		this.Rest+=save;
		System.out.println("存储成功！");
	}
	void Draw() {
		float draw;
		System.out.println("请输入取款金额：");
		Scanner sc=new Scanner(System.in);
		for(draw=sc.nextFloat();draw>this.Rest;draw=sc.nextFloat()) 
			System.out.println("余额不足！,请重新输入取款金额");
		this.Rest-=draw;
	}
	String getInfo() {
		String str="户主:"+bankAccountId+"\n您的余额为："+this.Rest;
		return str;
	}
}
