package Test;

import java.io.*;
import java.util.Date;
//Externalizable接口继承了Serializable接口
//实现Externalizable接口可以控制对象的读写
//Externalizable接口包含两个方法writeExternal()和readExternal(),实现接口的类必须实现这两个方法。
//一个类实现了Externalzable接口
//当采用ObjectOutputStream流输出对象时，会自动调用writeExternal()方法
//当采用ObjectInputStream流输入对象时，会自动调用readExternal()方法
class Book2 implements Externalizable {
    int id;
    String name;
    String author;
    transient float price;

    public Book2() {}

    public Book2(int id, String name, String author, float price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
    }
    // 当序列化对象时(使用对象输出流)，writeExternal()方法被自动调用
    public void writeExternal(ObjectOutput out) throws IOException, IOException {
        Date date = new Date();
        out.writeObject(date); 		// 输出非自身的变量
        out.writeObject(name);      //ObjectOutputStream既可以输出对象，又可以输出基本类型的数据。
        out.writeObject(author);
    }

    // 当反序列化对象时(使用对象输入流)，readExternal()方法被自动调用
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        Date date = (Date) in.readObject();
        System.out.println(date);
        this.name = (String) in.readObject();
        this.author = (String) in.readObject();
    }
}

public class CopyFile7 {
    public static void main(String[] args) throws Exception{
        Book2 book1 = new Book2(100032, "Java", "Li Si", 30);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("book.txt"));
        oos.writeObject(book1);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("book.txt"));
        Book2 book2 = (Book2)ois.readObject();
        ois.close();

        System.out.println("name is:" + book2.name);
        System.out.println("author is:" + book2.author);
    }
    //对象输入流和对象输出流必须配合使用
    //主要用于对象数据，也可以使基本数据类型的读写
    //一个类实现Serializbale接口后才能进行序列化
    //如果要定制对象的序列化和反序列化过程，需要实现Externalizable接口
}
