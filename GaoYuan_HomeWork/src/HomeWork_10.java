/*�����������������(���췽��������)*/

class Complex {
	private double real, im; // ʵ�����鲿

	public Complex(double real, double im) // ���췽��
	{
		this.real = real;
		this.im = im;
	}

	public Complex(double real) // ���췽������
	{
		this(real, 0);
	}

	public Complex() {
		this(0, 0);
	}

	public Complex(Complex c) // �������췽��
	{
		this(c.real, c.im);
	}

	public boolean equals(Complex c) // �Ƚ����������Ƿ����
	{
		return this.real == c.real && this.im == c.im;
	}

	public String toString() {
		return "(" + this.real + "+" + this.im + "i)";
	}

	public void add(Complex c) // �����������
	{ // �ı䵱ǰ����û�з����¶���
		this.real += c.real;
		this.im += c.im;
	}

	public Complex plus(Complex c) // ����������ӣ���add()��������һ����������
	{ // �����´�������û�иı䵱ǰ����
		return new Complex(this.real + c.real, this.im + c.im);
	}

	public void subtract(Complex c) // �����������
	{ // �ı䵱ǰ����û�з����¶���
		this.real -= c.real;
		this.im -= c.im;
	}

	public Complex minus(Complex c) // ���������������subtract()��������һ����������
	{ // �����´����Ķ���û�иı䵱ǰ����
		return new Complex(this.real - c.real, this.im - c.im);
	}
}

public class HomeWork_10 {

	public static void main(String[] args) {
		Complex a = new Complex(1, 2);
		Complex b = new Complex(3);
		Complex c = a.plus(b); // �����´�������
		System.out.println(a + " + " + b + " = " + c);
	}

}
