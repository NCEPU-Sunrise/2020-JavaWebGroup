package T3;

import T2.Student;

import java.io.*;

public class CopyFileT3_1 {
    public static void main(String[] args) throws Exception{
        Student s1 = new Student("张三","控计学院",19,90);
        Student s2 = new Student("李四","自动化学院",20,85);
        Student s3 = new Student("王五","材料学院",21,80);

        File f = new File("T3_1.txt");

        FileOutputStream fos = new FileOutputStream(f);
        DataOutputStream dos = new DataOutputStream(fos);

        dos.writeUTF(s1.getName());
        dos.writeInt(s1.getAge());
        dos.writeUTF(s1.getDepartment());
        dos.writeFloat(s1.getScore());
        dos.writeUTF(s2.getName());
        dos.writeInt(s2.getAge());
        dos.writeUTF(s2.getDepartment());
        dos.writeFloat(s2.getScore());
        dos.writeUTF(s3.getName());
        dos.writeInt(s3.getAge());
        dos.writeUTF(s3.getDepartment());
        dos.writeFloat(s3.getScore());

        dos.close();

        FileInputStream fis = new FileInputStream(f);
        DataInputStream dis = new DataInputStream(fis);

        System.out.println(dis.readUTF()+";年龄:"+dis.readInt()+";院系:"+dis.readUTF()+";分数:"+dis.readFloat());
        System.out.println(dis.readUTF()+";年龄:"+dis.readInt()+";院系:"+dis.readUTF()+";分数:"+dis.readFloat());
        System.out.println(dis.readUTF()+";年龄:"+dis.readInt()+";院系:"+dis.readUTF()+";分数:"+dis.readFloat());

        dis.close();
    }
}
