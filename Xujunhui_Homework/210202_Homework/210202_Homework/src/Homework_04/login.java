package Homework_04;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;
import java.util.Scanner;

public class login {
	
	static void mystore() throws IOException{
		Properties prop=new Properties();
		prop.setProperty("120001", "123456");
		prop.setProperty("120002", "456789");
		prop.setProperty("120003", "654321");
		FileWriter fw=new FileWriter("src/Homework_04/fw.txt");
		prop.store(fw, null);
		fw.close();
	}
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		boolean[] flag={true};
		mystore();
		System.out.println("请输入您的用户名与密码：");
		Properties prop=new Properties();
		Reader reader=new FileReader("src/Homework_04/fw.txt");
		prop.load(reader);
		while(flag[0]) {
			System.out.print("用户名：");
			String user=sc.nextLine();
			System.out.print("密码：");
			String pwd=sc.nextLine();
			prop.stringPropertyNames().forEach(e ->{
				if(e.equals(user)) {
					if(prop.get(e).equals(pwd)) {
						System.out.println("登录成功！");
						flag[0]=false;
					}else {
						flag[0]=true;
					}	
				}
			});
			if(flag[0])
				System.out.println("用户名或密码有误！请重新输入：");
		}
		System.out.println();
		sc.close();
	}
}
