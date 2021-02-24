package week1;

import java.util.Arrays;
import java.util.Scanner;


class Player {
	String name;
	int num;
	float[] score;

	public Player(String name, int num, float[] score) {
		this.name = name;
		this.num = num;
		this.score = score;
	}
	public static float max(float[] score) {
		Arrays.sort(score);
		System.out.println(score[score.length-1]);
		return 1;
		
	}
	public static float min(float[] score) {
		Arrays.sort(score);
		System.out.println(score[0]);
		return 1;
	}
	public float finalScore(float[] s) {
		float sumscore = 0;
		s[s.length-1] = 0;
		s[0] = 0;
		for(int i = 0; i<s.length; i++) {
			sumscore+=s[i];
			System.out.println(s[i]);
		}
		float finalscore = sumscore/(s.length-2);
		return finalscore;
		
	}
}
public class Assignment9 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Player[] x = new Player[5];
		float[] finalscorelist = new float[5];

		for(int i=0;i<5;i++) {
			System.out.println("输入选手姓名：");
			String name = sc.next();
			System.out.println("输入选手得分：");
			float[] pscore = new float[3];//注意位置和起名
			for(int j=0;j<3;j++) {
				pscore[j]= sc.nextFloat();
			}
			Arrays.sort(pscore);
			x[i] = new Player(name, i+1, pscore);
		}
		System.out.println("输出最终选手得分：");
		for(int i=0;i<5;i++) {
			finalscorelist[i]=x[i].finalScore(x[i].score);
			System.out.println(x[i].num+"号选手"+x[i].name+"最终得分"+finalscorelist[i]);
		}
		System.out.println("输出最终选手最高分：");
		Player.max(finalscorelist);
		System.out.println("输出最终选手最低分：");
		Player.min(finalscorelist);
		sc.close();
	}

}
