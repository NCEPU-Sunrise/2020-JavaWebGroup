package Homework_07;

import java.util.ArrayList;
import java.util.Collections;

public class Poker {
	public static void main(String[] args) {
	ArrayList<String> poker = new  ArrayList<String>();//牌库
	poker.add("大王");
	poker.add("小王");
    String []colors = {"梅花","方片","红桃","黑桃"};//花色
    String []numbers = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};//号码
    for(String n : numbers) {
    	for (String c : colors) {
    		poker.add(c+n);
    	}
    }
    Collections.shuffle(poker);
    ArrayList<String> One = new ArrayList<String>();
    ArrayList<String> Two = new ArrayList<String>();
    ArrayList<String> Three = new ArrayList<>();
    ArrayList<String> last = new ArrayList<>();
    for(int i=0;i<poker.size();i++) {
    	if(i>=poker.size()-3)
    		last.add(poker.get(i));
    	else {
    		switch(i%3) {
    		case 0: One.add(poker.get(i));
    		case 1: Two.add(poker.get(i));
    		case 2: Three.add(poker.get(i));
    		}
    	}
    }
    getInfo("第一个人",One);
    getInfo("第二个人",Two);
    getInfo("第三个人",Three);
    getInfo("底牌",last);
	}
	static void getInfo(String name, ArrayList<String> poker) {
		 System.out.println(name+"：");
		 for(String str : poker) {
			 System.out.print(str+" ");
		 }
		 System.out.println();
	}
}
