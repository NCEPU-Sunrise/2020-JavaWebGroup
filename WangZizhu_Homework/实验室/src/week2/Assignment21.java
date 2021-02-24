package week2;

import java.util.Calendar;
import java.util.Scanner;

public class Assignment21 {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请键入任意年份：");
		int year = sc.nextInt();
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, 2);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.add(Calendar.DAY_OF_MONTH, -1);
		System.out.println(year+"年的二月有"+c.getTime().getDate()+"天");
		sc.close();
	}
}
