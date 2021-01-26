package Homework_1;

import java.util.*;

public class calendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int monthbase[]= {31,28,31,30,31,30,31,31,30,31,30,31};
		int leapmonthbase[]= {31,29,31,30,31,30,31,31,30,31,30,31};
		String week[]= {"星期一","星期二","星期三","星期四","星期五","星期六","星期日"};
		int year,month,day;
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("请输入查询的年份：");
			year=sc.nextInt();
			System.out.println("请输入查询的月数：");
			for(month=sc.nextInt();month>12;month=sc.nextInt())
				System.out.println("月数输入有误，请重新输入：");
			System.out.println("请输入查询的日期：");
			if(year%100==0) {
				if(year%400==0) {
					for(day=sc.nextInt();day>leapmonthbase[month-1];day=sc.nextInt())
						System.out.println("日期输入有误，请重新输入：");
					System.out.println("该天是"+week[cal(leapmonthbase, year, month, day)-1]);
				}else {
					for(day=sc.nextInt();day>monthbase[month-1];day=sc.nextInt())
						System.out.println("日期输入有误，请重新输入：");
					System.out.println("该天是"+week[cal(monthbase, year, month, day)-1]);
				}
			}else {
				if(year%4==0) {
					for(day=sc.nextInt();day>leapmonthbase[month-1];day=sc.nextInt())
						System.out.println("日期输入有误，请重新输入：");
					System.out.println("该天是"+week[cal(leapmonthbase, year, month, day)-1]);
				}else {
					for(day=sc.nextInt();day>monthbase[month-1];day=sc.nextInt())
						System.out.println("日期输入有误，请重新输入：");
					System.out.println("该天是"+week[cal(monthbase, year, month, day)-1]);
				}
			}
			sc.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	static int cal(int[] monthbase,int year,int month,int day) {
		int sum=0;
		int week;
		int val_year=year-2000;
		int num_leap=(val_year+3)/4;
		sum+=365*val_year+num_leap;
		for(int i=0;i<month-1;i++) {
			sum+=monthbase[i];
		}
		sum+=day-1;
		week=(sum+6)%7;
		return week;
	}

}
