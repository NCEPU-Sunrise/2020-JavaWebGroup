package Homework_10;

public class IllegalArgumentException extends Exception{
	IllegalArgumentException(){
		super("输入的三条边不能构成三角形");
	}
}
