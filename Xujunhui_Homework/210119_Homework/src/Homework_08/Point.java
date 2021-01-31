package Homework_08;
import java.util.*;
public class Point {
	float X,Y,Z;
	Point(float x,float y,float z){
		X=x;
		Y=y;
		Z=z;
	}
	void Reset() {
		System.out.println("重新设置坐标\n原坐标:("+X+","+Y+","+Z+")请分别输入三个坐标：");
		Scanner sc=new Scanner(System.in);
		X=sc.nextFloat();
		Y=sc.nextFloat();
		Z=sc.nextFloat();
		System.out.println("新坐标:("+X+","+Y+","+Z+")");
	}
	void Distance() {
		float d=X*X+Y*Y+Z*Z;
		System.out.println("该点距原点距离的平方为："+d);
	}
}
