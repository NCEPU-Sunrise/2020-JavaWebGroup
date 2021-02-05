package Test;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

class Log{
    public static void writeLog(String msg){
        PrintStream out = null;
        try{
            out = new PrintStream(new FileOutputStream("1.txt"), true);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        //改变输出方向，使得标准输出流不再指向控制台，指向log文件
        System.setOut(out);
        //当前日期时间
        Date nowtime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String strTime = sdf.format(nowtime);
        System.out.println(strTime + ":" + msg);
    }



}

//System.out表示标准输出，通常指把数据输出到控制台或者屏幕，
//其本质为PrintStream（怎么用打印流就怎么用System.out语句）；
public class CopyFile16 {
    //由于System.out是一个PrintStream，而PrintStream是一个OutputStream，
    //也就是说System.out是一个字节流。为了使用起来更加高效快捷，
    //我们完全可以将System.out包装成PrintWriter。
    public static void out2() {

        PrintWriter pw = new PrintWriter(System.out, true);
        //第二个参数设置为true表示开启自动刷新，否则，可能由于输出的数据小于缓冲区的大小而导致数据暂时存放于缓冲区中，从而看不到数据的输出。
        pw.println(47);		// 往控制台输出int类型数据
        pw.println(13.14);	// 往控制台输出double类型数据
        pw.println("I love java");	// 往控制台输出string类型数据

    }

    public static void main(String[] args) {
        //out2();
        Log.writeLog("7点起床");
        Log.writeLog("然后去吃早饭");
    }
}
