package Test;

import java.io.IOException;

//标准输入输出流
//概念：Java通过系统类System实现标准输入/输出的功能，定义了3个流变量:in,out,err.
//这3个流在java中都定义为静态变量，可以直接通过System类进行调用。
public class CopyFile14 {
    public static void main(String[] args) throws IOException {
        //System.in表示标准输入，通常指从键盘输入数据；
        System.out.println("input:");
        byte b[] = new byte[512];
        int count = System.in.read(b);
        System.out.println("Output");
        for (int i = 0;i < count;i++){
            System.out.println(b[i] + " ");
        }
        System.out.println();
        for (int i = 0;i < count;i++){
            System.out.println((byte)b[i] + " ");
        }
        System.out.println("count=" + count);

        //不过System.in却是一个没有被包装过的未经加工的InputStream，
        //也就是说在使用System.in之前必须对其进行包装。
    }
}
