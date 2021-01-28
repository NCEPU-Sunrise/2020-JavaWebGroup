/*完成两个复数的运算(构造方法的重载)*/

class Complex {
	private double real, im; // 实部，虚部

	public Complex(double real, double im) // 构造方法
	{
		this.real = real;
		this.im = im;
	}

	public Complex(double real) // 构造方法重载
	{
		this(real, 0);
	}

	public Complex() {
		this(0, 0);
	}

	public Complex(Complex c) // 拷贝构造方法
	{
		this(c.real, c.im);
	}

	public boolean equals(Complex c) // 比较两个对象是否相等
	{
		return this.real == c.real && this.im == c.im;
	}

	public String toString() {
		return "(" + this.real + "+" + this.im + "i)";
	}

	public void add(Complex c) // 两个对象相加
	{ // 改变当前对象，没有返回新对象
		this.real += c.real;
		this.im += c.im;
	}

	public Complex plus(Complex c) // 两个对象相加，与add()方法参数一样不能重载
	{ // 返回新创建对象，没有改变当前对象
		return new Complex(this.real + c.real, this.im + c.im);
	}

	public void subtract(Complex c) // 两个对象相减
	{ // 改变当前对象，没有返回新对象
		this.real -= c.real;
		this.im -= c.im;
	}

	public Complex minus(Complex c) // 两个对象相减，与subtract()方法参数一样不能重载
	{ // 返回新创建的对象，没有改变当前对象
		return new Complex(this.real - c.real, this.im - c.im);
	}
}

public class HomeWork_10 {

	public static void main(String[] args) {
		Complex a = new Complex(1, 2);
		Complex b = new Complex(3);
		Complex c = a.plus(b); // 返回新创建对象
		System.out.println(a + " + " + b + " = " + c);
	}

}
