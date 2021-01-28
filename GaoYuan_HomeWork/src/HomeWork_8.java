/**
 * 定义一个“点”(Point）类用来表示三维空间中的点（有三个坐标)）。要求如下:
 * 1）可以生成具有特定坐标的点对象。
 * 2）提供可以设置三个坐标的方法。
 * 3）提供可以计算该“点”距原点距离平方的方法。
 * 4）编写程序验证上述三条。
 * */

class Point {
	private double x, y, z;

	public Point(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

	public double distance() {
		return Math.sqrt(x * x + y * y + z * z);
	}

	public String toString() {
		return "当前坐标为 (" + x + "," + y + "," + z + ")";
	}
}

public class HomeWork_8 {

	public static void main(String[] args) {
		Point point = new Point(1, 2, 3);
		System.out.println(point);
		point.setX(3);
		point.setY(4);
		point.setZ(5);
		System.out.println(point);
		System.out.println("到原点的距离为：" + point.distance());
	}

}
