package week1;
//4x^-2 - 2x^3 + x^5 + 5x -8

import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Pattern;

public class Assignment20 {
	
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入一个多项式：");
			String a = sc.next();
			Vector<String> b = new Vector<String>();
			int i = 0;
			for(String c: a.split(" ")) {
				b.add(c);
			}
			Vector d = new Vector();
			int g = 1;
			int h = 1;
			for(String e : b) {
				if((Pattern.compile("[2-9]x\\^\\-[2-9]")).matcher(e).matches()) {
					for(String f: e.split("x\\^")) {
						if(i==1) {
							h*=Integer.parseInt(e)-1;
						}
						g*=Integer.parseInt(e);
						i++;
					}
					d.add(g+"x"+"^"+h);
				}
				else if(d.equals("-")||d.equals("+")) {
					
				}
				else if((Pattern.compile("[2-9]x\\^[2-9]")).matcher(e).matches()) {
					for(String f: e.split("x\\^")) {
						if(i==1) {
							h*=Integer.parseInt(e)-1;
						}
						g*=Integer.parseInt(e);
						i++;
					}
					d.add(g+"x"+"^"+h);
				}
				else if((Pattern.compile("x\\^[2-9]")).matcher(e).matches()) {
					for(String f: e.split("x\\^")) {
						if(i==1) {
							h*=Integer.parseInt(e)-1;
						}
						g*=Integer.parseInt(e);
						i++;
					}
					d.add(g+"x"+"^"+h);
				}
				else if((Pattern.compile("")).matcher(e).matches()) {
					
				}
				
			}
			
		}

	}

