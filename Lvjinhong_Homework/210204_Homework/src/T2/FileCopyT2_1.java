package T2;

import java.io.*;

public class FileCopyT2_1 {
    public static void main(String[] args) throws Exception{
        //文件流+对象流
        Student s1 = new Student("张三","控计学院",19,90);
        Student s2 = new Student("李四","自动化学院",20,85);
        Student s3 = new Student("王五","材料学院",21,80);

        File f = new File("T2_1.txt");

        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(s1);
        oos.writeObject(s2);
        oos.writeObject(s3);

        oos.close();

        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);

        Student rs1 = (Student) ois.readObject();
        Student rs2 = (Student) ois.readObject();
        Student rs3 = (Student) ois.readObject();

        ois.close();

        System.out.println(rs1.name+";院系:"+rs1.department+";年龄:"+rs1.age+";分数:"+rs1.score);
        System.out.println(rs2.name+";院系:"+rs2.department+";年龄:"+rs2.age+";分数:"+rs2.score);
        System.out.println(rs3.name+";院系:"+rs3.department+";年龄:"+rs3.age+";分数:"+rs3.score);

    }
}
