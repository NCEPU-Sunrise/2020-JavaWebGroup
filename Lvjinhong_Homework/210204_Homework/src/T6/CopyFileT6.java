package T6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class CopyFileT6 {
    public static void main(String[] args) throws Exception{
        BufferedReader br1 = new BufferedReader(new FileReader("T6_1.txt"));
        BufferedReader br2 = new BufferedReader(new FileReader("T6_2.txt"));
        BufferedReader br3 = new BufferedReader(new FileReader("T6_3.txt"));


        BufferedWriter bw1 = new BufferedWriter(new FileWriter("T6_2.txt"));
        BufferedWriter bw2 = new BufferedWriter(new FileWriter("T6_3.txt"));
        BufferedWriter bw3 = new BufferedWriter(new FileWriter("T6_4.txt"));

        //读取T6_1...
        //好吧不会，投了
    }
}
