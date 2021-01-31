package TestCaoGao;

import java.util.Vector;

public class vectorTest {
    public static void main(String[] args) {
        Vector<Integer> i = new Vector<>(20);
        System.out.println(i.size());
        i.add(1);
        System.out.println(i.size());
    }
}
