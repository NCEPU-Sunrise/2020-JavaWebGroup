package Test;

import java.io.*;

public class CopyFile3 {
    public static void main(String[] args) throws Exception{
        File sourceFile = new File("1.txt");    //源文件
        File destFile = new File("2.txt");      //目标文件
        //创建流
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
        byte[] buf = new byte[1024];
        //创建字节数组
        int i;
        //从输入流中读取数据
        while((i = bis.read(buf))
                != -1){
            //写入到输入流中
            bos.write(buf, 0 , i);
        }
        System.out.println("文件复制成功!");
        bis.close();
        bos.close();
    }
}
