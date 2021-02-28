package Homework_08;

import java.util.*;


public class Reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str= {"1","2","3","4","5","6","7","8","9","0"};
		List al=new ArrayList();
		for(int i=0;i<str.length;i++) {
			al.add(str[i]);
		}
		ListIterator liter = al.listIterator();
		System.out.println("反转前：");
		while(liter.hasNext())
			System.out.println(liter.next());
		Collections.reverse(al);
		liter = al.listIterator();
		System.out.println("反转后：");
		while (liter.hasNext())
			System.out.println(liter.next());
	}

}
