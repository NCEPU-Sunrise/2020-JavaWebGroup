package Homework_6;

import java.util.*;

public class Account {
	String user;
	float balance;
	Account(String user){
		this.user=user;
		this.balance=0;
		System.out.println("开户成功！ 户主："+user);
	}
	void Save() {
		float save;
		System.out.println("请输入所存入的金额：");
		Scanner sc=new Scanner(System.in);
		save=sc.nextFloat();
		this.balance+=save;
		System.out.println("存储成功！");
	}
	void Draw() {
		float draw;
		System.out.println("请输入取款金额：");
		Scanner sc=new Scanner(System.in);
		for(draw=sc.nextFloat();draw>this.balance;draw=sc.nextFloat()) 
			System.out.println("余额不足！,请重新输入取款金额");
		this.balance-=draw;
	}
	String getInfo() {
		String str="您的余额为："+this.balance;
		return str;
	}
}
