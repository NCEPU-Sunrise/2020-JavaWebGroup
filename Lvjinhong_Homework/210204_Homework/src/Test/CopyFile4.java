package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class CopyFile4 {
    public static void main(String[] args) throws Exception{
        //创建高效的字符输入流
        BufferedReader br = new BufferedReader(new FileReader("1.txt"));
        //创建高效的字符输出流
        BufferedWriter bw = new BufferedWriter(new FileWriter("2.txt"));

        //一次读写一个字符
        int ch;
        while((ch = br.read()) != -1){
            bw.write(ch);
        }

        //一次读写一个字符数组
        char chs[] = new char[1024];
        int len;
        while((len = br.read(chs)) != -1){
            bw.write(chs,0,len);
        }

        //释放资源
        br.close();
        bw.close();
    }
}
