package week3;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class Assignment34 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Properties properties = new Properties();
		FileReader fileReader = new FileReader("login.txt");
		properties.load(fileReader);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("��ӭ�����½ϵͳ��");
		System.out.println("�����������˺ţ�");
		String id = sc.next();
		System.out.println("�������������룺");
		String pwd = sc.next();
		Set<String> propertynames=properties.stringPropertyNames();
		Iterator<String> it = propertynames.iterator();
		while(it.hasNext()) {
			String xString = it.next();
			if(id.equals(xString)) {
				if((properties.getProperty(xString)).equals(pwd)) {
					System.out.println("��½�ɹ�");
					return;
				}
				else {
					System.out.println("�������");
					return;
				}
				
			}
	    }
		System.out.println("�˺Ų����ڻ����");
		sc.close();
	}
}
