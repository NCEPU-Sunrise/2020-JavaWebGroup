package week1;

public class PointTest {
    public static void main(String[] args) {
        Point p = new Point(3,4,5);
        System.out.println(p.distanceSquared());
        p.setPoint(1,1,1);
        System.out.println(p.distanceSquared());
    }
}
