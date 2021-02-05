package Test;

import java.io.File;
import java.io.RandomAccessFile;

public class CopyFile19 {
    public static void main(String[] args) throws Exception{
        File f = new File("data.txt");

        RandomAccessFile rdf = new RandomAccessFile(f, "r");

        String name = null;
        int age = 0;
        //开辟byte数组
        byte b[] = new byte[8];

        //读取第二个人信息，意味着要空出第一个人的信息
        rdf.skipBytes(12);
        for(int i = 0;i < b.length;i++){
            b[i] = rdf.readByte();
        }
        name = new String(b);

        age = rdf.readInt();
        System.out.println("第二个人的信息-->姓名：" + name + "；年龄：" + age);

        //读取第一个人的信息
        //指针回到文件开头
        rdf.seek(0);
        for (int i = 0;i < b.length;i++){
            b[i] = rdf.readByte();
        }
        name = new String(b);
        age = rdf.readInt();
        System.out.println("第一个人的信息-->姓名：" + name + "；年龄：" + age);

        rdf.skipBytes(12);
        for(int i = 0;i < b.length;i++){
            b[i] = rdf.readByte();
        }
        name = new String(b);

        age = rdf.readInt();
        System.out.println("第三个人的信息-->姓名：" + name + "；年龄：" + age);
        rdf.close();
    }
}
