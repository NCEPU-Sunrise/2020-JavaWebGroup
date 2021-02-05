package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyFile {
    public static void main(String[] args) throws Exception{
//        FileInputStream类和FileOutputStream类虽然可以高效率地读/写文件，
//        但对于Unicode编码的文件，使用它们有可能出现乱码，因为汉字在文件中占用两个字节，
//        如使用字节流，会出现乱码现象，而在Unicode字符中，一个汉字被看作一个字符。
        //将文件1.txt复制到文件2.txt
        File f = new File("1.txt");
        File f_d = new File("2.txt");
        byte[] b = new byte[1024];
        FileInputStream f_1 = new FileInputStream(f);
        FileOutputStream f_d_1 = new FileOutputStream(f_d);
        int i = 0;
        while((i = f_1.read(b)) != -1){
            f_d_1.write(b,0,i);
            System.out.println(new String(b,0,i));
        }
        f_1.close();
        f_d_1.close();
    }
}
