package Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class CopyFile2 {
    public static void main(String[] args) {
        File f = new File("1.txt");
        File f_d = new File("2.txt");
        try{
            FileReader fr = new FileReader(f);
            FileWriter fw = new FileWriter(f_d);
            char c[] = new char[1024];
            int n = 0;
            while ((n = fr.read(c)) != -1){
                fw.write(c,0,n);
                System.out.println(new String(c,0,n));
            }
            fr.close();
            fw.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        finally { }
    }
}
