package Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

//打印流
//概念：PrintStream只负责输出数据，不负责读取数据
//优势：打印流是输出信息最方便的类，永远不会抛出IOException，
//有一个构造方法可以直接接受OutputStream类的实例，与OutputStream相比起来，
//PrintStream可以更方便的输出数据，相当于把OutputStream类重新包装了一下，使之输出更方便。
public class CopyFile12 {
    //字节打印流
    public static void main(String[] args) throws FileNotFoundException {

        try {
            int arr[] = new int[-1];
        } catch (Exception e) {
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日hh:mm:ss SS");
            String line = sdf.format(d);
            PrintStream ps = new PrintStream(new FileOutputStream("x.txt"));
            ps.println(line);
            e.printStackTrace(ps);
            ps.close();
        }
    }

}
