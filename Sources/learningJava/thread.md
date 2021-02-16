# 线程

### 同步&异步&同步阻塞&异步阻塞

* 同步异步关注的是消息通信机制

    例子：
    一个人要烧开一壶水，有很多种方式    
    
    这个人开火烧水，还得这个人本人监督着直到水烧开，这是同步   
    
    这个人把水放在水上烧，水烧开后不一定由这个人处理，这叫异步

* 阻塞非阻塞关注的是等待消息时的状态

    例子：
    这个人在等水烧开的过程中什么事情都不干，就等着水开，这叫阻塞
    
    如果这个人还去做其他的事情这就是非阻塞
    
同步异步，阻塞非阻塞的不同在于他们对信息的关注点不同

* 同步阻塞

    一个人烧水，在水烧开之前，他一直在旁边等着，什么时候水烧开了他才进行下一步的操作
    
* 同步非阻塞

    一个人烧水，在水放到火上后，他就去做其他事情，但是水开之后还是由这个人处理

* 异步阻塞

    一个人烧水，**给烧水壶设置了一个铃，水开后铃就会响**，他等铃响之后才能做其他事情。这种情况十分少见。
    
* 异步阻塞
    
    一个人烧水，开火之后设置好水开的处理程序，不由他自己处理。异步非阻塞是经常用到的。
   

### 线程

1.线程的基本概念

* 线程是一个程序内部的顺序控制流。

* 线程和进程的区别
    - 每个进程都有独立的代码和数据空间，进程间切换会有较大的开销。
    - 线程可以看成轻量级的进程，同一类线程共享代码和数据空间，每个线程有独立的运行栈和程序计数器（PC）,线程切换的开销小。
    - 多进程：在操作系统中可以同时运行多个任务（程序）
    - 多线程：在同一个应用程序中有多个顺序流同时执行

* Java是通过java.lang.Thread类实现的

* JVM启动时会有一个由主方法（public static void main(){}）所定义的线程

* 可以用一句话来总结： 线程是一个程序里面不同的执行路径

2.线程的创建和启动

* 方式一：继承Thread类
    - 定义一个Thread的子类并重写其run方法，如：
        ```Java
        class MyThread extends Thread{
            public void run(){ ... }
        }
        ```
        run方法内写要执行的代码
        
    - 生成该类的对象
        `MyThread myThread = new MyThread(...)`
    - 通过调用Thread类的start()方法来启动一个线程
    
    ```java
    class MyThread extends Thread{
  
	    public void run() {
		    for(int i = 1;i<=100;i+=2) {
			    System.out.println("奇数："+i);
		    }
	    }
  
    }
    public class NumberThread {

        public static void main(String[] args) {
		    MyThread myThread = new MyThread()
		    myThread.start();
	    }

    }
    ```
* 方式二：实现Runnable接口
    - 定义线程类实现Runnable接口
    - Runnable中只有一个方法: public void run ();用以定义线程运行体。
    - 创建线程体对象 
    - 创建线程对象Thread myThrea=new Thead (target) ,target为Runnable接口类型.
    - 使用Runnable接口可以为多个线程提供共享的数据。
    - 在实现Runnable接口的类的run方法定义中可以使用Thread的静态方法:public static Thread currentThread()获取当前线程的引用。

    ```java
    class MyThread implements Runnable{
	
	        public void  run() {
		        for(int i = 1;i<=100;i+=2) {
			        System.out.println("奇数："+i);
		        }
	        }
    }

    public class NumberThread {

        public static void main(String[] args) {
		    MyThread myThread = new MyThread();    //创建线程体对象  
            Thread t = new Thread(myThread);    //创建线程对象
		    t.start();    //启动线程
	    }

    }
    ```
    
3.线程状态转换  

