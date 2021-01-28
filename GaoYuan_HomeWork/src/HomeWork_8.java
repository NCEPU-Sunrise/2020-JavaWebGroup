/**
 * ����һ�����㡱(Point����������ʾ��ά�ռ��еĵ㣨����������)����Ҫ������:
 * 1���������ɾ����ض�����ĵ����
 * 2���ṩ����������������ķ�����
 * 3���ṩ���Լ���á��㡱��ԭ�����ƽ���ķ�����
 * 4����д������֤����������
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
		return "��ǰ����Ϊ (" + x + "," + y + "," + z + ")";
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
		System.out.println("��ԭ��ľ���Ϊ��" + point.distance());
	}

}
