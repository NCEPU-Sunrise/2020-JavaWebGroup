class Animal {
    String name ;
    Animal (String name){
        this.name = name ;
    }
    
}
class Cat extends Animal {
    String eyesColor ;
    Cat (String name , String color){
        super(name) ; 
        eyesColor = color;
    }
}
class Dog extends Animal {
    String furCo1or;
    Dog (String name , String color){
        super(name); 
        furCo1or = color;
    }
}

public class Test {
    public static void main (String args[]){
        Animal a = new Animal("name" ) ;
        Cat c = new Cat ( "catname" , "blue") ;
        Dog d = new Dog ( "dogname" , "black" ) ;

        System.out.println(a instanceof Animal) ;// true
        System.out.println(c instanceof Animal) ;//true
        System.out.println (d instanceof Animal);// true
        System.out.println (a instanceof Cat) ;//false

        //向下转型
        a = new Dog ( "bigyellow" , "yellow ");
        System.out.println (a.name) ;//bigyellow
        //当我们的dog是由Animal作为引用的时候，对于程序来说，这只dog就是Animal,狗类独有的方法和属性，系统看不到，我们也无法使用。
        //-->picture-对象转型内存分析
        System.out.println (a.furname) ;//! error
        System.out.println(a instanceof Animal) ;//true
        //如果我们非要使用Dog的方法，我们需要（使用 instanceof 关键字)判断当前对象是否为Dog类型,确保向下转型的安全性
        //如果是，就将当前对象a向下转型：Dog d1 = (Dog)a;
        System.out.println(a instanceof Dog) ; //true
        Dog d1 =(Dog) a ; //要加强制转换符
        System.out.println(d1.furCo1or) ; //yellow

    }
}