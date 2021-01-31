package Homework_07;

import java.util.*;
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car=new Car("小强","奔驰", "黑色");
		boolean flag=true;
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("输入数字进行动作：\n1；启动；2：前进；3：后退；4：停止；5：熄火；6；退出；");
			while(flag) {	
				switch (sc.nextInt()){
				case 1 :{
					car.Fire_On();
					break;
				}
					
				case 2:{
					car.Forward();
					break;
				}
				case 3:{
					car.Back();
					break;
				}
				case 4:{
					car.Stop();
					break;
				}
				case 5:{
					car.Fire_Off();
					break;
				}
				case 6:
					flag=false;
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
