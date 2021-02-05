package T5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class CopyFileT5_1 {
    public static void main(String[] args) throws Exception{
        FileInputStream fis1 = new FileInputStream("T5_1.txt");
        FileInputStream fis2 = new FileInputStream("T5_2.txt");
        FileInputStream fis3 = new FileInputStream("T5_3.txt");
        Vector<InputStream> v = new Vector<>();

        v.add(fis1);
        v.add(fis2);
        v.add(fis3);

        Enumeration<InputStream> en = v.elements();

        SequenceInputStream sis = new SequenceInputStream(en);
        FileOutputStream fos = new FileOutputStream("T5_4.txt");

        int b;
        while((b = sis.read()) != -1){
            fos.write(b);
        }

        sis.close();
        fos.close();
    }
}
