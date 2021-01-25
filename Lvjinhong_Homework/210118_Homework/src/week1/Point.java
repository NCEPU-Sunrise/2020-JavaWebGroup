//作业8:定义一个点类表示三维空间的点
package week1;

public class Point {
    private float x;
    private float y;
    private float z;

    public Point() {}

    public Point(float x,float y,float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void setPoint(float x,float y,float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float distanceSquared(){
        return x * x + y * y + z * z;
    }
}
