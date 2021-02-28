package Homework_10;

import java.util.Scanner;

public class triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float a,b,c,p;
		double S,C;

		Scanner sc=new Scanner(System.in);
		System.out.println("请输入三角形的三条边的长度：");
		a=sc.nextFloat();
		b=sc.nextFloat();
		c=sc.nextFloat();
		try {
			if(a+b<=c||a+c<=b||b+c<=a)
				throw new IllegalArgumentException();
			else {
				C=a+b+c;
				p=(a+b+c)/2;
				S=Math.sqrt(p*(p-a)*(p-b)*(p-c));
				System.out.println("周长为："+C+"  面积为:"+S);
			}
		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

}
