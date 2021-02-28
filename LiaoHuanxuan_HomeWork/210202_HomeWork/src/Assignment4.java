import java.util.Scanner;

/**
 * @author Xnhyacinth
 * @date 2021/2/28 - 22:13
 */
public class Assignment4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        Test ts = new Test();
        ts.triangle(a, b, c);
    }
}
class Test {
    void triangle(int a, int b, int c) {
        try {
            if (a > 0 && b > 0 && c > 0) {
                if ((a + b > c && a - b < c) && (a + c > b && a - c < b) && (b + c > a && b - c < a)) {
                    System.out.println("能构成三角形");
                    int circumference = a + b + c;
                    int area = a * b * c;
                    System.out.println("周长为：" + circumference + "\n" + "面积为：" + area);
                } else throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        } catch (Exception e) {
        }
    }
}

class IllegalArgumentException extends Exception {
    public IllegalArgumentException() {
        super("不能构成三角形");
    }
}
