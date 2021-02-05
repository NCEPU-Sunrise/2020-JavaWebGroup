package Test;

import java.io.*;

class Book implements Serializable{
    int id;
    String name;
    String author;
    float price;    // transient float price;
    //transient变量不会被序列化
    //将图书类的成员变量price声明为临时变量。再运行程序，
    //输出结果中其他成员变量的值不变，只有价格一项变为0.0。
    //这是因为临时变量不保存。这对于保护重要的信息(例如密码等)是很有必要的。

    public Book(){}
    public Book(int id,String name,String author,float price){
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
    }
}
public class CopyFile6 {
    //装饰流：对象流

    //概念：用于存储和读取基本数据类型对象的处理流。它的强大之处就是可以把Java中的对象写入
    //到数据源中，也能把对象从数据源中还原回来。

    //优势：方便对象的读写

    //对象序列化：是指将一个对象的属性和方法转化为一种序列化的格式用于存储和传输。
    //对象要想实现序列化，其所属的类必须实现Serializable接口。
    //如果要定制对象的序列化和反序列化过程，需要实现Externalizable接口。


    public static void main(String[] args) throws Exception{
        Book b1 = new Book(100032,"Java","Li Si",30);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("book.txt"));

        oos.writeObject(b1);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("book.txt"));
        Book b2 = (Book)ois.readObject();
        ois.close();
        System.out.println("ID is:" +b2.id);
        System.out.println("name is:" + b2.name);
        System.out.println("author is:"+b2.author);
        System.out.println("price is:"+b2.price);
    }
}
