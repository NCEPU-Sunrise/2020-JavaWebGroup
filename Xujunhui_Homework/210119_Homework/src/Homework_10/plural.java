package Homework_10;

public class plural {
	double real;
	double image;
	public plural(double real,double image) {
		this.real=real;
		this.image=image;
	}
	void add(double m,double n) {
		real+=m;
		image+=n;
	}
	void sub(double m,double n) {
		real-=m;
		image-=n;
	}
	void mul(double m,double n) {
		double newreal = real*m - image*n;
		image = real*n + image*m;
		real = newreal;
	}
	void div(double m,double n) {
		double newreal=(real*m+image*n)/(m*m+n*n);
		double newimage=(image*m-real*n)/(m*m+n*n);
		real=newreal;
		image=newimage;
	}
	void print() {
		if(image > 0){
			System.out.println(real + " + " + image + "i");
		}else if(image < 0){
			System.out.println(real + "" + image + "i");
		}else{
			System.out.println(real);
		}
	}
}
