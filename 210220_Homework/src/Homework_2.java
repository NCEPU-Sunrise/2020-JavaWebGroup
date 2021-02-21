import java.util.*;

public class Homework_2 {
    public static void main(String[] args) {
        String string[]=new String[10];
        for(int i=0;i<10;i++)
        {
            string[i]=String.valueOf(i);
        }
        List<String> all1=new ArrayList<String>();

        for(int i=0;i<10;i++){
        all1.add(string[i]);
        }

        Collections.reverse(all1);//反转
        System.out.println(all1);

        List<String>all2=new ArrayList<String>();
        for(int i=0;i<10;i++){
            all2.add(string[i]);
        }

        ListIterator<String>iter=all2.listIterator();
        List <String> listnew=new ArrayList<String>();
        while(iter.hasNext())
        {
            iter.next();
        }
        while(iter.hasPrevious()){

            listnew.add(iter.previous());
        }
        for(int i=0;i<10;i++){

        all2.set(i, listnew.get(i));
        }
        System.out.println(all2);

    }

}
