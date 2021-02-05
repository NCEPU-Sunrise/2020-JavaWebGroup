package Test;

//System.err表示标准错误输出，通常指把数据输出到控制台或者屏幕，
//其本质为PrintStream.

//System.err.println只能在屏幕上实现打印，即使你重定向了也一样。
//你使用err打印出的字符串，在console界面会显示成错误颜色。
public class CopyFile17 {
    public static void main(String[] args) {
        System.err.println("error!");
    }
}
