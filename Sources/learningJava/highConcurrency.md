# 高并发
### volatitle
1.线程抛出异常，锁会被释放吗？

```java
public class T {
    int count=0;
    synchronized void m() {
        System.out.println(Thread.currentThread().getName()+"start");
        while(true) {
            count++;
            System.out.println(Thread.currentThread().getName()+"count"+count);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace(); 
            }
            if(count==5) {
                int i=1/0; //此处抛出异常，锁讲被释放，要想不被释放，可以在这里catch，然后让循坏继续
            }
        }
    }
    public static void main(String []args) {
        T t=new T();
        Runnable r=new Runnable() {
            public void run() {
                t.m(); 
            }
        }; 
        new Thread(r,"t1").start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        new Thread(r,"t2").start();
    }
}
```
程序在执行过程中，如果出现异常，默认情况锁都会被释放所以，在并发处理的过程中，有异常要多加小心，不然可能会发生不一致的情况。比如，在一个web app处理过程中，多个servlet线程访问同一个资源，这时如果异常处理不合适，就会发生错误，因此要非常小心的处理同步业务逻辑中的异常.

2.volatile关键字：使一个变量在多个线程可见

* A、B线程都用到一个变量，java默认是A线程中保留一份copy，这样如果B线程修改了该变量，则A线程未必知道

* 使用volatile关键字，会让所有线程都会读到变量的修改值

范例
```java
import java.util.concurrent.TimeUnit;

public class T {
/*volatile */boolean running =true;
    void m() {
        System.out.println("m start");
        while(running) {
        }
        System.out.println("m  end!");
    }
    public static void main(String []args) {
        T t=new T();
        new Thread(t::m,"t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException  e) {
            e.printStackTrace();
        }
        t.running=false;
    }
}
```
new Thread(()->t.m1())这个写法是java8里面的Lambda表达式，一种简写，还可以写成这样(即上述程序中用的)：
```java
T t = new T();

new Thread(t::m1, "t1").start();
new Thread(t::m2, "t2").start();
```
```
运行结果(程序不继续执行)
m start
```
运行之后你会发现它不会运行 m end 的命令。
在上面的代码中，running是存在于堆内存的t对象中。当线程t1开始运行的时候，会把running值从内存中读到t1的工作区，在运行过程中，直接使用这个copy，并不会每次都去读取内存。这样，当主线程修改running的值之后，t1线程感知不到，所以不会停止运行。

使用volatile，将会强制所有线程都去堆内存中读取running的值，t1线程感知不到，所以不会停止运行 。

```
运行结果(程序结束)
m start
m  end!
```
end 命令执行了。保持线程间的可见性。


3.volatile和synchronized区别？

* volatile只保证可见性，并不保证原子性；
* synchronized既保证可见性，又保证原子性；但效率要比volatile低不少；
* 如果只需要保证可见性的时候，使用volatile，不要使用synchronized。

4.锁定某个对象时，如果o的属性发生改变，但不影响锁的使用,但是如果o变成了一个对象，则锁定的对象则会发生改变。
```java
public class T {
    Object o=new Object();
    void m() {
        synchronized (o) {
            while(true) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }   
            System.out.println(Thread.currentThread().getName());
            }
        }
    }
    public static void main(String []args) {
        T t=new T();
        //启动第一个线程
        new Thread(t::m,"t1").start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //创建第二个线程
        Thread t2=new Thread(t::m,"t2");
        t.o=new Object();//锁对象发生改变，所以t2线程得以执行   ，如果注释掉这句话，线程永远得不到机会执行
    
    }
}
```
不要以字符串常量作为锁定对象。

在下面的例子中，m1和m2其实锁定了是同一个对象
在这种情况还会发生比较诡异的现象，比如你用到了一个类库，在该类库中代码锁定了字符串“hello”。但是你读不到源码，所以你在自己的代码中也锁定了“hello”，这时候就可能发生非常诡异的死锁阻塞。
因为你的程序和你用到的类库不经意间使用了同一把锁。
```java
public class T{
    String s1="Hello";
    String  s2="Hello";
    void m1(){
        synchronized(s1){
        }
    }
    void m2(){
    }
}
```

