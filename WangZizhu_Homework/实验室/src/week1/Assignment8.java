package week1;

class Point {
	private int x;
	private int y;
	private int z;
	
	public Point(int x, int y, int z) {
		// TODO Auto-generated constructor stub
		this.setX(x);
		this.setY(y);
		this.setZ(z);
	}
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * @return the z
	 */
	public int getZ() {
		return z;
	}
	/**
	 * @param z the z to set
	 */
	public void setZ(int z) {
		this.z = z;
	}
	public int distance(int x, int y, int z) {
		int dis2 = x*x+y*y+z*z;
		return dis2;
	}
}
public class Assignment8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point point1 = new Point(4,5,6);
		System.out.println(point1.distance(4,5,6));
	}

}
