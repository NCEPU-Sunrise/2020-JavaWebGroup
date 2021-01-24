//作业10:完成两个复数的运算(构造方法的重载)
package week1;

public class complex {
    private double realNumber;      //实数
    private double imaginaryNumber; //虚数

    public complex() {
        this(0.0,0.0);
    }

    public complex(double realNumber){
        this(realNumber,0.0);
    }

    public complex(double realNumber,double imaginaryNumber){
        this.realNumber = realNumber;
        this.imaginaryNumber = imaginaryNumber;
    }

    public complex(complex c){
        this(c.realNumber, c.imaginaryNumber);
    }



    public double getRealNumber() {
        return realNumber;
    }

    public double getImaginaryNumber() {
        return imaginaryNumber;
    }

    //四则运算
    public void plus(complex c){
        this.realNumber += c.getRealNumber();
        this.imaginaryNumber += c.getImaginaryNumber();
    }

    public void minus(complex c){
        this.realNumber -= c.getRealNumber();
        this.imaginaryNumber -= c.getImaginaryNumber();
    }

    public void times(complex c){
        //(a+bi)(c+di)=(ac-bd)+(bc+ad)i
        this.realNumber = this.realNumber * c.realNumber - this.imaginaryNumber * c.imaginaryNumber;
        this.imaginaryNumber = this.imaginaryNumber * c.realNumber + this.realNumber * c.imaginaryNumber;
    }

    public void devided(complex c){
        //(a+bi)/(c+di)=(ac+bd)/(c^2+d^2) +((bc-ad)/(c^2+d^2))i （c != 0 || d != 0）
        if(c.realNumber == 0 && c.imaginaryNumber == 0)return;
        this.realNumber = (this.realNumber * c.realNumber + this.imaginaryNumber * c.imaginaryNumber)/
                (c.realNumber * c.realNumber + c.imaginaryNumber * c.imaginaryNumber);
        this.imaginaryNumber = (this.imaginaryNumber * c.realNumber - this.realNumber * c.imaginaryNumber)/
                (c.realNumber * c.realNumber + c.imaginaryNumber * c.imaginaryNumber);
    }
}
