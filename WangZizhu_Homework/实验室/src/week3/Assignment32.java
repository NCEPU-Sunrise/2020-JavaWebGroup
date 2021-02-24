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
		return "[������"+name+"  Ժϵ��"+department+"  ���䣺"+age+"  ƽ��������"+score+"]";
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
			System.out.println("������ѧ����Ϣ��");
			try {
				fo = new FileOutputStream(f);
				oo = new ObjectOutputStream(fo);
				while (x == 'Y') {
					System.out.print("������ѧ�����֣�");
					String name = sc.next();
					System.out.print("������ѧ��Ժϵ��");
					String department = sc.next();
					System.out.print("������ѧ�����䣺");
					int age = sc.nextInt();
					System.out.print("������ѧ��ƽ���ɼ���");
					float score = sc.nextFloat();
					Student_info t = new Student_info(name, department, age, score);
					oo.writeObject(t);
					System.out.print("�Ƿ�������룿��Y/N��");
					x = (char) System.in.read(); // ~
					i++;
				}
				oo.close();
				fo.close();
			}catch(Exception e) {
				System.out.println("�������");
			}
			System.out.println("�����Ϣ��");
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
				System.out.println("�������");
			}     
	        sc.close();   
		}
}