5.案例
实现一个容器，提供两个方法，add，size
写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数。
当个数到5时，线程2给出提示并结束。
分析下面的程序，能完成这个功能吗？
```java
public class MyContainer1 {
    ArrayList lists =new ArrayList();
    public void add(Object o) {
        lists.add(o);
    }
    public int size() {
        return lists.size();
    }
    public static void main(String[]args) {
        MyContainer1 c=new MyContainer1();
    
        new Thread(()->{
            for(int i=0;i<10;i++) {
                c.add(new Object());
                System.out.println("add"+i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } 
        },"t1").start();
        new Thread(()->{
            while(true) {
                if(c.size()==5) {
                    break;
                }
            }
            System.out.println("t2结束");
        },"t2").start();
    }
}
```
或许你看到这个代码之后，感觉没什么问题。但运行结果或许出乎你的意料。
```
运行结果（程序未终止）
add0
add1
add2
add3
add4
add5
add6
add7
add8
add9
```

这个时候就需要用到volatile，然后我们再看一下代码运行结果。
```java
//添加volatile，使t2能够得到通知
volatile ArrayList lists =new ArrayList();
public void add(Object o) {
    lists.add(o);
}
```
```
运行结果
add0
add1
add2
add3
add4
t2结束
add5
add6
add7
add8
add9
```


### 手工锁 ReentrantLock
synchronized和 ReentrantLock区别是：
synchronized 手动上锁，自动释放
ReentrantLock 手动上锁，手动释放

1. 先复习一下synchronized最原始的定义

```java
public class ReentrantLock{
    synchronized void m1(){
    for(int i=0;i<10;i++){
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(i);
    }
}
    synchronized void m2{
        System.out.println("m2...");
    }
    public static void main(String []args){
        ReentrantLock1 r1 =new ReentrantLock1();
        new Thread(r1::m1).start();
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        new Thread(r1::m2).start();
    }
} 
```
分析：在本例中由于m1锁定this，只有m1执行完毕的时候m2才能执行。

2.reentranlock用于替代synchronized，由于m1锁定this，只有m1执行完毕的时候，m2才能执行
使用reentranlock可以完成同样的功能，但需要注意的是

必须必须必须要**手动释放锁**

使用synchronized锁定的话，如果遇到异常，jvm会自动释放

但是lock必须手动释放锁，因此在finally中进行锁的释放

```java
public class ReentrantLock2{
    Lock  lock =new ReentrantLock();
    void m1() {     
            try {
                lock.lock();  //相当于synchronized(this)
                for(int i=0;i<10;i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally {
                lock.unlock(); //释放锁
            }
        }
    void m2() {
        lock.lock(); //上锁
        System.out.println("m2...");
        lock.unlock();//释放锁
    }
    public static void main(String []args) {
        ReentrantLock2 r1=new ReentrantLock2();
        new Thread(r1::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(r1::m2).start();
    }
}
```
`运行结果：
0 1 2 3 4 5 6 7 8 9 m2…`

3.reentrantLock可以进行"尝试锁定"tryLock,，如果在指定时间内无法锁定，线程可以决定是否继续等待
```java
public class ReentrantLock3 {
    Lock  lock =new ReentrantLock();
    void m1() {
        try {
            lock.lock();
            for(int i=0;i<10;i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

/*使用trylock进行尝试锁定，不管锁定与否，方法豆浆继续执行,可以根据trylock的返回值来判定是否锁定,
 也可以指定tryLock的时间，由于trylock（time）抛出异常，所以要注意unlock的处理， 必须放到finally中*/

    void m2() {
        /*boolean locked =lock.tryLock();
        System.out.println("m2..."+locked);  //跟方法一样
        if(locked)lock.unlock();*/
        boolean locked =false;
        try {
            locked=lock.tryLock(5,TimeUnit.SECONDS);//等待5秒之后捕获锁，失败返回false 成功true
            System.out.println("m2..."+locked);
        }catch (InterreptedException e ){
            e.printStackTrace();
        }finally {
            if(locked) lock.unlock();//如果锁定，解锁，没有锁定，不运行
        }
    }
    public static void main(String []args) {
        ReentrantLock3 r1=new ReentrantLock3();
        new Thread(r1::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(r1::m2).start();
    }
}
```

`运行结果：   0 1 2 3 4 m2…false 5 6 7 8 9`

4.使用reentrantlock 可以进行"trylock，如果在指定时间内无法锁定, 线程可以决定是否继续等待;

