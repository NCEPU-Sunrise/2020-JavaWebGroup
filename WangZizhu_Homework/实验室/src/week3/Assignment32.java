package week3;

import java.io.*;
import java.util.*;

@SuppressWarnings("serial")
class Student_info implements Serializable{
	public String name;
	public String department;
	public int age;
	public float score;
	Student_info(String name, String department, int age, float score) {
		this.age = age;
		this.name = name;
		this.department = department;
		this.score = score;
	}
	public String toString() {
		return "[姓名："+name+"  院系："+department+"  年龄："+age+"  平均分数："+score+"]";
	}
}

public class Assignment32 {
	
	public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			char x = 'Y';
			File f = new File("Student_info.txt");
			FileOutputStream fo;
			ObjectOutputStream oo;
			FileInputStream fi;
			ObjectInputStream oi;
			int i= 0;
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入学生信息：");
			try {
				fo = new FileOutputStream(f);
				oo = new ObjectOutputStream(fo);
				while (x == 'Y') {
					System.out.print("请输入学生名字：");
					String name = sc.next();
					System.out.print("请输入学生院系：");
					String department = sc.next();
					System.out.print("请输入学生年龄：");
					int age = sc.nextInt();
					System.out.print("请输入学生平均成绩：");
					float score = sc.nextFloat();
					Student_info t = new Student_info(name, department, age, score);
					oo.writeObject(t);
					System.out.print("是否继续输入？（Y/N）");
					x = (char) System.in.read(); // ~
					i++;
				}
				oo.close();
				fo.close();
			}catch(Exception e) {
				System.out.println("程序出错！");
			}
			System.out.println("输出信息：");
			try {
				fi = new FileInputStream("Student_info.txt");
				oi = new ObjectInputStream(fi);
				while (i!=0) {
					System.out.println((Student_info)oi.readObject());
					i--;
				}
				oi.close();
				fi.close();
			}catch(Exception e) {
				System.out.println("程序出错！");
			}     
	        sc.close();   
		}
}
