package week2;

import java.util.Calendar;
import java.util.Scanner;

public class Assignment21 {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�����������ݣ�");
		int year = sc.nextInt();
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, 2);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.add(Calendar.DAY_OF_MONTH, -1);
		System.out.println(year+"��Ķ�����"+c.getTime().getDate()+"��");
		sc.close();
	}
}
