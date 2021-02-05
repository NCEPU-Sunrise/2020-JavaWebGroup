package Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.SequenceInputStream;

//序列流
//概念：也被称为合并流，对多个流进行合并。SequenceInputStream表示其他输入流的逻辑串联。
//它从输入流的有序集合开始，并从第一个输入流开始读取，直到到达文件末尾，接着从第二个输入流读取，
//依次类推，直到到达包含的最后一个输入流的文件末尾为止。

//优势:没有使用序列流时如果读取两个输入流时，读取过程的操作降低了代码的复用性

//构造方法：SequenceInputStream(InputStream s1, InputStream s2)
//整合两个输入流
public class CopyFile8 {
    public static void main(String[] args) throws Exception{
        FileInputStream fis1 = new FileInputStream("x.txt");
        FileInputStream fis2 = new FileInputStream("y.txt");
        //将两个流整合成一个流
        SequenceInputStream sis = new SequenceInputStream(fis1, fis2);
        FileOutputStream fos = new FileOutputStream("z.txt");
        int b;
        while((b = sis.read()) != -1){
            fos.write(b);
        }
        //sis在关闭的时候，在构造方法中传入的值也会闭掉
        sis.close();
        fos.close();
    }
}
