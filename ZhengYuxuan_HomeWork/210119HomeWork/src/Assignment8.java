public class Assignment8 {
    public static void main(String[] args) {
        Point a = new Point();
        a.x = 1.2;
        a.y = 2.4;
        a.z = 3.6;
        Point b = new Point(1.1,2.0,3.5);
        Point c = new Point();
        c.setPoint(1.3,2.6,3.9);
        System.out.println("坐标为：（" + a.x + "，" + a.y +"，"+ a.z + "）距离原点距离的平方为：" + a.getDistance());
        System.out.println("坐标为：（" + b.x + "，" + b.y +"，"+ b.z + "）距离原点距离的平方为：" + b.getDistance());
        System.out.println("坐标为：（" + c.x + "，" + c.y +"，"+ c.z + "）距离原点距离的平方为：" + c.getDistance());
    }
}
class Point {
    double x, y, z;

    public Point() {

    }

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void setPoint(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getDistance() {
        return x * x + y * y + z * z;
    }
}