使用reentrantlock还可以调用lockInterruptibly方法，可以对线程Interrupt方法做出响应，在一个线程等待锁的过程中，可以被打断。
例子如下：
```java
public class ReentrantLock4 {
    public static void main(String []args) {
        Lock  lock=new ReentrantLock();
    
        Thread t1=new Thread(()->{
            try {
                lock.lock();
                System.out.println("t1 start");
                TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
            } catch (InterruptedException e) {
            System.out.println("interrupted");
            }finally {
                lock.unlock();
            }
        });
        t1.start();
        Thread t2=new Thread(()->{
            try {
                //lock.lock();如果这里运用它的话，将会继续等待，不会打断等待
                lock.lockInterruptibly();//运用它可以对interrupt方法做出响应，打断等待
                System.out.println("t2 start");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("t2 end");
            } catch (InterruptedException e) {
                System.out.println("interrupted!");
            }finally {
                lock.unlock();
            }
        }) ;
        t2.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.interrupt();//打断线程2的等待
        }
    }
}
```

```
运行结果
t1 start
interrupted!
Exception in thread "Thread-1" java.lang.IllegalMonitorStateException
    at java.util.concurrent.locks.ReentrantLock$Sync.tryRelease(Unknown Source)
    at java.util.concurrent.locks.AbstractQueuedSynchronizer.release(Unknown Source)
    at java.util.concurrent.locks.ReentrantLock.unlock(Unknown Source)
    at yxxy.c_020.ReentrantLock4.lambda$1(ReentrantLock4.java:36)
    at java.lang.Thread.run(Unknown Source)
```
打断锁，抛出异常。 这里的异常是由于我们没有对locked这个方法进行判断，修改一下
```java
boolean locked =false;
try {
    //lock.lock();如果这里运用它的话，将会继续等待，不会打断

    lock.lockInterruptibly();//可以对interrupt方法做出响应，打断等待
    System.out.println("t2 start");
    TimeUnit.SECONDS.sleep(5);
    System.out.println("t2 end");
} catch (InterruptedException e) {
    System.out.println("interrupted!");
}finally {
    if(locked)lock.unlock();
}
```

5.对于reentrantlock来说，还有一个好处是可以被指定为公平锁（如果当前线程已经获得了执行序列中的锁，那执行序列之后的所有方法都可以获得这个锁。）

```java
public class ReentrantLock5 extends Thread{
    private static ReentrantLock Lock =new ReentrantLock(true);//参数为true表示公平锁，请对比输出结果
    public void run() {
        for(int i=0;i<100;i++) {
            Lock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+"获得锁");
            } finally {
                Lock.unlock() ;
            }
        }
    }
    public static void main(String []args) {
        ReentrantLock5 r1=new ReentrantLock5();
        Thread th1=new Thread(r1);
        Thread th2=new Thread(r1);
        th1.start();
        th2.start();
        
        
    }
}

```
```
运行结果：
Thread-2获得锁
Thread-1获得锁
Thread-2获得锁
Thread-1获得锁
Thread-2获得锁
Thread-1获得锁
Thread-2获得锁
```

6.小结：

1.reentrantlock可以完成synchronized的功能，可以替代synchronized

2.比synchronized灵活

3.可以使用lockinterruptibly 打断锁，

4.还可以把锁指定为公平锁

### 生产者消费者问题
要求：写一个固定容量同步容器，拥有put和get方法，以及getCount方法。

能够支持2个生产者线程以及10个消费者线程的阻塞调用

使用wait和notify/notifyall来实现


1.用synchronized 来实现，代码如下：
```java
public class MyContainer1 <T>{
    final private LinkedList <T> lists=new LinkedList<>();
    final private int MAX =10;//最多10个元素
    private int count=0;
    public synchronized void put(T t){
        while(lists.size()==MAX) {//想想为什么用while而不是用if
            try {
                this.wait();
            } catch (InterruptedException  e) {
                e.printStackTrace();
            }
        }
        lists.add(t);
        ++count;
        this.notifyAll();//通知消费者线程进行消费
    }
//while在 下面的运行过程中，还会再次判断上面的执行条件
    public synchronized T get() {
        T t=null;
        while(lists.size()==0) {  //为什么用while而不用if？因为while一直判断，而if判断一次
            try {
                this.wait();  
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t=lists.removeFirst();
        count--;
        this.notifyAll();//通知生产者线程进行生产
        return t;
    }
    public static void main(String[]args){
        MyContainer1<String> c=new MyContainer1<>();
        //启动消费者线程
        for(int i=0;i<10;i++) {
            new Thread(()->{
                for(int j=0;j<5;j++) System.out.println(c.get());
            },"c"+i).start();       
        }   
        try {TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //启动生产者线程
        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                for (int j = 0; j < 25; j++) 
                    c.put(Thread.currentThread().getName()+""+j);
                
            },"p"+i).start();
        }
    }
}
```

