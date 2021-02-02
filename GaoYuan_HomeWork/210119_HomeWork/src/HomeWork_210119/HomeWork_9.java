package HomeWork_210119;
import java.util.Scanner;

/**
 * 写一个选手类，里面包括选手的姓名，编号以及得分(数组)（里面包括多个评委给的评分），Max方法，min方法，最后得分的方法使用通过对得分数组的计算实现。
 * Test类负责评分，创建一个选手类的对象数组，通过循环输入每个选手的信息，将成绩保存在普通数组中排序，调用Max,Min,计算最终得分的方法，之后输出每个选手去掉一个最高分*，去掉一个最低分*之后的最终得分。
 * 另外将每个选手的最终成绩也保存在一个普通数组中，最后输出，选手信息（姓名，编号）和最终成绩。
 */
class Player {
	String name;
	String id;
	int[] score;

	public Player(String name, String id, int[] score) {
		this.name = name;
		this.id = id;
		this.score = score;
	}

	public Player() {
	}

	int max() {
		int max = score[0];
		for (int i = 0; i < score.length; i++) {
			if (score[i] > max)
				max = score[i];
		}
		return max;
	}

	int min() {
		int min = score[0];
		for (int i = 0; i < score.length; i++) {
			if (score[i] < min)
				min = score[i];
		}
		return min;
	}

	float finalScore() {
		int finalScore = 0;
		for (int i = 0; i < score.length; i++) {
			finalScore += score[i];
		}
		finalScore = finalScore - max() - min();
		return finalScore / (score.length - 2);
	}

}

public class HomeWork_9 {

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
