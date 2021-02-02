//父类
class SuperClass {
    private int n;
    //无参构造
    SuperClass() {
        System.out.println("SuperClass()");
    }
    //有参构造
    SuperClass(int n) {
        System.out.println("SuperClass(" + n + ")");
        this.n = n;
    }
}
//子类
class SubClass extends SuperClass {
    private int n;
    //有参构造
    SubClass(int n) {
    	//调用父类的无参构造 可省略 ,系统自动调用
        //super();  
        System.out.println("SubClass(" + n + ")");
        this.n = n;
    }
    //无参构造
    SubClass() {
    	//调用父类的有参构造
    	super(300);
        System.out.println("SubClass()");
    }
}

public class TestSuperSub {
    public static void main(String arg[]) {
        SubClass sc1 = new SubClass();
        System.out.println("-----------");
        SubClass sc2 = new SubClass(400);
    }
}