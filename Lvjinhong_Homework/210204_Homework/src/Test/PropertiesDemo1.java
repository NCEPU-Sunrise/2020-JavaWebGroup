package Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

//概念：是一个Map体系的集合类，Properties可以保存到流中或从流中加载，
//属性列表中的每个键及其对应的值都是一个字符串
public class PropertiesDemo1 {
    public static void main(String[] args) throws Exception{
        myStore();
        myLoad();
    }

    private static void myLoad() throws IOException{
        Properties prop = new Properties();

        //void load(Reader reader)
        FileReader fr = new FileReader("fr.txt");
        prop.load(fr);
        fr.close();

        System.out.println(prop);
    }

    private static void myStore() throws IOException{
        Properties prop = new Properties();

        prop.setProperty("leon001","林青霞");
        prop.setProperty("leon002","张曼玉");
        prop.setProperty("leon003","王祖贤");

        //void store(Writer writer,String comments):
        FileWriter fw = new FileWriter("fw.txt");
        //写入以上键值对到fw文件
        prop.store(fw,null);

        fw.close();
    }
}
