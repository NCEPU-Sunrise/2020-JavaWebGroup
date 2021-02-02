package HomeWork_210119;
import java.util.Scanner;

/**
 * дһ��ѡ���࣬�������ѡ�ֵ�����������Լ��÷�(����)��������������ί�������֣���Max������min���������÷ֵķ���ʹ��ͨ���Ե÷�����ļ���ʵ�֡�
 * Test�ฺ�����֣�����һ��ѡ����Ķ������飬ͨ��ѭ������ÿ��ѡ�ֵ���Ϣ�����ɼ���������ͨ���������򣬵���Max,Min,�������յ÷ֵķ�����֮�����ÿ��ѡ��ȥ��һ����߷�*��ȥ��һ����ͷ�*֮������յ÷֡�
 * ���⽫ÿ��ѡ�ֵ����ճɼ�Ҳ������һ����ͨ�����У���������ѡ����Ϣ����������ţ������ճɼ���
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
			System.out.print("�������" + (i + 1) + "ѡ�ֵı�ţ�");
			String id = sc.next();

			System.out.print("�������" + (i + 1) + "ѡ�ֵ�������");
			String name = sc.next();

			System.out.print("�������" + (i + 1) + "ѡ�ֵĳɼ�:(�Կո����):");
			int[] score = new int[5];
			for (int j = 0; j < score.length; j++) {
				score[j] = sc.nextInt();
			}
			players[i] = new Player(name, id, score);
			System.out.println("ȥ��һ����߷֣�" + players[i].max() + ", ȥ��һ����ͷ֣�" + players[i].min() + "��" + players[i].id
					+ "��ѡ��" + players[i].name + "���յ÷֣�" + players[i].finalScore());

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
			System.out.println(players[i].id + "��ѡ��" + players[i].name + "���յ÷֣�" + players[i].finalScore());
		}

	}

}
