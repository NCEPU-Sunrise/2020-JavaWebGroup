import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

public class Homework_5 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream1=new FileInputStream("E:\\Javawenjian\\sixth.txt");
        FileInputStream fileInputStream2=new FileInputStream("E:\\Javawenjian\\seventh.txt");
        FileInputStream fileInputStream3=new FileInputStream("E:\\Javawenjian\\eighth.txt");
        Vector<InputStream> v=new Vector<>();
        v.add(fileInputStream1);
        v.add(fileInputStream2);
        v.add(fileInputStream3);
        Enumeration<InputStream> en=v.elements();
        SequenceInputStream sequenceInputStream=new SequenceInputStream(en);
        File file=new File("E:\\Javawenjian\\ninth.txt");
        FileOutputStream fileOutputStream=new FileOutputStream(file);
        byte b[]=new byte[1024];
        int i=0;
        while((i=sequenceInputStream.read(b))!=-1){
            fileOutputStream.write(b,0,i);
        }
        sequenceInputStream.close();
        fileOutputStream.close();


    }
}
