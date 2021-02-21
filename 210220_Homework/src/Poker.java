import javax.swing.plaf.synth.SynthDesktopIconUI;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Poker {
    public static void main(String[] args) {
        List<String> all=new LinkedList<String>();
        for(int j=0;j<4;j++) {
            for (int i = 2; i <=10; i++) {
                all.add(String.valueOf(i));
            }
            all.add("A");
            all.add("J");
            all.add("Q");
            all.add("K");
        }
        all.add("big joker");
        all.add("small joker");


        int count=54;
        Random r=new Random();
        int ran;
        List<String> poker1=new LinkedList<String>();
        List<String> poker2=new LinkedList<String>();
        List<String> poker3=new LinkedList<String>();
        for(int i=0;i<17;i++)
        {
            ran=r.nextInt(count);
            //System.out.println(ran);
            poker1.add(all.get(ran));
            all.remove(ran);
            count--;
            ran=r.nextInt(count);
            //System.out.println(ran);
            poker2.add(all.get(ran));
            all.remove(ran);
            count--;
            ran=r.nextInt(count);
            //System.out.println(ran);
            poker3.add(all.get(ran));
            all.remove(ran);
            count--;
            //System.out.println("000"+count);

        }
        System.out.println("第一个人的牌：");
        System.out.println(poker1);
        System.out.println("第二个人的牌：");
        System.out.println(poker2);
        System.out.println("第三个人的牌：");
        System.out.println(poker3);
        System.out.println("底牌：");
        System.out.println(all);


    }
}
