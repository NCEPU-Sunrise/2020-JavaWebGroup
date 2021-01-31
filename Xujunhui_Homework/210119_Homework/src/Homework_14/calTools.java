package Homework_14;

abstract class calTools {
	static double pai=3.14;
	static double V_Ball(double r){
		double v=4*pai*r*r*r/3;
		return v;
	}
	static double V_cylinder(double r,double h){
		double v=pai*r*r*h;
		return v;
	}
	static double V_cone(double r,double h){
		double v=pai*r*r*h/3;
		return v;
	}
	static double S_Ball(double r){
		double s=4*pai*r*r;
		return s;
	}
	static double S_cylinder(double r,double h){
		double s=2*pai*r*h+2*pai*r*r;
		return s;
	}
	static double S_cone(double r,double h){
		double s,l;//l为母线长度
		l=Math.sqrt(r*r+h*h);
		s=pai*r*l+pai*r*r;
		return s;
	}
}
