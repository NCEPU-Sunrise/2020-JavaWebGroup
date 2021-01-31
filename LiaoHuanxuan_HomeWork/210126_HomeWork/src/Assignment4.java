import java.util.Scanner;

/**
 * @author Xnhyacinth
 * @date 2021/1/31 - 19:43
 */
public class Assignment4 {
    public interface menu {
        int getPrice();
    }

    public enum pre_food implements menu {
        salad(25), soup(15), spring_rolls(30);
        private final int price;

        pre_food(int price) {
            this.price = price;
        }

        public int getPrice() {
            return price;
        }
    }

    public enum main_food implements menu {
        lasagne(35), burrito(40), pad_thai(38), lentils(45);
        private final int price;

        main_food(int price) {
            this.price = price;
        }

        public int getPrice() {
            return price;
        }
    }

    public enum dessert implements menu {
        black_forest_cake(28), fruit(33);
        private final int price;

        dessert(int price) {
            this.price = price;
        }

        public int getPrice() {
            return price;
        }
    }

    public static void main(String[] args) {
        int sum_p = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请选择前菜：1.salad(25), 2.soup(15), 3.spring_rolls(30)");
        switch (sc.nextInt()) {
            case 1:
                sum_p = sum_p + 25;
                break;
            case 2:
                sum_p = sum_p + 15;
                break;
            case 3:
                sum_p = sum_p + 30;
                break;
            default:
                System.out.println("请输入数字1-3：");
        }
        System.out.println("请选择主菜：1.lasagne(35), 2.burrito(40),3. pad_thai(38),4.lentils(45)");
        switch (sc.nextInt()) {
            case 1:
                sum_p = sum_p + 35;
                break;
            case 2:
                sum_p = sum_p + 40;
                break;
            case 3:
                sum_p = sum_p + 38;
                break;
            case 4:
                sum_p = sum_p + 45;
                break;
            default:
                System.out.println("请输入数字1-4：");
        }
        System.out.println("请选择甜点：1. black_forest_cake(28), fruit(33)");
        switch (sc.nextInt()) {
            case 1:
                sum_p = sum_p + 28;
                break;
            case 2:
                sum_p = sum_p + 33;
                break;
            default:
                System.out.println("请输入数字1-2：");
        }
        System.out.println("总消费：" + sum_p + "元");
    }
}
