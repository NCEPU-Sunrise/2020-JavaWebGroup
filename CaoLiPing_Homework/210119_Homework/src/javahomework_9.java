import java.util.Arrays;
import java.util.Scanner;

class xuanshou{
    String name;
    String number;
    float score[]=new float[5];
    xuanshou(){

    }
    void setname(String name){
        this.name=name;
    }
    String getname(){
        return this.name;
    }
    String getNumber(){
        return this.number;
    }
    void setNumber(String number){
        this.number=number;
    }
    static float max(float score[]) {
        float maxmax = 0;
        for (int i = 0; i < score.length; i++) {
            if (maxmax < score[i]) {
                maxmax = score[i];
            }
        }
        return maxmax;

    }
    static float min(float score[]) {
        float minmin= 1000;
        for (int i = 0; i < score.length; i++) {
            if (minmin > score[i]) {
                minmin= score[i];
            }
        }
        return minmin;

    }
    static float zscore(float score[]){
        float allscore=0;
        for(int i=0;i<score.length;i++){
            allscore+=score[i];
        }
        allscore-=min(score);
        allscore-=max(score);
        return allscore/(score.length-2);
    }


}

public class javahomework_9 {
    public static void main(String[] args) {
        xuanshou no = new xuanshou();
        xuanshou name = new xuanshou();
        Scanner sc = new Scanner(System.in);
        float score[] = new float[5];
        float p[]=new float[2];
        for (int i = 0; i < 2; i++) {
            System.out.println("请输入第" + (i + 1) + "选手的编号：");

            String s = sc.next();
            no.setNumber(s);
            System.out.println("请输入第" + (i + 1) + "选手的姓名：");

            String n = sc.next();
            name.setname(n);
            System.out.println("请输入第" + (i + 1) + "选手的成绩:");
            for (int j = 0; j < score.length; j++) {
                score[j] = sc.nextFloat();
            }
            p[i]=xuanshou.zscore(score);
            System.out.println(xuanshou.max(score)+"+"+xuanshou.min(score)+"+"+xuanshou.zscore(score));

        }
        Arrays.sort(p);
        for(int i=0;i<2;i++){
        System.out.println(p[i]);
        }


    }
}