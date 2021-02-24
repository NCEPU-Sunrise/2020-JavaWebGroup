package week3;

import java.util.Arrays;
import java.util.Scanner;

public class Assignment40 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a[] = new int[3];
		System.out.println("请输入三角形的第一个边：");
		a[0] = sc.nextInt();
		System.out.println("请输入三角形的第二个边：");
		a[1] = sc.nextInt();
		System.out.println("请输入三角形的第三个边：");
		a[2] = sc.nextInt();
		try {
			if(a[0]>0&&a[1]>0&&a[2]>0) {
				Arrays.sort(a);
				try {
					if(a[0]+a[1]>a[2]) {
						System.out.println("可以形成三角形！");
						System.out.println("该三角形周长为："+(a[0]+a[1]+a[2]));
						int p=(a[0]+a[1]+a[2])/2;
						double s=Math.sqrt(p*(p-a[0])*(p-a[1])*(p-a[2]));
						System.out.println("该三角形面积为："+s);
					}
					else {
						throw new IllegalArgumentException();
					}
				}catch (IllegalArgumentException e) {
					System.out.println("不能组成三角形！");
				}
			}
			else {
				throw new Exception();
			}
		}catch (Exception e) {
			System.out.println("三角形的边不能为0或负数！");
		}
		sc.close();
	}

}
