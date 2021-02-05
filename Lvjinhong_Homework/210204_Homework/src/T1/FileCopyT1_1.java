package T1;

import java.io.*;

public class FileCopyT1_1 {
    public static void main(String[] args) throws Exception{
        File f = new File("T1_1.txt");
        File f_c = new File("T1_2.txt");

        FileReader fr = new FileReader(f);
        BufferedReader bf = new BufferedReader(fr);

        FileWriter fw = new FileWriter(f_c);
        BufferedWriter bw = new BufferedWriter(fw);
        int i;
        while((i = bf.read()) != -1){
            bw.write(i);
            //System.out.println((char)i);
        }

        bf.close();
        bw.close();
    }
}
