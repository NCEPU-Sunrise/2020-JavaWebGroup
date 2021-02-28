package Homework_03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//文件流+数据流
public class Copy {
	public static void main(String[] args) {
		Student[] s=new Student[3];
		s[0]=new Student("小强", "控计与计算机工程学院", 20, 99);
		s[1]=new Student("小红", "数理学院", 21, 95);
		s[2]=new Student("小妍", "能源与动力工程学院", 20, 90);
		try {
			DataOutputStream dos=new DataOutputStream(new FileOutputStream("src/Homework_03/test.txt"));
			dos.writeInt(s.length);
			for(int i=0;i<s.length;i++) {
				dos.writeUTF(s[i].name);
				dos.writeUTF(s[i].department);
				dos.writeInt(s[i].age);
				dos.writeFloat(s[i].score);
			}
			dos.close();
		}catch(IOException e) {
			System.out.println("文件写入失败");
		}
		try {
			DataInputStream dis=new DataInputStream(new FileInputStream("src/Homework_03/test.txt"));
			int l=dis.readInt();
			for(int j=0;j<l;j++) {
				System.out.print(dis.readUTF()+" ");
				System.out.print(dis.readUTF()+" ");
				System.out.print(dis.readInt()+" ");
				System.out.println(dis.readFloat());
			}
			dis.close();
		}catch(IOException e) {
			System.out.println("文件读取失败");
		}
	}
}
