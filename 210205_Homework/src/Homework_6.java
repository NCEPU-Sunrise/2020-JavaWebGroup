import java.io.*;

public class Homework_6 {
    public static void main(String[] args) throws IOException {
        File file=new File("E:\\Javawenjian\\tenth.txt");
        FileInputStream fileInputStream=new FileInputStream(file);
        FileOutputStream fileOutputStream=new FileOutputStream(new File("E:\\Javawenjian\\xxx.txt"));
        FileOutputStream fileOutputStream1=new FileOutputStream(new File("E:\\Javawenjian\\yyy.txt"));
        for(int i=0;i<file.length()/2;i++)
        {
            int a=fileInputStream.read();
            fileOutputStream.write(a);
        }
        for(int i=(int)file.length()/2;i<file.length();i++)
        {
            int a=fileInputStream.read();
            fileOutputStream1.write(a);
        }
        fileInputStream.close();
        fileOutputStream.close();
        fileOutputStream1.close();
    }
}
