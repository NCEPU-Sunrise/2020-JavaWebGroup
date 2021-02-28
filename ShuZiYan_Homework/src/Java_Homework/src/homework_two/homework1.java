package homework_two;
import java.util.ArrayList;
import java.util.Collections;
public class homework1 {
        public static void main(String[] args) {
            ArrayList<String> poker = new ArrayList<String>();
            String[] colors = {"♠","♥","♣","♦" };
            String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K","A","2"};
            for (int x = 0;x<colors.length; x++){
                for (int y = 0; y < numbers.length; y++) {
                    poker.add(colors[x].concat(numbers[y]));
                }
            }
            poker.add("小王");
            poker.add("大王");
            //System.out.println(poker);
            Collections.shuffle(poker);
            ArrayList<String> pipixia= new ArrayList<String>();
            ArrayList<String> xiaohong= new ArrayList<String>();
            ArrayList<String> xiaoming= new ArrayList<String>();
            ArrayList<String> dipai= new ArrayList<String>();
            for (int x= 0;x<poker.size();x++) {
                if (x>=poker.size()-3) {
                    dipai.add(poker.get(x));
                } else if (x % 3 == 1) {
                    pipixia.add(poker.get(x));
                }else if(x%3==2){
                    xiaohong.add(poker.get(x));
                }else{
                    xiaoming.add(poker.get(x));
                }
            }
            lookPoker(pipixia,"皮皮虾");
            lookPoker(xiaoming,"小明");
            lookPoker(xiaohong,"小红");
            lookPoker(dipai,"底牌");

        }
        public static <T> void lookPoker(ArrayList<T> list,String name){
            System.out.print(name+"的牌是：");
            for(T s :list){
                System.out.print(s+" ");

            } System.out.println("共有:"+list.size()+"张");
        }
    }

