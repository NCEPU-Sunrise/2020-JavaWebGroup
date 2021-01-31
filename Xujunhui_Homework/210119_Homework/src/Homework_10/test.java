package Homework_10;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("分别输入复数的实部和虚部：");
		plural p=new plural(sc.nextDouble(),sc.nextDouble());
		p.print();
		int flag=1;
		while(flag==1) {
			System.out.println("输入想要进行运算的序号：\n1.加法\n2.减法\n3.乘法\n4.除法\n5.退出");
			switch (sc.nextInt()) {
			case 1:{
				System.out.println("分别输入复数的实部和虚部：");
				p.add(sc.nextDouble(),sc.nextDouble());
				break;
			}
			case 2:{
				System.out.println("分别输入复数的实部和虚部：");
				p.sub(sc.nextDouble(),sc.nextDouble());
				break;
			}
			case 3:{
				System.out.println("分别输入复数的实部和虚部：");
				p.mul(sc.nextDouble(),sc.nextDouble());
				break;
			}
			case 4:{
				System.out.println("分别输入复数的实部和虚部：");
				p.div(sc.nextDouble(),sc.nextDouble());
				break;
			}
			case 5:{
				flag=0;
				break;
			}
			}
			p.print();
		}
	}

}
