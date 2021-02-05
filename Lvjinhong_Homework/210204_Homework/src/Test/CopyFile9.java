package Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

//构造方法：SequenceInputStream(Enumeration<? extends InputStream> e)
//整合多个输入流

public class CopyFile9 {
    //序列流整合多个(利用枚举)
    public static void main(String[] args) throws Exception{
        FileInputStream fis1 = new FileInputStream("x.txt");
        FileInputStream fis2 = new FileInputStream("y.txt");
        FileInputStream fis3 = new FileInputStream("z.txt");
        Vector<InputStream> v =new Vector<>();

        //创建Vector集合对象
        v.add(fis1);
        //将流对象添加
        v.add(fis2);
        v.add(fis3);
        //通过Vector获取迭代器
        Enumeration<InputStream> en = v.elements();
        //传递给SequenceInputStream构造
        SequenceInputStream sis = new SequenceInputStream(en);
        FileOutputStream fos = new FileOutputStream("xyz.txt");

        int b;
        while ((b = sis.read()) != -1){
            fos.write(b);
        }

        sis.close();
        fos.close();
    }
}
