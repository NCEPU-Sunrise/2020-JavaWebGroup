package Homework_06;

import java.io.File;
import java.io.FileReader;

public class demo {

	public static void main(String[] args) {
		try {
			FileReader fr=new FileReader("src/Homework_06/test.txt");
			
			char[]c=new char[1024];
			int n=0;
			while((n=fr.read(c))!=-1) {
				
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
