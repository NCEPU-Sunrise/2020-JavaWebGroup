package week1;

class Complex {
	private float real;
	private float imaginary;
	public Complex(float imaginary, float real) {
		// TODO Auto-generated constructor stub
		this.imaginary = imaginary;
		this.real = real;
	}
	public Complex(float real) {
		// TODO Auto-generated constructor stub
		this(0, real);
	}
	public Complex() {
		this(0, 0);
	}
	/**
	 * @return the real
	 */
	public float getReal() {
		return real;
	}

	/**
	 * @param real the real to set
	 */
	public void setReal(float real) {
		this.real = real;
	}

	/**
	 * @return the imaginary
	 */
	public float getImaginary() {
		return imaginary;
	}

	/**
	 * @param imaginary the imaginary to set
	 */
	public void setImaginary(float imaginary) {
		this.imaginary = imaginary;
	}

	public Complex add(Complex x) {
		float newimaginary = this.imaginary+x.getImaginary();
		float newreal = this.real+x.getReal();
		return new Complex(newimaginary, newreal);
		
	}
	public Complex subtract(Complex x) {
		float newimaginary = this.imaginary-x.getImaginary();
		float newreal = this.real-x.getReal();
		return new Complex(newimaginary, newreal);
		
	}
	public String toString() {
		if(this.imaginary>=0)
			return "("+this.real+"+"+this.imaginary+"i"+")";
		else
			return "("+this.real+this.imaginary+"i"+")";
	}
}
public class Assignment10 {
	public static void main(String[] args) {
		Complex a = new Complex(1, -2);
		Complex b = new Complex(3);
		Complex c = a.add(b);
		System.out.println(a+"+"+b+"="+c);
	}
}