2.用lock和condition的方式来实现，对比两种方式，condition的方式将会更加精确的指定哪个线程被唤醒。

代码如下：
```java
    final private LinkedList<T> lists=new LinkedList<>();
    final private int MAX=10;
    private int count=0;
    private Lock  lock =new ReentrantLock();
    private Condition producer=lock.newCondition();
    private Condition consumer=lock.newCondition();
    public void put(T t) {
        try {
            lock.lock();//使用锁
            while (lists.size()==MAX) {
                producer.await();       
            }
            lists.add(t);
            ++count;
            consumer.signalAll();//通知消费者消费
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();//释放锁
        }
    }
    public T get() {
        T t=null;
        try {
            lock.lock();
            while(lists.size()==0) {
            consumer.await();
            }
            t=lists.removeFirst();
            count--;
            producer.signalAll(); //通知生产者生产
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return t;
    }
```

##### ThreadLocal 局部变量

我们先举个例子，代码如下：
```java
public class ThreadLocal1 {
    volatile static Person p=new Person();
    public static void main(String []args) {
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(p.name);
        }).start(); 
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.name="lisi";
        }).start();
    }
}
class Person{
    String name="zhangsan";
}
```
`运行结果：lisi`
去掉volatile后运行,`运行结果：lisi`
分析：这里面写volatile和不写volatile打印出来 都是"lisi"， 只不过写volatile会避免许多问题发生。

如果这两个线程在访问期间相互不影响对方，这个时候就需要用到ThreadLocal。

```java
public class ThreadLocal2 {
     static Threadlocal<Person> tl=new ThreadLocal<>();
    public static void main(String []args) {
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(tl.get());
        }).start(); 
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tl.set(new Person())
        }
                ).start();
    }
}
class Person{
    String name="zhangsan";
}
```

简析： 线程局部变量（threadlocal）其实的功用非常简单，就是为每一个使用该变量的线程都提供一个变量值的副本，是每一个线程都可以独立地改变自己的副本，而不会和其它线程的副本冲突。


### 火车票问题
问题：有N张火车票？，每张票都有一个编号，同时又10个窗口对外售票，写一个模拟程序，分析下面的程序可能会产生哪些问题？

```java
public class TicketSeller1 {
    static List<String> tickets =new ArrayList<>();
    static {
        for(int i=0;i<10000;i++)
            tickets.add("票编号"+i);
    }
    public static void main(String[]args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while(tickets.size()>0) {
                    System.out.println("销售了---"+tickets.remove(0));
                }
            }
                    ).start();
            
        }
    }
}
```

对于稍微有点基础的同学来看，这个程序是由问题的，仔细分析一下，当火车票剩下最后一张时，会存在多个线程抢最后一张票，有可能重复销售，超量销售。就会发生错误。
对于上面超量销售的问题来说，我们给线程加个判断。
```java
public class Ticketseller2 {
    static Vector<String> tickets=new Vector<>();
        static {
            for(int i=0;i<1000;i++)tickets.add("票编号："+i);
        }   
        public static void mian(String []args){
            for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while(tickets.size()>0) {
                    System.out.println("销售了---"+tickets.remove(0));
                    /*try {                                         
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {//在开发中不免会再其中加一些其他的代码。
                        e.printStackTrace();
                    }*/
                }
            }).start();
        }
    }
}
```

需要注意的是，我们把容器换成了vector，最后还是报错误，因为它也存在与上面一样的问题，当多个线程抢最后一张票时，出现超额销售。发生错误

