package Homework_7;

public class Car {
	String user,brand,color;
	boolean fire;
	Car(String user,String brand,String color){
		this.user=user;
		this.brand=brand;
		this.color=color;
		fire=false;
	}
	void Fire_On() {
		if(fire==true) 
			System.out.println("汽车已经启动，不可重复启动！");
		else {
			fire=true;
			System.out.println("汽车成功启动！");
		}
	}
	void Fire_Off() {
		fire=false;
		System.out.println("汽车成功熄火！");
	}
	void Forward() {
		if(fire==false)
			System.out.println("汽车处于熄火状态！");
		else
			System.out.println("前进！！！");
	}
	void Back() {
		if(fire==false)
			System.out.println("汽车处于熄火状态！");
		else
			System.out.println("后退！！！");
	}
	void Stop() {
		if(fire==false)
			System.out.println("汽车处于熄火状态！");
		else
			System.out.println("停止！！！");
	}
	String getInfo() {
		String str="车主："+user+"品牌："+brand+"颜色："+color;
		return str;
	}
}
