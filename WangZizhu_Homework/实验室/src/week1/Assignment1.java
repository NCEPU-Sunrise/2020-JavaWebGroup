package week1;

//��֪2000.1.1��������������������������ڣ�2000���Ժ�ģ������̼�������������ڼ���
import java.util.*;

class Calculate {
	private static int year0=2000;                         
	private static int month0=1;                           
	private static int date0=1;
	private int flag1;                                        
	private int year;
	private int month;
	private int date;
	public int day=0; 
	
	public Calculate() {
		Scanner sc=new Scanner(System.in);
	    System.out.println("�������������ڣ�2000��1��1���Ժ�ģ����Կո������");
	    year=sc.nextInt();  
	    month=sc.nextInt();
	    date=sc.nextInt();  
	    if(month==2) {
	    	year(year, year0);
	    }
	    else {
	    	year(year, year0);
		}   
	    sc.close();
	}
	public int year(int year, int year0) {
		for(int i=year0;i<year;i++) {
			if(i%4==0 || i%400==0) {   //����
				day+=366;
			}
			else {   //ƽ��
				day+=365;
			}
		}
		if(year%4==0 || year%400==0) {   //����
			flag1=1;
			month(flag1,month);
		}
		else {   //ƽ��
			flag1=2;
			month(flag1,month);
		}
		
		return 1;
    }
	
	public int month(int flag1, int month) {
		for(int i=month0;i<month;i++) {
			if(i==1||i==3||i==5||i==7||i==8||i==10||i==12) {
				day+=31;
			}
			else if(i==2){
				if(flag1==1) {
					day+=29;
				}
				else if(flag1==2){
					day+=28;
				}
			}
			else {
				day+=30;
			}
		}
		date(date);
		return 0;
	}
	
	public int date(int month) {
		day+=date-date0;
		int weekday=day%7;
		switch(weekday) {
		case 0:System.out.println("������");return 1;
		case 1:System.out.println("������");return 1;
		case 2:System.out.println("����һ");return 1;
		case 3:System.out.println("���ڶ�");return 1;
		case 4:System.out.println("������");return 1;
		case 5:System.out.println("������");return 1;
		case 6:System.out.println("������");return 1;
		}
		return 0;		
	}
}
public class Assignment1 {
	public static void main(String[] args) {
		new Calculate();
	}
}