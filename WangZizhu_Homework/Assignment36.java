package 实验室;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Assignment36 {

		public static void split(File f) {
			int i = 0,c = 0;
			File f_2 = new File("2.txt");
			File f_3 = new File("3.txt");
			FileWriter fw1, fw2;
			try {
				FileReader fr = new FileReader(f);
				fw1 = new FileWriter(f_2);
				fw2 = new FileWriter(f_3);
				while((c=fr.read())!=-1) {
			       i++;
			       if(i < (f.length()/2)) {
			    	   fw1.write((char)c);
	               }
			       else
					   fw2.write((char)c);
				}
				fr.close();
				fw1.close();
				fw2.close();
			} catch(FileNotFoundException e) {
				System.out.println("找不到文件！");
				System.exit(0);
			} catch(IOException e) {
				System.out.println("程序出错！");
				System.exit(0);
			}finally {
				System.out.println("程序结束！");
			}
		}
		public static void merge(File f1, File f2) {
			int a = 0;
			int b = 0;
			File f_6 = new File("6.txt");
			FileReader fr1, fr2;
			FileWriter fw;
			try {
				fr1 = new FileReader(f1);
				fr2 = new FileReader(f2);
				fw = new FileWriter(f_6);
				while((a=fr1.read())!=-1) {
					fw.write((char)a);
				}
				while((b=fr2.read())!=-1) {
					fw.append((char)b);
				}
				fr1.close();
				fr2.close();
				fw.close();
			} catch(FileNotFoundException e) {
				System.out.println("找不到文件！");
				System.exit(0);
			} catch(IOException e) {
				System.out.println("程序出错！");
				System.exit(0);
			}finally {
				System.out.println("程序结束！");
			}
		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			File f_1 = new File("1.txt");
			File f_4 = new File("4.txt");
			File f_5 = new File("5.txt");
			System.out.println("将文件1分割成文件2和文件3：");
			split(f_1);
			System.out.println("将文件4和文件5合并成文件6：");
			merge(f_4, f_5);

		}
}
