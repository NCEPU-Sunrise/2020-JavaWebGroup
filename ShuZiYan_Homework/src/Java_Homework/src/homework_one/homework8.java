package homework_one;

import java.util.Scanner;

public class homework8 {
    public static void main(String[] args) {
        Player[] players = new Player[4];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < players.length; i++) {
            System.out.print("请输入第" + (i + 1) + "选手的编号：");
            String id = sc.next();
            System.out.print("请输入第" + (i + 1) + "选手的姓名：");
            String name = sc.next();
            System.out.print("请输入第" + (i + 1) + "选手的成绩:(以空格隔开):");
            int[] score = new int[5];
            for (int j = 0; j < score.length; j++) {
                score[j] = sc.nextInt();
            }
            players[i] = new Player(name, id, score);
            System.out.println("去掉一个最高分：" + players[i].max() + ", 去掉一个最低分：" + players[i].min() + "，" + players[i].id
                    + "号选手" + players[i].name + "最终得分：" + players[i].finalScore());
            // sumScore[i] = players[i].finalScore();
        }
        for (int i = 0; i < players.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < players.length; j++) {
                if (players[j].finalScore() < players[min].finalScore()) {
                    min = j;
                }
            }
            Player tmp = new Player();
            if (i != min) {
                tmp = players[i];
                players[i] = players[min];
                players[min] = tmp;
            }
        }
        for (int i = 0; i < players.length; i++) {
            System.out.println(players[i].id + "号选手" + players[i].name + "最终得分：" + players[i].finalScore());
        }
    }
}
