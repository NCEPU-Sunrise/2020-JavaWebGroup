package homework_one;

public class Player {
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
