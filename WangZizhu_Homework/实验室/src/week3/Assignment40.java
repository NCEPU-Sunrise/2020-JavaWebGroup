package week3;

import java.util.Arrays;
import java.util.Scanner;

public class Assignment40 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a[] = new int[3];
		System.out.println("�����������εĵ�һ���ߣ�");
		a[0] = sc.nextInt();
		System.out.println("�����������εĵڶ����ߣ�");
		a[1] = sc.nextInt();
		System.out.println("�����������εĵ������ߣ�");
		a[2] = sc.nextInt();
		try {
			if(a[0]>0&&a[1]>0&&a[2]>0) {
				Arrays.sort(a);
				try {
					if(a[0]+a[1]>a[2]) {
						System.out.println("�����γ������Σ�");
						System.out.println("���������ܳ�Ϊ��"+(a[0]+a[1]+a[2]));
						int p=(a[0]+a[1]+a[2])/2;
						double s=Math.sqrt(p*(p-a[0])*(p-a[1])*(p-a[2]));
						System.out.println("�����������Ϊ��"+s);
					}
					else {
						throw new IllegalArgumentException();
					}
				}catch (IllegalArgumentException e) {
					System.out.println("������������Σ�");
				}
			}
			else {
				throw new Exception();
			}
		}catch (Exception e) {
			System.out.println("�����εı߲���Ϊ0������");
		}
		sc.close();
	}

}
