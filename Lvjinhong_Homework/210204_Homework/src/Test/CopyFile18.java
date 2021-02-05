package Test;

import java.io.File;
import java.io.RandomAccessFile;

//概念：RandomAccessFile类不属于流，是Object类的子类，支持随机访问文件的读取和写入。
//我们以前讲的IO字节流，包装流等都是按照文件内容的顺序来读取和写入的。
//而这个随机访问文件流我们可以在文件的任意地方写入数据，也可以读取任意地方的字节。
public class CopyFile18 {
    public static void main(String[] args) throws Exception{
        //指定要操作的文件
        File f = new File("data.txt");

        //读写模式，如果文件不存在则会自动创建
        RandomAccessFile rdf = new RandomAccessFile(f, "rw");

        String name = null;
        int age = 0;
        name = "zhangsan";      //字符串长度为8
        age = 30;               //数字长度为4
        rdf.writeBytes(name);
        rdf.writeInt(age);
        name = "lisi    ";      //字符串长度为8
        age = 31;               //数字长度为4
        rdf.writeBytes(name);
        rdf.writeInt(age);
        name = "wangwu  ";      //字符串长度为8
        age = 32;               //数字长度为4
        rdf.writeBytes(name);
        rdf.writeInt(age);
        rdf.close();
    }
}
