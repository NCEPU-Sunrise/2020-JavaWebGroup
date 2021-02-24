package week3;

import java.io.*;
import java.util.*;

class Info {
	public String name;
	public String department;
	public int age;
	public float score;
	Info() {
	}
}

public class Assignment33 {

		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			char x = 'Y';
			File f = new File("info.txt");
			FileOutputStream fo;
			DataOutputStream do_;
			FileInputStream fi;
			DataInputStream di;
			int i= 0;
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入学生信息：");
			try {
				fo = new FileOutputStream(f);
				do_ = new DataOutputStream(fo);
				while (x == 'Y') {
					Info t = new Info();
					System.out.print("请输入学生名字：");
					t.name = sc.next();
					System.out.print("请输入学生院系：");
					t.department = sc.next();
					System.out.print("请输入学生年龄：");
					t.age = sc.nextInt();
					System.out.print("请输入学生平均成绩：");
					t.score = sc.nextFloat();
					do_.writeUTF(t.name+","+t.department+","+t.age+","+t.score+"\n");
					System.out.print("是否继续输入？（Y/N）");
					x = (char) System.in.read(); // ~
					i++;
				}
				do_.close();
				fo.close();
			}catch(Exception e) {
				System.out.println("程序出错！");
			}
			System.out.println("输出信息：");
			try {
				fi = new FileInputStream("info.txt");
				di = new DataInputStream(fi);
				while (i!=0) {
					System.out.print(di.readUTF());
					i--;
				}
				di.close();
				fi.close();
			}catch(Exception e) {
				System.out.println("程序出错！");
			}     
	        sc.close();   
		}
}
