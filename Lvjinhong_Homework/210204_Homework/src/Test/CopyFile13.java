package Test;

import java.io.*;

public class CopyFile13 {
    //字符打印流
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("x.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("1.txt"), true);
        String line;
        while((line = br.readLine()) != null){
            pw.println(line);
        }
        pw.close();
        //因为是字符流，所以需要刷新，但是pw.close()方法里已经包含pw.flash()方法了，所以不需要再调用了。

        //如果pw.flush()方法和pw.close()方法里都没调用，但是数据还是写进文件里了，
        //是因为构造参数里的true,设置为了刷新，所以会把数据写入。
        br.close();
    }
}
