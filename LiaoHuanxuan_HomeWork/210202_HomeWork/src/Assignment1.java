import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Xnhyacinth
 * @date 2021/2/28 - 23:00
 */
public class Assignment1 {
    public static void main(String[] args) {
        ArrayList<String> poker = new ArrayList<String>();
        String[] colors = {"♠", "♥", "♦", "♣"};
        String[] numbers = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        FightAgainstLandlord fight = new FightAgainstLandlord(poker, colors, numbers);

        ArrayList<String> pokers = fight.fiftyfive();

        ArrayList<String> player1 = fight.licensing(1, pokers);
        ArrayList<String> player2 = fight.licensing(2, pokers);
        ArrayList<String> player3 = fight.licensing(3, pokers);
        ArrayList<String> basepoker = fight.licensing(4, pokers);

        System.out.println("player1：" + player1);
        System.out.println("player2：" + player2);
        System.out.println("player3：" + player3);
        System.out.println("basepoker：" + basepoker);
    }
}

class FightAgainstLandlord {
    private ArrayList<String> poker;
    private String[] colors;
    private String[] numbers;

    public FightAgainstLandlord(ArrayList<String> poker, String[] colors, String[] numbers) {
        this.poker = poker;
        this.colors = colors;
        this.numbers = numbers;
    }

    public ArrayList<String> fiftyfive() {
        for (String color : colors) {
            for (String number : numbers) {
                poker.add(color + number);
            }
        }
        poker.add("大王");
        poker.add("小王");
        Collections.shuffle(poker);
        return poker;
    }

    public ArrayList<String> licensing(int k, ArrayList<String> poker) {
        ArrayList<String> player1 = new ArrayList<String>();
        ArrayList<String> player2 = new ArrayList<String>();
        ArrayList<String> player3 = new ArrayList<String>();
        ArrayList<String> basepoker = new ArrayList<String>();

        for (int i = 0; i < poker.size(); i++) {
            String card = poker.get(i);
            if (i < 51) {
                if (i % 3 == 0) {
                    player1.add(card);
                } else if (i % 3 == 1) {
                    player2.add(card);
                } else {
                    player3.add(card);
                }
            } else {
                basepoker.add(card);
            }
        }

        if (k == 1) {
            return player1;
        } else if (k == 2) {
            return player2;
        } else if (k == 3) {
            return player3;
        } else {
            return basepoker;
        }
    }
}
