import java.util.ArrayList;
import java.util.Collections;
public class Poker {
    public static void main(String[] args) {
        //�����ƺ�
        ArrayList<String> al = new  ArrayList<String>();
        String []colors = {"÷��","��Ƭ","����","����"};
        String []numbers = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        for (String c : colors) {
            for (String n : numbers) {
                al.add(c+n);    
            }   
        }
        al.add("С��");
        al.add("����");
        Collections.shuffle(al);
        ArrayList<String> zhangsan = new ArrayList<String>();
        ArrayList<String> lisi = new ArrayList<String>();
        ArrayList<String> wangwu = new ArrayList<>();
        ArrayList<String> dipai = new ArrayList<>();
        //����
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
        lookpoker("����",zhangsan);
        lookpoker("����",lisi);
        lookpoker("����",wangwu);
        lookpoker("����",dipai);
    }
    private static void lookpoker(String string, ArrayList<String> al) {
        // TODO Auto-generated method stub
        System.out.println(string+"�����ǣ�");
        for (String string2 : al) {
            System.out.print(string2+" ");
        }
        System.out.println();
    }
   }