我们现在给程序上把锁(synchronized)
```java
public class TicketSeller3 {
    static List<String> tickets=new LinkedList<>();
    static {
        for (int i = 0; i < 1000; i++) 
            tickets.add("票编号"+i);
        
    }
    public static void main(String []args){
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while(true) {
                    synchronized (tickets) {
                        if(tickets.size()<=0) break;
                        try {
                            TimeUnit.MICROSECONDS.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("销售了--"+tickets.remove(0));
                    }
                }
            }
                    ).start();
        }
    }
}
```
```
运行结果
销售了---票编号：0
销售了---票编号：1
销售了---票编号：2
销售了---票编号：3
销售了---票编号：4
销售了---票编号：5
销售了---票编号：6
销售了---票编号：7
销售了---票编号：8
```
程序很顺利的运行了这个程序，每次销售票之后，都要上锁，我们现在来看一下jdk1.6出现一种新特性，
也能解决以上的问题。
代码如下：
```java
public class Ticketseller4 {
    static Queue<String> tickets =new ConcurrentLinkedQueue<>();
    static {
        for (int i = 0; i < 1000; i++) {
            tickets.add("票编号："+i);
        }           
    }
    public static void main(String []args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while(true) {
                    String s =tickets.poll();//从头输出，当没有值时，string s=null；
                    if(s==null)break;  //循环结束
                    else System.out.println("销售了---"+s);
                }
            }
                    ).start();
        }
    }
}
```
```
运行结果
销售了---票编号：0
销售了---票编号：2
销售了---票编号：4
销售了---票编号：5
销售了---票编号：7
销售了---票编号：1
销售了---票编号：9
销售了---票编号：8
销售了---票编号：11
```
这是一个并发的多线程，效率要比上一个程序高很多。

### 并发容器


1.我们先看多线程在运行的情况下，哪个容器的效率高呢？
代码如下：
```java
public class ConcurrentMap {
    public static void main(String []args) {
        Map<String, String> map=new ConcurrentSkipListMap<>();//高并发且排序
        //Map<String, String> map =new ConcurrentHashMap();
        //Map<String, String>map=new Hashtable<>();
        //Map<String, String> map=new HashMap<>(); //Collections.synchronizedXXX  带锁
        //Map<String, String> map =new TreeMap<>();
        Random r=new Random();
        Thread[] ths=new Thread[100]; //new 出100个线程数组
        CountDownLatch latch =new CountDownLatch(ths.length); //计数初始化
        long start =System.currentTimeMillis();  //起始时间
        for(int i=0;i<ths.length;i++) {
            ths[i] =new Thread(()->{
                for (int j = 0; j < 10000; j++) {
                    map.put("a"+r.nextInt(100000),"a"+r.nextInt(100000));
                    latch.countDown();
                }   
            });
        }
        Arrays.asList(ths).forEach(t->t.start());
        try {
            latch.await();
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
        long end=System.currentTimeMillis();  //结束时间
        System.out.println(end-start); //时间差
    }
}
```

过程：在map 容器中，创建100个线程，每一个线程往map中装10000个数据，每个线程装完之后，门栓(CountDownLatch)减1,装完之后，看一下所用的时间。

结果：`168(hashtable)        48(concurrentHashMap)`

可以很清楚的看到hashtable和concurrentHashMap的运行结果速度，通过比较，发现concurrentHashMap明显比Hashtable要快

hashtable和concurrenthashmap区别：

在代码执行中，hashtable要锁定的是整个对象。而concurrentHashMap是把整个对象划分成好多份，插入其中的一部分，不用锁定整个对象，所以效率要比hashtable高很多。

2.对于map来说，我们做一个总结：

在不加锁的情况下，我们可以用hashmap、treemap、linkedhashmap等等都一样，如果想加锁的话，用hashtable、collection.synchronizedXXX(并发不是太高情况下使用) 。

在并发性高情况下，使用concurrenthashmap，如果并发性高而且需要排序的话，使用concurrentskiplistmap。


### Queue

Queue队列是在并发容器中是最重要的也是应用最广泛的容器。(重点)

cocurrentLinkedQueue |并发加锁     
blockingqueue|阻塞式     

*  cocurrentLinkedQueue常用的一些方法:

    - offer(E e) 将指定元素插入此队列的尾部
    - poll() 获取并移除此队列的头，如果此队列为空，则返回 null。
    - peek() 获取但不移除此队列的头；如果此队列为空，则返回 null。
    注意：offer是往队列添加元素，poll是从队列取出元素并且删除该元素

范例
```java
public class ConcurrentQueue {
    public static void main(String []args) {
        Queue<String> strs=new ConcurrentLinkedQueue<>();
        for (int i = 0; i < 10; i++) {
            strs.offer("a"+i); 
        }
        System.out.println(strs);
        System.out.println(strs.size());
        System.out.println(strs.poll());
        System.out.println(strs.peek());
        System.out.println(strs.size());
        
    }
}
```
```
运行结果:
[a0, a1, a2, a3, a4, a5, a6, a7, a8, a9]
10 
a0
a1
9
```


