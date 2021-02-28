package Homework_05;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class Sequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileInputStream fis1=new FileInputStream("src/Homework_05/test1.txt");
			FileInputStream fis2=new FileInputStream("src/Homework_05/test2.txt");
			FileInputStream fis3=new FileInputStream("src/Homework_05/test3.txt");
			Vector<InputStream> v=new Vector<>();
			v.add(fis1);
			v.add(fis2);
			v.add(fis3);
			Enumeration<InputStream> en=v.elements();//通过Vector获取迭代器
			SequenceInputStream sis=new SequenceInputStream(en);//传递给SequenceInputStream构造
			FileOutputStream fos=new FileOutputStream("src/Homework_05/test4.txt");
			int b;
			while((b=sis.read())!=-1) {
				fos.write(b);
			}
		sis.close();
		fos.close();
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
