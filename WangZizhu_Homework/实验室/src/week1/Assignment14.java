package week1;

import java.math.BigDecimal;
import java.util.Scanner;

abstract class Tool{
	public static double PI=Math.PI;
	public static double ballArea(int r) {
		double a = 4.0*PI*r*r;
		@SuppressWarnings("deprecation")
		double result = new BigDecimal(a).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return result;
	}
	public static double ballBulk(int r) {
		double v = 4.0/3*PI*r*r*r;
		@SuppressWarnings("deprecation")
		double result = new BigDecimal(v).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return result;
	}
	public static double columnArea(int r, int h) {
		double a = 2.0*PI*r*h+2.0*PI*r*r;
		@SuppressWarnings("deprecation")
		double result = new BigDecimal(a).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return result;
	}
	public static double columnBulk(int r, int h) {
		double v = PI*r*r*h;
		@SuppressWarnings("deprecation")
		double result = new BigDecimal(v).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return result;
	}
	public static double coneArea(int r, int h) {
		double a = h*PI*r+PI*r*r;
		@SuppressWarnings("deprecation")
		double result = new BigDecimal(a).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return result;
	}
	public static double coneBulk(int r, int h) {
		double v = 1/3*PI*r*r*h;
		@SuppressWarnings("deprecation")
		double result = new BigDecimal(v).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return result;
	}
}
class Test {
	
}
public class Assignment14 {

	public static void testTool() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("��������Ҫ���Ե�ѡ�1.����\n2.Բ��\n3.Բ׶");
		int n = scanner.nextInt();
		switch(n) {
		case 1:
		{
			while(true) {
				int r = (int)(Math.random()*10);
				System.out.print("���ʵ�һ����İ뾶Ϊ��"+r+"ʱ�����ı�����Ƕ��٣�");
				double r_area = scanner.nextDouble();
				System.out.print("��������Ƕ��٣�");
				double r_bulk = scanner.nextDouble();
				double area = Tool.ballArea(r);
				System.out.println(area);
				double bulk = Tool.ballBulk(r);
				System.out.println(bulk);
				if(r_area==area&&r_bulk==bulk) {
					System.out.println("������ȷ��");
					break;
				}
				else {
					System.out.println("��������������¼���һ�飡");
				}
			}
		}
		case 2:
		{
			while(true) {
				int r = (int)(Math.random()*10);
				int h = (int)(Math.random()*10);
				System.out.print("���ʵ�һ��Բ���İ뾶Ϊ��"+r+",Բ���ĸߣ�"+h+"ʱ�����ı�����Ƕ��٣�");
				double r_area = scanner.nextDouble();
				System.out.print("��������Ƕ��٣�");
				double r_bulk = scanner.nextDouble();
				double area = Tool.columnArea(r, h);
				double bulk = Tool.columnBulk(r, h);
				if(r_area==area&&r_bulk==bulk) {
					System.out.println("������ȷ��");
					break;
				}
				else {
					System.out.println("��������������¼���һ�飡");
				}
			}

		}
		case 3:
		{
			while(true) {
				int r = (int)(Math.random()*10);
				int h = (int)(Math.random()*10);
				System.out.print("���ʵ�һ��Բ׶�İ뾶Ϊ��"+r+",Բ׶�ĸߣ�"+h+"ʱ�����ı�����Ƕ��٣�");
				double r_area = scanner.nextDouble();
				System.out.print("��������Ƕ��٣�");
				double r_bulk = scanner.nextDouble();
				double area = Tool.coneArea(r, h);
				double bulk = Tool.coneBulk(r, h);
				if(r_area==area&&r_bulk==bulk) {
					System.out.println("������ȷ��");
					break;
				}
				else {
					System.out.println("��������������¼���һ�飡");
				}
			}

		}
		
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] bulk = new double[3];
		double[] area = new double[3];
		double areaSum = 0;
		double bulkSum = 0;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("�����һ����뾶��");
		int b_r = scanner.nextInt();
		area[0] = Tool.ballArea(b_r);
		bulk[0] = Tool.ballBulk(b_r);
		System.out.println("����ı������"+area[0]+"������������"+bulk[0]);
		System.out.print("�����һ��Բ���İ뾶�͸ߣ�");
		int col_r = scanner.nextInt();
		int col_h = scanner.nextInt();
		area[1] = Tool.columnArea(col_r, col_h);
		bulk[1] = Tool.columnBulk(col_r, col_h);
		System.out.println("Բ���ı������"+area[1]+"��Բ���������"+bulk[1]);
        System.out.print("�����һ��Բ׶�İ뾶�͸ߣ�");
        int con_r = scanner.nextInt();
		int con_h = scanner.nextInt();
		area[2] = Tool.coneArea(con_r, con_h);
		bulk[2] = Tool.coneBulk(con_r, con_h);
		System.out.println("Բ׶�ı������"+area[2]+"��Բ׶�������"+bulk[2]);
		for(int i=0;i<3;i++) {
			areaSum+=area[i];
			bulkSum+=bulk[i];
		}
		System.out.println("Բ���壬Բ׶�壬�����������ܺͣ�"+areaSum);
		System.out.println("Բ���壬Բ׶�壬����������ܺͣ�"+bulkSum);
		System.out.println("------���ڽ���С����------");
		testTool();
	}

}