* 阻塞式容器

范例：
```java
public class s05_LinkedBlockingQueue {
    static BlockingQueue<String> strs =new LinkedBlockingDeque<>();
    static Random r =new Random();
    public static void main(String []args) {
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try { 
                    strs.put("a"+i);//如果满了，就会等待
                    TimeUnit.MICROSECONDS.sleep(r.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
            }
        },"p1").start();
    for (int i = 0; i <5; i++) {
        new Thread(()->{
            for(;;) {
                try {
                    System.out.println(Thread.currentThread().getName()+"take-"+strs.take());//如果空了，就会等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"c"+i).start();
    }
    }
}
```
```
运行结果
c0take-a0
c1take-a1
c2take-a2
c3take-a3
c0take-a4
c4take-a5
c1take-a6
c2take-a7
c3take-a8
c0take-a9
c4take-a10
```

blockingqueue常用的方法：

* add：add方法在添加元素的时候，若超出了度列的长度会直接抛出异常。
* put：put方法，若向队尾添加元素的时候发现队列已经满了会发生阻塞一直等待空间，以加入元素。
* offer：offer方法在添加元素时，如果发现队列已满无法添加的话，会直接返回false


### 同步队列(TransferQueue)
TransferQueue(java7引入)继承了BlockingQueue（BlockingQueue又继承了Queue）并扩展了一些新方法。生产者会一直阻塞直到所添加到队列的元素被某一个消费者所消费（不仅仅是添加到队列里就完事）。

LinkedTransferQueue实际上是ConcurrentLinkedQueue、SynchronousQueue（公平模式）和LinkedBlockingQueue的超集。而且LinkedTransferQueue更好用，因为它不仅仅综合了这几个类的功能，同时也提供了更高效的实现。

使用场景
当我们不想生产者过度生产消息时，TransferQueue可能非常有用，可避免发生OutOfMemory错误。在这样的设计中，消费者的消费能力将决定生产者产生消息的速度。

```java
public class LinkedTransferQueueDemo {
    static LinkedTransferQueue<String> lnkTransQueue = new LinkedTransferQueue<String>();
    public static void main(String[] args) {
        ExecutorService exService = Executors.newFixedThreadPool(2);
        Producer producer = new LinkedTransferQueueDemo().new Producer();
        Consumer consumer = new LinkedTransferQueueDemo().new Consumer();
        exService.execute(producer);
        exService.execute(consumer);
        exService.shutdown();
    }
    class Producer implements Runnable{
        @Override
        public void run() {
            for(int i=0;i<3;i++){
                try {
                    System.out.println("Producer is waiting to transfer...");
                    lnkTransQueue.transfer("A"+i);
                    System.out.println("producer transfered element: A"+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class Consumer implements Runnable{
        @Override
        public void run() {
            for(int i=0;i<3;i++){
                try {
                    System.out.println("Consumer is waiting to take element...");
                    String s= lnkTransQueue.take();
                    System.out.println("Consumer received Element: "+s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```
```
运行结果
Producer is waiting to transfer...
Consumer is waiting to take element...
producer transfered element: A0
Producer is waiting to transfer...
Consumer received Element: A0
Consumer is waiting to take element...
producer transfered element: A1
Producer is waiting to transfer...
Consumer received Element: A1
Consumer is waiting to take element...
Consumer received Element: A2
producer transfered element: A2
```

### SynchronusQueue队列(容量为零)

SynchronousQueue 也是一个队列来的，但它的特别之处在于它内部没有容器，一个生产线程，当它生产产品（即put的时候），如果当前没有人想要消费产品(即当前没有线程执行take)，此生产线程必须阻塞，等待一个消费线程调用take操作，take操作将会唤醒该生产线程，同时消费线程会获取生产线程的产品（即数据传递），这样的一个过程称为一次配对过程(当然也可以先take后put,原理是一样的)。

```java
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class T08_SynchronusQueue { //容量为0
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> strs = new SynchronousQueue<>();
        
        new Thread(()->{
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        strs.put("aaa"); //阻塞等待消费者消费
        strs.add("aaa"); //Exception in thread "main" java.lang.IllegalStateException: Queue full

        System.out.println(strs.size());//容量为0
    }
}

```