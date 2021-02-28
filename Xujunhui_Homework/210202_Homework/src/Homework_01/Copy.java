package Homework_01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//使用缓冲流实现文件的复制
public class Copy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream("src/Homework_01/test.txt")); 
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src/Homework_01/test1.txt")); 
			System.out.println("开始复制文件......");
			 byte[] buf = new byte[1024]; 		
	         // 创建字节数组
		     int i;
		     while ((i = bis.read(buf)) != -1) { 	  	
	             // 从输入流中读取数据
			   bos.write(buf, 0, i); 		
	             // 写入到输出流中
		     }
		     System.out.println("文件复制成功！");
		     bis.close(); 				
		     bos.close(); 
		}catch(IOException e) {
			System.out.println("文件操作异常！");
		}
	}

}
