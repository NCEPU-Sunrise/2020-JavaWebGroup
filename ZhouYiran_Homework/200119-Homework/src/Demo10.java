public class Demo10 {
    public static void main(String[] args) {
        Complex complex1 = new Complex(8.0,9.0);
        Complex complex2 = new Complex(7.0);
        complex1.add(complex2);
        complex1.minus(complex2);
        complex1.multi(complex2);
    }
}
class Complex{
    double real;
    double imag;
    Complex(double real,double image){
        this.real = real;
        this.imag = image;
    }
    Complex(double real){
        this.real = real;
        this.imag = 0;
    }
    public void add(Complex com){
        double areal;
        double aimag;
        areal = this.real + com.real;
        aimag = this.imag + com.imag;
        if(aimag != 0){
            System.out.println("+ ：" + areal + "+" + aimag +"i");
        }
        else
            System.out.println("+ ：" + areal + "+" + aimag );

    }
    public void minus(Complex com){
        double areal;
        double aimag;
        areal = this.real - com.real;
        aimag = this.imag - com.imag;
        if(aimag != 0){
            System.out.println("- ：" + areal + "+" + aimag +"i");
        }
        else
            System.out.println("- ：" + areal + "+" + aimag );

    }
    public void multi(Complex com){
        double areal;
        double aimag;
        areal = this.real * com.real - this.imag * com.imag;
        aimag = this.real * com.imag + this.imag * com.real;
        if(aimag != 0){
            System.out.println("* ：" + areal + "+" + aimag +"i");
        }
        else
            System.out.println("* ：" + areal + "+" + aimag );
    }

}