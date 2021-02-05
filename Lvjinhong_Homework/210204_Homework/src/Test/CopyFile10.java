package Test;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

//内存输出流
//概念：文件流的操作是对文件操作，除了文件，IO也可以对内存进行操作，
//这种流称之为内存流。该输出流可以向内存中写数据，把内存当做一个缓冲区，
//写出之后可以一次性获取出所有数据(一般应用在聊天)
public class CopyFile10 {
    public static void main(String[] args) throws Exception{
        //1.read(byte[] b)是字节输入流的方法，创建FileInputStream
        FileInputStream fis = new FileInputStream("x.txt");

        //2.创建内存输出流，将读到的数据写到内存输出流中
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        //3.创建字节数组，长度为5
        byte[] arr = new byte[5];
        int len;

        while((len = fis.read(arr)) != -1){
            baos.write(arr,0,len);
            //System.out.println(new String(arr, 0, len));
        }

        //4.将内存输出流的数据全部转换为字符串打印
        System.out.println(baos);

        //5.关闭输入流
        fis.close();
    }
}
