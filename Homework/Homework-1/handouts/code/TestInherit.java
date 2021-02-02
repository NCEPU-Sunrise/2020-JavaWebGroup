class FatherClass {
    //成员变量
    public int value;
    //成员方法
    public void f(){
        value = 100;
        System.out.println("FatherClass.value="+value);
    }
}
class ChildClass extends FatherClass {
    //成员变量
    public int value;
    //成员方法 重写了父类方法
    public void f() {
        //调用父类的f()
        super.f();
        //补充自己的f()
        value = 200;
        System.out.println("ChildClass.value="+value);
        System.out.println(value);
        System.out.println(super.value);
    }
}


public class TestInherit {
    public static void main(String[] args) {
        //创建子类 cc存在于栈空间 new ChildClass()位于堆空间
        ChildClass cc = new ChildClass();
        cc.f();
    }
}