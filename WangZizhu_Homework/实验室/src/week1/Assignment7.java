package week1;

import java.util.Vector;

class Car {
	String ownerString;
	String brandString;
	String colorString;
	int flag=0;
	public Car(String ownerString, String brandString, String colorString) {
		this.brandString = brandString;
		this.colorString = colorString;
		this.ownerString = ownerString;
	}
	public void start() {
		if(flag==0) {
			System.out.println("启动");
		    flag=1;
		}
		else 
			System.out.println("已经启动，无需再次启动");
		
	}
	public void advance() {
		if(flag==1)
			System.out.println("前进");
		else {
			System.out.println("未启动");
		}
	}
	public void retreat() {
		if(flag==1)
			System.out.println("后退");
		else {
			System.out.println("未启动");
		}
	}
	public void stop() {
		if(flag==1)
			System.out.println("停止");
		else {
			System.out.println("未启动");
		}
	}
	public void flameout() {
		if(flag==1) {
			System.out.println("熄火");
			flag=0;
		}
		else {
			System.out.println("未启动");
		}
	}
	public String toString () {
		
		return "[车主："+this.ownerString+"，车辆品牌："+this.brandString+"，车辆颜色："+this.colorString+"]";
	}
}
public class Assignment7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<Car> vector = new Vector<Car>();
		Car car_1 = new Car("王明", "奥迪", "黑色");
		vector.add(car_1);
		Car car_2 = new Car("李明", "宝马", "白色");
		vector.add(car_2);
		Car car_3 = new Car("张明", "奔驰", "灰色");
		vector.add(car_3);
		for(int i=0;i<vector.size();i++) {
			System.out.println(vector.elementAt(i));
		}
		car_1.start();
		car_1.advance();
		car_1.stop();
		car_1.retreat();
		car_1.flameout();
		car_2.flameout();
		car_2.start();
		car_2.advance();
		car_2.stop();
		car_2.retreat();
		car_3.flameout();
		car_3.start();
		car_3.advance();
		car_3.stop();
		car_3.retreat();
		
	}

}
