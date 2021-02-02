public class Cat {

    static int sid = 0;//被static修饰的静态变量 所有猫共享一个
    String name; //名字 每个猫不同
    int id;//身份证号 每个猫不同
    
    Cat(String name) {
        this.name = name;  
        this.id = sid++;
    }
    
    public void info(){
        System.out.println
               ("My name is "+this.name+" No."+this.id);
    }
    
    public static void main(String arg[]){
    	//静态变量是类级别的变量 存放于静态区 
        Cat.sid = 100;
        
        //创建对象mimi
        Cat mimi = new Cat("mimi");
        
        mimi.sid = 2000;
        System.out.println(Cat.sid);
        Cat pipi = new Cat("pipi");
        
        mimi.info();  //My name is mimi No.100
        pipi.info();  //My name is pipi No.2000
    }
}