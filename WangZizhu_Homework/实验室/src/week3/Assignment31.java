package week3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Assignment31 {

		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			File f = new File("1.txt");
			File f_d=new File("2.txt");
			byte[] b = new byte[1024];
			BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(f));
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(f_d));
			int i=0;
			while((i=bufferedInputStream.read(b))!=-1){
				bufferedOutputStream.write(b, 0, i);
				System.out.print(new String(b,0,i));
			}
			bufferedInputStream.close();
			bufferedOutputStream.close();
		}
}