![Alt text](http://m.qpic.cn/psc?/V50n1dGd3Doigx0hCE5i1cHBhY4Ug0Hs/ruAMsa53pVQWN7FLK88i5r1UO7Uqq43o.pl8vfz491ArWwkSJoCqhK0rmL9*FgMXbcCN.sjrwEPW8DnPt9J8vUt2chLM*1givXV4Ie8lkng!/mnull&bo=VQR2AgAAAAADBwc!&rf=photolist&t=5)

* 新建状态（New）：
    用new语句创建的线程处于新建状态，此时它和其他Java对象一样，仅仅在堆区中被分配了内存。
* 就绪状态（Runnable）：
当一个线程对象创建后，其他线程调用它的start()方法，该线程就进入就绪状态，Java虚拟机会为它创建方法调用栈和程序计数器。处于这个状态的线程位于可运行池中，等待获得CPU的使用权。
* 运行状态（Running）：
处于这个状态的线程占用CPU，执行程序代码。只有处于就绪状态的线程才有机会转到运行状态。
* 阻塞状态（Blocked）：
阻塞状态是指线程因为某些原因放弃CPU，暂时停止运行。当线程处于阻塞状态时，Java虚拟机不会给线程分配CPU。直到线程重新进入就绪状态，它才有机会转到运行状态。

    阻塞状态可分为以下3种：

    - 位于对象等待池中的阻塞状态（Blocked in object’s wait pool）：
    当线程处于运行状态时，如果执行了某个对象的wait()方法，Java虚拟机就会把线程放到这个对象的等待池中，这涉及到“线程通信”的内容。
    - 位于对象锁池中的阻塞状态（Blocked in object’s lock pool）：
    当线程处于运行状态时，试图获得某个对象的同步锁时，如果该对象的同步锁已经被其他线程占用，Java虚拟机就会把这个线程放到这个对象的锁池中，这涉及到“线程同步”的内容。
    - 其他阻塞状态（Otherwise Blocked）：
    当前线程执行了sleep()方法，或者调用了其他线程的join()方法，或者发出了I/O请求时，就会进入这个状态。
* 死亡状态（Dead）：
当线程退出run()方法时，就进入死亡状态，该线程结束生命周期。

4.线程控制的基本方法

|方法|功能|
|---|---|
|islive()|判断线程是否还“活”着|
|getPriority()|获取线程的优先级数值|
|setPriority()|设置线程的优先级数值|
|Thread.sleep()|将当前线程睡眠指定毫秒数,静态方法|
|join()|暂停当前线程的执行，等待另一个线程（调用join方法的线程）结束后再执行|
|yield()|让出CPU,当前线程进入就绪队列等待调度，给其他线程执行的机会|
|wait()|当前线程进入对象的wait pool|
|notify()/notifyAll()|唤醒对象的wait pool 中的一个/所有等待线程|

范例1（sleep方法）
```java
import java.util.Date;

public class TeestInterrupt {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        try{
            Thread.sleep(10000);
        } catch (InterruptedException e){}
        thread.interrupt();//打断sleep
        //当打断后，会抛出异常
    }

   static class  MyThread extends  Thread{
        public void run(){
            while (true){
                System.out.println("=="+new Date()+"---");
                try{
                    sleep(1000);
                }catch (InterruptedException e){return;}//return  结束这个线程
            }
        }
   }
}
```

范例2（join方法）
```java
public class TestJoin {
    public static void main(String[] args) {
        MyTherad2 t1 = new MyTherad2("t1");//线程名
        t1.start();
        try{
            //合并t1
            t1.join();
        }//join也会抛出异常，所以用try，catch
       		 catch (InterruptedException e){}
        for (int i =1;i<=10;i++){
            System.out.println("i am main thread");
        }
    }

    static class MyTherad2 extends Thread{
        MyTherad2(String s){
            super (s);
        }
        public void run(){
            for (int i = 1; i <=10 ; i++) {
                System.out.println("i am"+getName());
                try {
                    sleep(1000);//让线程延迟1秒执行
                } catch (InterruptedException e){
                    return;
                }
            }

        }
    }
}

```

范例3(yield方法)
```java
public class TestYield {

    public static void main(String[] args) {
        MyThread3 t1 = new MyThread3("t1");
        MyThread3 t2 =new MyThread3("t2");
        t1.start();
        t2.start();
    }
   static class MyThread3 extends Thread{
        MyThread3 (String s){
            super(s);

        }
        public  void run(){
            for (int i = 1; i <=100 ; i++) {
                System.out.println(getName()+":"+i);
                if (i%10==0){
                    yield();//每当除10的余数为零时，进行礼让
                }
            }
        }
    }
}

```

5.线程同步(synchronized)

什么是线程同步，我们根据生活一个实例来理解。

比如小丽要去银行准备取2000块钱，银行卡里有3000块钱，她走到银行柜台去取，当工作人员核对之后准备将钱取给她，系统这时还没有将银行卡里的钱扣除，这时她男朋友拿着银行卡去ATM那取，小丽男朋友也取2000，因为柜台那边系统还没有将卡里钱扣除，所以ATM机将2000块钱吐给他。
小丽那工作人员也给她取2000块钱，系统才将金额更正为1000。

小丽俩人就好比两个不同的线程，当这两个线程去同时访问一个资源时，如果协调不好就很容易出现上述例子中的问题，所以我们将多个线程直接相互协调的访问同一个资源，叫做线程同步。
那么如何来解决这个问题呢，其实也很简单，当A线程处理某个方法的时候，让其他线程不要来干涉这个A线程，就让A线程单独来处理，这样就防止了一个线程执行中被另一个线程所打断的问题。

```java
import java.util.Timer;

public class TestSync  implements Runnable{
    Timer timer = new Timer();

    public static void main(String[] args) {
        TestSync test = new TestSync();
        //定义两个线程
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }
    @Override

    public void run() {
        timer.add(Thread.currentThread().getName());//实现run()方法拿到当前线程的名字
    }

    class Timer{
        private int num =0;
        public  void add(String name){
            num++;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e){}

            System.out.println(name+"你是第"+num+"个使用timer的线程");

        }
    }
}
```
可以看到t1和t2同时去访问一个对象。

当t1线程启动执行时，调用add方法，num++后变为1，然后sleep，第二个线程t2开始执行将num变为2，然后t2睡眠,t1开始执行，这时num是2，然后t2开始执行num也是为2，当一个线程在执行时被另一个线程给打断了，所以出现了上图中的问题。

要解决这种问题，可以给线程加锁，加锁就是为了防止其他线程来打断当前线程的执行

```java
class Timer{
    private  int num =0;
    public  void add(String name){
        synchronized (this) {//锁住当前执行的线程
            num++;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {}

            System.out.println(name + "你是第" + num + "个使用timer的线程");
       }

    }
}
```
6.死锁

死锁是指两个或两个以上的进程在执行过程中，由于竞争资源或者由于彼此通信而造成的一种阻塞的现象，若无外力作用，它们都将无法推进下去。此时称系统处于死锁状态或系统产生了死锁，这些永远在互相等待的进程称为死锁进程。

范例：
```java
public class DeadLock implements Runnable {
    public int flag = 1;
    static Object o1 = new Object(),o2 = new Object();

    @Override
    public void run() {
        System.out.println("flag="+flag);
        if (flag == 1){
            synchronized (o1){
                try{
                    Thread.sleep(500);
                }catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println("1");
                }
            }

        }
        if (flag == 0){
            synchronized (o2){
                try{
                    Thread.sleep(500);

                }catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (o1){
                    System.out.println("0");
                }
            }

        }

    }
    public static void main(String[] args) {
        DeadLock tl1 = new DeadLock();
        DeadLock tl2 = new DeadLock();
        tl1.flag = 1;
        tl2.flag = 0;
        Thread t1 = new Thread(tl1);
        Thread t2 = new Thread(tl2);
        t1.start();
        t2.start();
    }
}
```

自己运行一下，可以看到程序卡死在这，并不在往下运行，这就是死锁。

有一个小故事：说有五个哲学家在一块吃饭，围着一个大圆桌，每个哲学家手里都拿着一根筷子，每个人都在等旁边的人把那一根筷子递过来，结果谁都没有拿到那一根筷子，最后都饿死了。  

要解决这种问题，就是在锁的时候最好不要锁定多个对象只锁定一个对象，不要锁一个对象里边的小的对象，加大锁的粒度。

7.加强理解synchronized

问题：当m1方法执行时，m2方法是否会执行

范例
```java
/*synchronized*/
public class TT implements Runnable{
    int b = 100;
//
    public synchronized void m1() throws Exception{
        b = 1000;
        Thread.sleep(5000);//休眠5秒
        System.out.println("b="+b);
    }

    public void m2(){
        System.out.println(b);
    }
    @Override
    public void run() {
        try {
            m1();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        TT tt = new TT();
        Thread t = new Thread(tt);
        t.start();

        Thread.sleep(1000);//休眠1秒
        tt.m2();//主线程执行m2
    }
}
```
是否在一个线程去访问m1这个方法时，需要解锁后m2才会执行呢？如果b的值为100,则m2这个线程没有执行，也就是说m1执行后并没有解锁，所以m2方法输出的值为100；
```
运行结果
1000
b=1000
```

实际结果是，b的值为1000，也就是说另一个线程绝对不会执行m1方法体里的东西，而不能保证它执行其他的方法体。其他线程完全可以访问没有加synchronizd的方法体，所以值为1000

修改代码：
```java
public void m2() throws  Exception{
    /*修改m2方法体*/
    Thread.sleep(2500);
    b=2000;
    System.out.println(b);
}
```

```
运行结果
2000
b=2000
```
这时的结果就变成了2000,所以我们要给m2方法也要加synchronized，来避免其他线程能够访问没有加同步的对象。

8.生产者消费者问题

先提出问题，假设以做馒头为例：

有这么一家馒头店，他们把做好的馒头都扔在一个框中，有好几个师傅做好了就扔到这个框中，这时有一堆消费者来买馒头。现在要写一个程序来模拟这个过程,该如何做？

范例：
```java
import java.io.Reader;

public class ProducerConsumer {
    public static void main(String[] args) {
        SyncStack ss = new SyncStack();//生成一个框对象
        Producer p = new Producer(ss);
        Consumer c = new Consumer(ss);
        new Thread(p).start();//启动生产者线程
        new Thread(c).start();//消费者线程
    }
}
//记录馒头数
class WoTou{
    int id;
    WoTou(int id){
        this.id=id;

    }
    //重写toString方法，来查看id
    public String toString(){
        return "WoTou:"+id;

    }
}
//装馒头的筐
class SyncStack{
    int index = 0;//筐中一个馒头都没有
    WoTou[] arrWT = new WoTou[6];//假设篮子能装6个馒头

    //装馒头，为了防止装馒头时被其他人给打断，从而导致馒头个数不对，加synchronized
    public synchronized void push(WoTou wt){
        /*if*/while (index == arrWT.length){
            //一旦使用wait锁就不是当前线程所有
            try {
                this.wait();//this.wait()是当前的线程访问我的进行wait
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
        this.notify();//与wait所对应，使在等待的线程继续运行
        arrWT[index] = wt;
        index++;
    }
    //取馒头，也是同装满头一个道理，也加synchronized
    public synchronized WoTou pop(){
       /*if*/ while (index == 0){//如果筐中没有馒头，也进行wait
           try {
               this.wait();
           } catch (InterruptedException e){
               e.printStackTrace();
           }

        }
        this.notify();
        index--;//
        return arrWT[index];
    }

}
//生产者类
class Producer implements Runnable{
    SyncStack ss = null;
    Producer(SyncStack ss){
        this.ss=ss;
    }

    @Override
    public void run() {
        //假设每个师傅生产20个馒头
        for (int i = 0; i <20 ; i++) {
            WoTou wt = new WoTou(i);
            ss.push(wt);
            System.out.println("生产了："+wt);
            //为了更能清晰观察程序的运行，我们使每生产一个休眠1秒
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
}
//消费者类
class Consumer implements Runnable{
    SyncStack ss = null;
    Consumer(SyncStack ss){
        this.ss = ss;

    }
    //假设吃20个馒头
    @Override
    public void run() {
        for (int i = 0; i <20 ; i++) {
            WoTou wt = ss.pop();//调用取馒头方法
            System.out.println("消费了："+wt);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
}
```

这个程序例子中，值得注意的有两点：

* 使用了wait()就必须要使用notify()，来叫醒一个线程，否则程序就会卡住，不在运行

* 判断是否足够 用while，如果使用if来判断的话，一旦线程被打断，执行catch模块，执行完毕后依旧往下执行，从而导致程序出错

Wait和sleep的区别

* wait时别的线程可以访问锁定对象,调用wait方法的时候必需锁定该对象
* sleep时别的线程也不可以访问锁定对象
* wait是Object类中的方法，sleep是Thread类中的方法

9.总结

* 线程/进程概念
    - 线程：一个程序中不同的执行路径
    - 进程：一个exe文件或者一个clas文件
* 创建线程和启动线程的方式
    - 继承Thread类，重写run方法
    - 实现Runnable接口，实现run方法
* sleep 使一个线程休眠
* join 调用join（）方法的线程运行完毕后，才继续执行
* yield 线程礼让
* synchronize 线程同步，加锁
* wait 线程等待
* notify/notifyAll 叫醒一个等待的线程，或者所有线程