import java.io.*;

public class Homework_1 {
    public static void main(String[] args) throws IOException {

        FileInputStream inputStream=new FileInputStream("E:\\Javawenjian\\first.txt");
        BufferedInputStream bufferedInputStream=new BufferedInputStream(inputStream);
        File destFile=new File("E:\\Javawenjian\\second.txt");
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(destFile));
        byte[]a=new byte[1024];
        int i;
        while((i=bufferedInputStream.read(a))!=-1)
        {
            bufferedOutputStream.write(a,0,i);
        }
        System.out.println("复制成功！");
        bufferedInputStream.close();
        bufferedOutputStream.close();


    }
}
