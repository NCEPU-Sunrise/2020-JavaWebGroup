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
			System.out.println("������ѧ����Ϣ��");
			try {
				fo = new FileOutputStream(f);
				do_ = new DataOutputStream(fo);
				while (x == 'Y') {
					Info t = new Info();
					System.out.print("������ѧ�����֣�");
					t.name = sc.next();
					System.out.print("������ѧ��Ժϵ��");
					t.department = sc.next();
					System.out.print("������ѧ�����䣺");
					t.age = sc.nextInt();
					System.out.print("������ѧ��ƽ���ɼ���");
					t.score = sc.nextFloat();
					do_.writeUTF(t.name+","+t.department+","+t.age+","+t.score+"\n");
					System.out.print("�Ƿ�������룿��Y/N��");
					x = (char) System.in.read(); // ~
					i++;
				}
				do_.close();
				fo.close();
			}catch(Exception e) {
				System.out.println("�������");
			}
			System.out.println("�����Ϣ��");
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
				System.out.println("�������");
			}     
	        sc.close();   
		}
}
