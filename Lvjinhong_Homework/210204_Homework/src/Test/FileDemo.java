package Test;

import java.io.File;

public class FileDemo {
    public static void main(String[] args) {
        //创建File对象，代表一个文件
        File file = new File("test.txt");

        //显示与文件有关的属性信息
        System.out.println("文件或目录是否存在：" + file.exists());
        System.out.println("是文件吗：" + file.isFile());
        System.out.println("是目录吗：" + file.isDirectory());
        System.out.println("名称：" + file.getName());
        System.out.println("绝对路径：" + file.getAbsolutePath());
        System.out.println("最后修改时间：" + file.lastModified());
        System.out.println("文件大小：" + file.length() + "字节");
    }
}
