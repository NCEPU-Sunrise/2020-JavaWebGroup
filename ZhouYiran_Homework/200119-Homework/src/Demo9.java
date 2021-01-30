import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

class Demo9 {
    public static void main(String[] args) {
        Player [] players = new Player[3];
        double [] score = new double [4];//存放选手成绩
        double Fscore[] = new double[3];//存放总成绩
        int i = 0;
        int j = 0;
        String name;
        String number;
        Scanner sc = new Scanner(System.in);
        for(i = 0;i < players.length;i++){
            System.out.println("请输入第" + (i+1) +"位选手的姓名：");
            name = sc.next();
            System.out.println("请输入第" + (i+1) +"位选手的编号：");
            number = sc.next();
            players[i] = new Player();
            players[i].set(name,number);
            System .out.println("请输入第" + (i+1) +"位选手的成绩：");
            for(j = 0;j < 4;j++) {
                score[j] = sc.nextDouble();
            }
           Fscore[i] = players[i].finalscore(score);
            System.out.println(players[i].name +"的成绩去掉一个最高分："+ players[i].max(score)+ "分，去掉一个最低分："+players[i].min(score)
                                                                                                   +"分，最后总成绩为"+Fscore[i]+"分");
        }
        Arrays.sort(Fscore);
        System.out.println("最终成绩排序为:");
        for(i = Fscore.length-1;i >= 0;i--){
            System.out.println(Fscore[i]);
        }
    }
}
class  Player{
    String name;
    String number;
    double[] score;
    public void set(String name,String number){
        this.name = name;
        this.number = number;
    }
    public double max (double score[]){
        int i = 0;
        int maxindex = 0;
        for(i = 0;i < score.length ;i++){
            if(score[maxindex] < score[i]){
                maxindex = i;
            }
        }
        return score[maxindex];

    }
    public double min (double[] score){
        int i = 0;
        int minindex = 0;
        for(i = 0;i < score.length ;i++){
            if(score[minindex] > score[i]){
                minindex = i;
            }
        }
        return score[minindex];
    }
    public double finalscore(double[] score){
        int i = 0;
        double sum = 0;
        for(i = 0 ;i < score.length;i++)
            sum += score[i];
        sum = sum + min(score) - max(score);
        return sum;
    }
}