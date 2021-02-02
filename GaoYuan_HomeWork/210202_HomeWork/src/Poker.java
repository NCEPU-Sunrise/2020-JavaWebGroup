import java.util.ArrayList;
import java.util.Collections;
public class Poker {
    public static void main(String[] args) {
        //创建牌盒
        ArrayList<String> al = new  ArrayList<String>();
        String []colors = {"梅花","方片","红桃","黑桃"};
        String []numbers = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        for (String c : colors) {
            for (String n : numbers) {
                al.add(c+n);    
            }   
        }
        al.add("小王");
        al.add("大王");
        Collections.shuffle(al);
        ArrayList<String> zhangsan = new ArrayList<String>();
        ArrayList<String> lisi = new ArrayList<String>();
        ArrayList<String> wangwu = new ArrayList<>();
        ArrayList<String> dipai = new ArrayList<>();
        //发牌
        for (int i = 0; i < al.size(); i++) {
            if(i>=al.size()-3){
                dipai.add(al.get(i));
            }else if(i%3==0){
                zhangsan.add(al.get(i));
            }else if(i%3==1){
                lisi.add(al.get(i));
            }else if(i%3==2){
                wangwu.add(al.get(i));
            }
        }
        lookpoker("张三",zhangsan);
        lookpoker("李四",lisi);
        lookpoker("王五",wangwu);
        lookpoker("底牌",dipai);
    }
    private static void lookpoker(String string, ArrayList<String> al) {
        // TODO Auto-generated method stub
        System.out.println(string+"的牌是：");
        for (String string2 : al) {
            System.out.print(string2+" ");
        }
        System.out.println();
    }
   }
