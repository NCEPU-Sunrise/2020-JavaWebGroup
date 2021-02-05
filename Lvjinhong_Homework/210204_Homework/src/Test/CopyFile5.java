package Test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyFile5 {
    //装饰流：数据流

    //在前面的示例中，在向流中写入的数据必须首先转换为byte数组或char数组，
    //当写入的数据较少、较简单时，则向流中写入数据时还不是很麻烦。
    //但是如果向流中写入数据比较多时，手动转换数据格式则会比较麻烦。
    //为了简化程序员对于流的操作，使得程序员可以从繁杂的数据格式中解脱出来，
    //在IO类中专门设计了两个类——DataInputStream/DataOutStream类简化流数据的读写。

    //优势：方便读写基本类型的数据
    public static void main(String[] args) throws Exception{
        //写入文件
        FileOutputStream fos = new FileOutputStream("a.txt");
        DataOutputStream dos = new DataOutputStream(fos);

        dos.writeBoolean(true);
        dos.writeByte((byte)123);
        dos.writeChar('J');
        dos.writeDouble(3.1415926);
        dos.writeFloat(1.414f);
        dos.writeInt(1234);
        dos.writeLong(998877665544332211L);
        dos.writeUTF("您好!");

        dos.close();

        //从文件中读取
        DataInputStream dis = new DataInputStream(new FileInputStream("a.txt"));

        System.out.println("\t" + dis.readBoolean());
        System.out.println("\t" + dis.readByte());
        System.out.println("\t" + dis.readChar());
        System.out.println("\t" + dis.readDouble());
        System.out.println("\t" + dis.readFloat());
        System.out.println("\t" + dis.readInt());
        System.out.println("\t" + dis.readLong());
        System.out.println("\t" + dis.readUTF());

        dis.close();
        //这两个类必须匹配起来使用
        //读和写顺序要一致
    }
}
