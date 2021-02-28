package Homework_02;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//文件流+对象流
public class Copy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student[] s=new Student[3];
		s[0]=new Student("小强", "控计与计算机工程学院", 20, 99);
		s[1]=new Student("小红", "数理学院", 21, 95);
		s[2]=new Student("小妍", "能源与动力工程学院", 20, 90);
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new BufferedOutputStream(
					new FileOutputStream("src/Homework_02/student.txt")));
			oos.writeObject(s);
			oos.close();
		}catch(IOException e) {
			System.out.println("文件写入失败");
		}
		try {
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream("src/Homework_02/student.txt"));
			System.out.println("文件内容如下：");
			Student[] stu=(Student[])ois.readObject();
			for(int i=0;i<stu.length;i++) {	
				System.out.print(stu[i].name+" ");
				System.out.print(stu[i].department+" ");
				System.out.print(stu[i].age+" ");
				System.out.println(stu[i].score);
			}
			ois.close();
		}catch(IOException e) {
			System.out.println("文件读取失败");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
