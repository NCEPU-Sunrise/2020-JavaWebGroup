import java.text.DecimalFormat;

class Demo8 {
     public static void main(String[] args) {
         Point point = new Point(2.0,5.0,6.0);
         point.setX(3.0);
         point.setY(6.0);
         point.setZ(9.0);
         Point.distance(point);
     }
}
class Point{
    double x;
    double y;
    double z;
    Point(double x,double y,double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public void setX(double x) {
        this.x = x;
        System.out.println("设置成功！" + "当前坐标为(" + x
                + "," + this.y + "," + this.z + ")");
    }
    public void setY(double y){
        this.y = y;
        System.out.println("设置成功！" + "当前坐标为(" + this.x
                               + "," + y + "," + this.z + ")");
    }
    public void setZ(double z) {
        this.z = z;
        System.out.println("设置成功！" + "当前坐标为(" + this.x
                                     + "," + this.y + "," + z+")");
    }
    public static void distance(Point p){
        DecimalFormat df = new DecimalFormat("#0.00");
        double dist = Math.sqrt(Math.pow(p.x, 2)+Math.pow(p.y,2)+Math.pow(p.z,2));
        System.out.println("该点距离原点的距离为" + df.format(dist));
    }



}
