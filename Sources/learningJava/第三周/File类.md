## IO流的非流式部分：File类

#### 1.概念：

​	File类的对象不但可以表示文件，还可以表示文件夹；

​	当创建一个文件对象后，就可以利用它来对文件或文件夹的属性进行操作，如：文件名、最后修改日期、文件大小等等；

​	**需要注意的是，File对象并不能直接对文件进行读/写操作，只能查看文件的属性。**

#### 2.构造方法

```java
public File(File parent, String child) 
	//根据文件对象和字符串创建一个新的File实例
public File(String pathName)
	//根据路径名字符串创建一个新的File实例
public File(String parent, String child)
	//根据两个字符串创建一个新的File实例
public File(URI uri)
	//使用给定的统一资源定位符来创建一个新的File实例
```

案例：

```java
File myFile = new File(“D:\\Java\\Hello.java”);	   // 绝对路径
File myFile = new File(“D:\\Java”,“Hello.java”);
File myFile = new File(“Hello.java”);		   // 相对路径
File myDir  = new File（“D:\\Java”）；
File myFile = new File( myDir, “Hello.java”);
```

#### 3.常用方法

```java
boolean exists()
	//判断文件是否存在，存在返回true，否则返回false
boolean isFile()
	//判断是否为文件，是文件返回true，否则返回false
boolean isDirectory()
	//判断是否为目录，是目录返回true，否则返回false
String getName()
	//返回文件或目录的名称，该名称是名称序列中的最后一个名称
String getAbsolutePath()
	//获得文件的绝对路径(包含文件名)
long length()
 	//获得文件的长度（字节数）
boolean createNewFile() throws IOException
	//创建新文件(不能创建文件夹)，创建成功返回true，否则返回false，有可能抛出IOException异常，必须捕捉
boolean delete()
    //删除文件，删除成功返回true，否则返回false
public String[] list()
	//返回当前目录下所有的文件和目录名称
```

案例：

```java
import java.io.*;
class FileDemo   {
     public static void main(String[] args)        {
   	       File file = new File(“test.txt”);      //创建File对象，代表一个文件

		//显示与文件有关的属性信息
		System.out.println("文件或目录是否存在：" + file.exists());
		System.out.println("是文件吗：" + file.isFile());
		System.out.println("是目录吗：" + file.isDirectory());
		System.out.println("名称：" + file.getName());
		System.out.println("绝对路径：" + file.getAbsolutePath());
    	System.out.println("最后修改时间:" + file.lastModified());    
    	System.out.println("文件大小:" + file.length()+ " 字节");
      }
}
```

# IO流之流式部分

#### 1.概念：

- IO：输入/输出(Input/Output)
- 流：![image-20210128153645797](C:\Users\17159\AppData\Roaming\Typora\typora-user-images\image-20210128153645797.png)

> 在电脑上的数据有三种存储方式，一种是**外存**，一种是**内存**，一种是**缓存**。比如电脑上的硬盘，磁盘，U盘等都是外存，在电脑上有内存条，缓存是在CPU里面的。外存的存储量最大，其次是内存，最后是缓存，但是外存的数据的读取最慢，其次是内存，缓存最快。
>
> 在Java类库中，IO部分的内容是很庞大的，因为它涉及的领域很广泛: **标准输入输出**，**文件的操作**，**网络上的数据流**，**字符串流**，**对象流**，**zip文件流**等等，**java中将输入输出抽象称为流**，就好像水管，将两个容器连接起来。将数据**从外存中读取到内存中**的称为**输入流**，将数据**从内存写入外存中**的称为**输出流**。 流是一个很形象的概念，当**程序需要读取数据**的时候，就会**开启一个通向数据源的流**，这个**数据源可以是文件，内存，或是网络连接**。类似的，当程序需要写入数据的时候，就会开启一个通向目的地的流。

#### 2.分类：

![完整的IO分类图](https://img-blog.csdnimg.cn/20200922220641678.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L211X3dpbmQ=,size_16,color_FFFFFF,t_70#pic_center)

#####  按照数据的流向

- 输入流：读数据

- 输出流：写数据

  > 输入与输出是相对于应用程序而言的，比如文件读写，读取文件是输入流，写文件是输出流，这点很容易搞反。

  ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200921134045111.png#pic_left)

##### 按照数据类型来分

- 字节流：以字节(byte)为基本处理单位，包括字节输入流、字节输出流

  - `lnputStream`：这个抽象类是表示字节输入流的所有类的超类

    - 父类`lnputStream`与子类

    ![父类lnputStream与子类](C:\Users\17159\AppData\Roaming\Typora\typora-user-images\image-20210128182621040.png)

    - 读取的方法

    ```java
    abstract int read() throws IOException 
        //读取一个字节的数据，并返回该数据，读到末尾时返回-1。 
    int read( byte[] b) throws IOException
        //读取数据存入字节数组b，返回实际读取的字节数。
    int read( byte[] b, int off, int len) throws IOException
        //读取数据存入字节数组b，存入的位置从下标off开始，最多读取len个数据。返回实际读取的字节数。
    ```

    - 其他方法

    ```java
    long skip (long n)
        //在输入流中跳过n个字节，并返回实际跳过的字节数；
    int available()
        //返回在不发生阻塞的情况下，可读取的字节数；
    void close()
        //关闭输入流；
    void mark(int readlimit)
        //在输入流的当前位置放置一个标记，可实现重复读入；
    void reset()
        //返回到上一个标记；
    boolean markSupported()
        //测试当前的流是否支持mark和reset方法。
    ```

  - `OutputStream`：这个抽象类是表示字节输出流的所有类的超类

    - 父类`OutputStream`与子类

    ![image-20210128183120958](C:\Users\17159\AppData\Roaming\Typora\typora-user-images\image-20210128183120958.png)

    - 写入方法

    ```java
    void write(int b) throws IOException
      //将参数b的最后一个字节写入输出流中
    void write(byte[] b) throws IOException
      //将数组b的所有字节写入输出流中
    void write(byte[] b, int off, int len) throws IOException
      //将数组b中从下标off（包含）开始的len个字节的数据写入输出流中
    ```

    - 其他方法

    ```java
    void close()
        //关闭输出流，释放和这个流相关的资源
    void flush()
        //刷新输出流，强制输出缓冲区中的数据
    ```

- 字符流：字符流以16位的Unicode码表示的字符为基本处理单位，包含字符输入流、字符输出流

  > （由于字节流操作中文不是特别的方便，所以Java就提供字符流 = 字节流 + 编码表）

  - `Reader`:是抽象类，是所有输入字符流类的父类,只提供了一系列用于字符流处理的接口

    - 父类Reader与子类

    ![image-20210128183324368](C:\Users\17159\AppData\Roaming\Typora\typora-user-images\image-20210128183324368.png)

    - 写入方法

    ```java
    int read() throws  IOException
        //读取一个字符
    int read(char[] cbuf) throws IOException 
        //读取一串字符存入字符数组cbuf
    ```

    - 其他方法

    ```java
    long skip(long n) 
        //跳过n个字符
    void mark(int readAheadLimit)
        //在当前位置做一标记
    void reset()
        //将读取位置恢复到标记处
    void close()
        //关闭字符流
    ```

  - `Writer`:是抽象类，是所有输出字符流类的父类，只提供了一系列用于字符流处理的接口

    - 父类`Writer`与子类

    ![image-20210128183515911](C:\Users\17159\AppData\Roaming\Typora\typora-user-images\image-20210128183515911.png)

    - 写入方法

    ```java
    void write(int c) throws IOException 
        //将一个字符写入输出流
    void write(char[] cbuf) throws IOException 
        //将字符数组中的数据写入输出流
    void write(char[] cbuf, int off, int len) throws IOException 
        //将字符数组cbuf中自下标off开始的len个字符写入输出流
    void write(String str) throws IOException
        //将字符串str写入输出流
    void write(String str, int off, int len) throws IOException 
        //将字符串str中自位置off开始的len个字符写入输出流
    ```

    - 其他方法

    ```java
    public Writer append(char c) throws IOException 
        //将一个字符写入输出流，与write(int c)方法作用相同
    public Writer append(CharSequence csq) throws IOException 
        //将CharSequence对象转换成字符串后写入流中
    public Writer append(CharSequence csq,int start,int end) throws IOException 
        //将CharSequence对象转换成字符串，将字符串从索引值为start（包含）到索引值为end（不包含）的部分写入流中。
    void close()  	
        //关闭流
    void flush()   	
        //强行输出
    ```

    

  > **基础拓展：**
  >
  > ​	计算机中储存的信息都是用*二进制*数表示的；我们在屏幕上看到的英文、汉字等字符是二进制数转换之后的结果
  >
  > ​    按照某种规则，将字符存储到计算机中，称为*编码*。反之，将存储在计算机中的二进制数按照某种规则解析显示出来，称为*解码* 。这里强调一下：按照A编码存储，必须按照A编码解析，这样才能显示正确的文本符号；否则就会导致乱码现象。
  >
  > ​	**字符集：**
  >
  > ​		是一个系统支持的所有字符的集合，包括各国家文字、标点符号、图形符号、数字等
  >
  > ​		计算机要准确的存储和识别各种字符集符号，就需要进行字符编码，一套字符集必然至少有一套字符编码。常见字符集有ASCII字符集、GBXXX字符集、Unicode字符集等
  >
  > ​	**ASCII字符集：**
  >
  > ​		*ASCII*(American Standard Code for Information Interchange，美国信息交换标准代码)：是基于拉丁字母的一套电脑编码系统，用于显示现代英语，主要包括控制字符(回车键、退格、换行键等)和可显示字符(英文大小写字符、阿拉伯数字和西文符号) 
  >
  > ​		基本的ASCII字符集，使用7位表示一个字符，共128字符。ASCII的扩展字符集使用8位表示一个字符，共256字符，方便支持欧洲常用字符。是一个系统支持的所有字符的集合，包括各国家文字、标点符号、图形符号、数字等
  >
  > ​	**GBXXX字符集：**
  >
  > ​		*GB2312*：简体中文码表。一个小于127的字符的意义与原来相同，但两个大于127的字符连在一起时， 就表示一个汉字，这样大约可以组合了包含7000多个简体汉字，此外数学符号、罗马希腊的字母、日文的假名等都编进去了，连在ASCII里本来就有的数字、标点、字母都统统重新编了两个字节长的编码，这就是常说的"全角"字符，而原来在127号以下的那些就叫"半角"字符了
  >
  > ​		<u>*GBK*：</u><u>最常用的中文码表</u>。是在GB2312标准基础上的扩展规范，使用了双字节编码方案，共收录了21003个汉字，完全兼容GB2312标准，同时支持繁体汉字以及日韩汉字等
  >
  > ​		*GB18030*：最新的中文码表。收录汉字70244个，采用多字节编码，每个字可以由1个、2个或4个字节组成。支持中国国内少数民族的文字，同时支持繁体汉字以及日韩汉字等
  >
  > ​	**Unicode字符集：**	
  >
  > ​		当计算机传到世界各个国家时，为了适合当地语言和字符，各国国家就设计出了符合各自的字符集和编码表。这样各搞一套，在本地使用没有问题，一旦出现在网络中，由于不兼容，互相访问就出现了乱码现象。
  >
  > ​		为了解决这个问题，一个伟大的创想产生了——Unicode。
  >
  > ​		为表达任意语言的任意字符而设计，是业界的一种标准，也称为统一码、标准万国码。它最多使用4个字节的数字来表达每个字母、符号，或者文字。有三种编码方案：UTF-8、UTF-16和UTF32。最为常用的UTF-8编码
  >
  > ​		<u>*UTF-8编码*：</u><u>可以用来表示Unicode标准中任意字符</u>，它是电子邮件、网页及其他存储或传送文字的应用中，优先采用的编码。互联网工程工作小组（IETF）要求所有互联网协议都必须支持UTF-8编码。它使用一至四个字节为每个字符编码
  >
  > ​		*编码规则*： 
  >
  > ​	 		128个US-ASCII字符，只需一个字节编码
  >
  > 			拉丁文等字符，需要二个字节编码
  > 	
  > 			大部分常用字（含中文），使用三个字节编码
  > 	
  > 			其他极少使用的Unicode辅助字符，使用四字节编码
  >
  > **小结：采用何种规则编码，就要采用对应规则解码，否则就会出现乱码**

  

那么这两种流都在什么情况下使用呢？

- 字节流一般用来处理图像、视频、音频、PPT、Word等类型的文件。字符流一般用于处理纯文本类型的文件，如TXT文件等，但不能处理图像视频等非文本文件。用一句话说就是：字节流可以处理一切文件，而字符流只能处理纯文本文件。

##### 按照功能(了解)：

- 节点流：直接操作数据读写的流类，比如`FileInputStream`

- 处理流：对一个已存在的流的链接和封装，通过对数据进行处理为程序提供功能强大、灵活的读写功能，例如`BufferedInputStream`（缓冲字节流）

  > 下图就很形象地描绘了节点流和处理流，处理流是对节点流的封装，最终的数据处理还是由节点流完成的。

  ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200921134307817.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L211X3dpbmQ=,size_16,color_FFFFFF,t_70#pic_left)

#### 3.文件流

##### 	(1)文件字节流

- `FileInputStream`：字节输入流

  - 构造方法

  ```java
  FileInputStream(File file) throws FileNotFoundException
  	//使用File对象创建文件输入流对象，若文件打开失败，将抛出异常。
  FileInputStream(String name) throws FileNotFoundException
  	//使用文件名或路径名字符串创建文件输入流对象，若文件打开失败，将抛出异常。
  ```

  - 创建方法：

  ```java
  //利用FileInputStream打开文件。
  FileInputStream  fis =new FileInputStream(“D:\\Java\\data.txt”);
  //或者
  File  myFile = new File(” D:\\Java\\data.txt”);
  FileInputStream  fis = new FileInputStream(myFile);
  //读取完毕后要关闭FileInputStream对象。
     myFileStream.close();
//使用文件输入流构造方法建立通往文件的输入流时，可能会出现错误（也被称为异常）。
  //try  { 
            //FileInputStream  ins = new  FileInputStream("myfile.dat"); 
        //}
  //catch (IOException e )
       //{    System.out.println("File read error:  " +e ); } 
  
  ```
  
  - 常用方法
  
  ```java
  int  read() throws IOException
  	//读取文件中的数据，一次读取一个字节，读取的数据作为返回值返回，若读到文件末尾则返回-1，可能抛出异常。
  int  read(byte[] b) throws IOException
  	//读取文件中的数据，将读到的数据存放到byte型数组中，并返回读取的字节的数量，未读到数据返回-1，可能抛出异常。
  void  close() throws IOException
  	//关闭流对象，可能抛出异常。
  ```
  

- `FileOutputStream`：字节输出流

  - 构造方法

  ```java
  FileOutputStream(File file) throws FileNotFoundException
  	//使用File对象创建文件输出流对象，如果文件打开失败，将抛出异常。
  FileOutputStream(File file, boolean append) throws FileNotFoundException
  	//使用File对象创建文件输出流对象，并由参数append指定是否追加文件内容，true为追加，false为不追加。
  FileOutputStream(String name) throws FileNotFoundException
  	//直接使用文件名或路径创建文件输出流对象。
  FileOutputStream(String name, boolean append) throws FileNotFoundException
  	//直接使用文件名或路径创建文件输出流对象，并由参数append指定是否追加。
  ```

  - 常用方法

  ```java
  void write(int b) throws IOException
  	//向文件中写入一个字节的数据，可能抛出异常
  void write(byte[] b) throws  IOException
  	//将byte数组中的数据全部写入到文件，可能抛出异常
  void write(byte b[], int off, int len) throws  IOException
  	//将字节数组从下标为off开始的len个元素写入到文件中
  void close() throws  IOException
  	//关闭流对象
  void flush( ) throws  IOException
  	//强制输出
  ```

- 注意：

  - `FileInputStream`类和`FileOutputStream`类是成对出现的
  - 由于采用字节方式进行数据传输，不必考虑数据的格式问题，这两个类对文件操作的效率较高

- 综合案例：

```java
import java.io.*;

public class copyfile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f = new File("1.txt");
		File f_d = new File("2.txt");
		byte[] b = new byte[1024];
		FileInputStream f_l = new FileInputStream(f);
		FileOutputStream f_d_l = new FileOutputStream(f_d);
		int i=0;
		while((i=f_l.read(b))!=-1){
			f_d_l.write(b, 0, i);
			System.out.print(new String(b,0,i));
		}
		f_l.close();
		f_d_l.close();
	}
}
//将文件1.txt复制到文件2.txt
```



##### 	(2)文件字符流

> ​	`FileInputStream`类和`FileOutputStream`类虽然可以高效率地读/写文件，但对于Unicode编码的文件，使用它们有可能出现乱码，因为汉字在文件中占用两个字节，如使用字节流，会出现乱码现象，而在Unicode字符中，一个汉字被看作一个字符。

- `FileReader`：字符输入流

  - 构造方法

  ```java
  FileReader(File file) throws FileNotFoundException
  	//使用File对象创建文件输入流对象。若文件打开失败将抛出异常。
  FileReader(String name) throws FileNotFoundException
  	//使用文件名或路径名字符串创建文件输入流对象，若文件打开失败将抛出异常。
  ```

  - 常用方法

  ```java
  boolean ready()
      //输入字符流是否可读
  int read() throws IOException
      //读取一个字符并返回该字符，如已达流的末尾则返回-1。 
  int read(char[] cbuf) throws IOException 
      //读取若干字符存入字符数组，如已达流的末尾则返回-1。 
  long skip(long n)
      //跳过n个字符
  void mark(int readAheadLimit)
      //在当前位置做一标记
  void reset()
      //将读取位置恢复到标记处
  void close()
      //关闭字符流
  ```

  - 创建方法

  ```java
  File file=new File("data\\b.txt");
  FileReader in = new FileReader(file);
  ```

- `FileWriter`：字符输出流

  - 构造方法

  ```java
  FileWriter(File file) throws IOException
  	//使用File对象创建文件输出流对象，如果文件打开失败，将抛出异常，必须捕捉
  FileWriter(File file, boolean append) throws IOException
  	//使用File对象创建文件输出流对象，并由参数append指定是否追加，异常情况同上
  FileWriter(String name) throws IOException
  	//直接使用文件名或路径创建文件输出流对象，异常情况同上
  FileWriter(String name, boolean append) throws IOException
  	//直接使用文件名或路径创建文件输出流对象，并由参数append指定是否追加，异常情况同上
  ```

  - 常用方法

  ```java
  void write(int c) throws IOException
      //输出一个字符
  void write(char[] cbuf) throws IOException 
      //输出字符数组
  void write(char[] cbuf, int off, int len) throws IOException 
      //输出字符数组cbuf中自位置off开始的len个字符
  void write(String str) throws IOException
      //输出字符串str
  void write(String str, int off, int len) throws IOException 
      //输出字符串str中自位置off开始的len个字符
  public writer append(char c) throws IOException 
      //将字符c写入流的末尾 
  void close()
      //关闭流
  void flush()
      //强行写入
  ```
  
  - 创建方法
  
  ```java
  File file=new File("data\\b.txt");
  FileWriter out= new FileWriter (file); 
  ```

- 综合案例：

```java
public class Demo_5 {

    public static void main(String[] args) {
        File f = new File("1.txt");
		File f_d = new File("2.txt");
        try {
            FileReader fr=new FileReader(f);    //创建一个fr对象
            FileWriter fw=new FileWriter(f_d);    //创建输出对象

            char []c=new char[1024];              //读入到内存
            int n=0;                              //记录实际读取到的字符数
            while((n=fr.read(c))!=-1){
                //String s=new String(c,0,n);
                fw.write(c,0,n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{

            try {
                fr.close();
                fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
//将文件1.txt复制到文件2.txt
```

#### 4.装饰流

#####   （1）概念：

> ​		实体流指直接连接数据源的流类。
>
> ​		装饰流指不直接连接数据源，而是以其它流对象为基础建立的流类。

​		装饰流不改变原来实体流对象中的数据内容，只是有一些功能的增强，如提高读写速度或者提供更多的读写格式。装饰流类不可以单独使用，必须配合实体流或装饰流使用。 

![image-20210128221420111](C:\Users\17159\AppData\Roaming\Typora\typora-user-images\image-20210128221420111.png)

##### （2）分类：

###### a. 缓冲流：

- 概念：程序与磁盘的交互相对于内存运算是很慢的，容易成为程序的性能瓶颈。减少程序与磁盘的交互，是提升程序效率一种有效手段。缓冲流，就应用这种思路：普通流每次读写一个字节，而缓冲流在内存中设置一个缓存区，缓冲区先存储足够的待操作数据后，再与内存或磁盘进行交互。这样，在总数据量不变的情况下，通过提高每次交互的数据量，减少了交互次数。

  > 联想一下生活中的例子，我们收作业，我们一本一本的交给老师更加高效，还是我们选一个课代表收齐了交给老师更高效，显然是后者。

- 优势：提高效率

  ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200921140759600.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L211X3dpbmQ=,size_16,color_FFFFFF,t_70#pic_left)

- 缓冲字节流：

  - 缓冲字节输入流`BufferedInputStream`类

    - 构造方法

      ```java
      public BufferedInputStream(InputStream in)
      	//构造方法，创建具有默认大小缓冲区的缓冲流
      public BufferedInputStream(InputStream in, int size)
      	//构造方法，创建具有指定缓冲区大小的缓冲流
      ```

      案例：

      ```java
      //联合使用文件流和缓冲流进行文件数据的读取
           FileInputStream inOne = new FileInputStream (“Student.txt”);  
           BufferedInputStream inTwo = BufferedInputStream (inOne);  
      //上面两条语句可以合并起来
           BufferedInputStream in = BufferedInputStream (new FileInputStream (“Student.txt”));
      ```
      

  - 缓冲字节输出流`BufferedOutputStream`类

    - 构造方法

      ```java
    public BufferedOutputStream(OutputStream out)
      	//创建具有默认大小缓冲区的缓冲流
    public BufferedOutputStream(OutputStream out, int size)
          //创建具有指定缓冲区大小的缓冲流
      ```
      
  案例：
      
  ```java
      //联合使用文件流和缓冲流进行文件数据的输出
         FileOutputStream outOne = new FileOutputStream (“Student.txt”);  
           BufferedOutputStream outTwo = BufferedOutputStream (outOne);
    //上面两条语句可以合并起来
           BufferedOutputStream out = BufferedOutputStream (new FileOutputStream (“Student.txt”));
      ```

- 综合案例：

  ```java
  import java.io.*;
  public class App6_10 {
  	public static void main(String[] args) throws IOException {
  	     File sourceFile = new File("1.txt"); 	// 源文件对象
  	     File destFile = new File("2.txt"); 	// 目的文件对象
  	     // 创建流
  	     BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile)); 
  	     BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile)); 
  	     byte[] buf = new byte[1024]; 		
           // 创建字节数组
  	     int i;
  	     while ((i = bis.read(buf)) != -1) { 	  	
               // 从输入流中读取数据
  		   bos.write(buf, 0, i); 		
               // 写入到输出流中
  	     }
  	     System.out.println("文件复制成功！");
  	     bis.close(); 				
  	     bos.close(); 							 
      }
  }
  //文件复制
  ```

- 缓冲字符流：

  - 缓冲字符流`BufferedReader`类

    - 构造方法

      ```java
      BufferedReader(Reader in)
      //将字符输入流包装成缓冲输入流
      ```

    - 创建方法：

      ```java
      //以FileReader流为参数创建BufferedReader流
      FileReader inOne = new FileReader(“Student.txt”);
      BufferedReader inTwo = BufferedReader(inOne);
      //或者，合二为一
      BufferedReader in = BufferedReader(new FileReader(“Student.txt));
      ```

    - 常用方法：

      ```java
      int read()         
           //读取单个字符。 
      int read(char[] cbuf,int off,int len)       
           //将字符读入数组的某一部分。 
      String readLine() throws IOException
        	//从缓冲输入流中读取一行字符，以字符串的形式返回(不包括回车符)，如果已到达流末尾，则返回 null。有可能抛异常，必须捕捉。
      void close() throws IOException
        	//关闭流对象，有可能抛异常，必须捕捉。
      boolean markSupported()        
          //判断此流是否支持 mark() 操作（它一定支持）。
      void mark(int readAheadLimit) 
          //标记流中的当前位置。 
      boolean ready()       
          //判断此流是否已准备好被读取。 
      void reset()        
          //将流重置到最新的标记。 
      long skip(long n)           
          //跳过字符。
      ```

  - 缓冲字符流`BufferedWriter`类

    - 构造方法

      ```java
      BufferedWriter (Writer out)
      	//将字符输入流对象包装成缓冲输入流对象
      ```

    - 创建方法：

      ```java
      //以FileWriter流为参数创建BufferedWriter流
      FileWriter inOne = new FileWriter(“Student.txt”);
      BufferedWriter inTwo = BufferedWriter(inOne);
      //或者，合二为一
      BufferedWriter in = BufferedWriter( new FileWriter(“Student.txt));

      ```
      
    - 常用方法
    
      ```java
      void  write(String str) throws IOException
      	//将一个字符串写入到缓冲输入流中，有可能抛异常，必须捕捉。
      void  newLine() throws IOException
      	//将一个回车换行符写入到文件中，从而达到换行的效果，有可能抛异常，必须捕捉。
      ```
    

- 综合案例：

  ```java
  public class Demo5 {
  	public static void main(String[] args) throws IOException {
  		// 创建高效的字符输入流
  		BufferedReader br = new BufferedReader(new FileReader("1.java"));
   
  		// 创建高效的字符输出流
  		BufferedWriter bw = new BufferedWriter(new FileWriter("2.java"));
   
  		// 一次读写一个字符
  //		int ch;
  //
  //		while ((ch = br.read()) != -1) {
  //			bw.write(ch);
  //		}
   
  		// 一次读写一个字符数组
  		char[] chs = new char[1024];
  		int len;
  		while((len = br.read(chs)) != -1){
  			bw.write(chs, 0, len);
  		}
  		// 释放资源
  		br.close();
  		bw.close();
  	}
  }
  //文件复制
  ```

###### b. 数据流：

- 概念：在前面的示例中，在向流中写入的数据必须首先转换为byte数组或char数组，当写入的数据比较少、比较简单时，则向流中写入数据时还不是很麻烦的，但是如果向流中写入数据比较多时，手动转换数据格式则会比较麻烦。为了简化程序员对于流的操作，使得程序员可以从繁杂的数据格式中解脱出来，在IO类中专门设计了两个类——`DataInputStream`/`DataOutputStream`类简化流数据的读写。

- 优势：方便读写基本类型的数据

- `DataOutputStream`类

  - 创建方法:

  ```java
  //DataOutputStream流将原始数据值转换为字节序列，再通过FileOutputStream将字节序列写到文件中。
  //创建DataOutputStream流
  File outFile=new File(“test.data”);
  FileOutputStream outFileStream=new FileOutputStream(outFile);
  DataOutputStream outDataStream= new DataOutputStream(outFileStream);
  //关闭DataOutputStream流
  outDataStream.close（）
  
  ```

  ![image-20210130193819044](C:\Users\17159\AppData\Roaming\Typora\typora-user-images\image-20210130193819044.png)

  - 常用方法：

  ```java
  void writeByte()		
      //写入byte型数据
  void writeBoolean()	
      //写入boolean型数据
  void writeShort()		
      //写入short型数据
  void writeChar()		
      //写入char型数据
  void writeInt()		
      //写入int型数据
  void writeLong()		
      //写入long型数据
  void writeFloat()		
      //写入float型数据
  void writeDouble()	
      //写入double型数据
  void writeUTF()		
      //写入字符串数据(UTF编码)
  void writeBytes()		
      //写入字符串数据
  void writeChars()	
      //写入字符串数据(UNICODE)
  ```

- `DataInputStream`类

  - 创建方法：

  ```JAVA
  //创建DataInputStream流
  File inFile=new File("test.data");
  FileInputStream inFileStream = new FileInputStream(inFile);
  DataInputStream  myDataStream = new DataInputStream(inFileStream);
  //关闭DataInputStream流
  myDataStream.close();
  
  ```

  

  ![image-20210130193830590](C:\Users\17159\AppData\Roaming\Typora\typora-user-images\image-20210130193830590.png)

  - 常用方法：

  ```java
  byte readByte()		 
      //读取byte型数据
  int readUnsignedByte()	  
      //读取unsignedbyte型数据
  short readShort()	  
      //读取short型数据
  int readUnsignedShort()  
      //读取unsignedshort型数据
  char readChar()		  
      //读取char型数据
  int readInt()		  
      //读取int型数据
  long readLong()		  
      //读取long型数据
  float readFloat()		  
      //读取float型数据
  double readDouble()	  
      //读取double型数据
  String readUTF()	  
      //读取UTF型数据
  ```

- 综合案例：

  ```java
  class datainput_output{
      public static void main(String args[]) throws IOException{
               //写入到文件
               FileOutputStream fos=new FileOutputStream("a.txt");
               DataOutputStream dos=new DataOutputStream (fos);
          
               try{     
                  dos.writeBoolean(true);          
  		 		dos.writeByte((byte)123);
  		  		dos.writeChar('J');
  		  		dos.writeDouble(3.141592654);
  		  		dos.writeFloat(2.7182f);
  		  		dos.writeInt(1234567890);
  		  		dos.writeLong(998877665544332211L);
  		  		dos.writeUTF("您好！");
  	  	 	}
              catch(Exception e) {  
                  System.out.println("error"); 
              }
              finally{  
                  dos.close(); 
              }
              //从文件中读取
  			DataInputStream dis=new DataInputStream(new FileInputStream("a.txt"));
  			try{ 	
                  System.out.println("\t "+dis.readBoolean());
  				System.out.println("\t "+dis.readByte());
  	    		System.out.println("\t "+dis.readChar());
  	    		System.out.println("\t "+dis.readDouble());
  	    		System.out.println("\t "+dis.readFloat());
  	    		System.out.println("\t "+dis.readInt());
  	    		System.out.println("\t "+dis.readLong());
  	    		System.out.println("\t "+dis.readUTF());		
              } 
  	       catch(Exception e){
                 System.out.println(“error”);
             }
             finally {  dis.close();
                }
     }
  }
  ```

  

  > 注意：
  >
  > - 这两个类必须匹配起来使用。
  >   （只有使用`DataOutputStream`流格式写入的数据，在实际读取时才可以使用`DataInputStream`进行读取。）
  > - 读和写的顺序要一致

###### c.对象流：

- 概念：用于存储和读取基本数据类型数据对象的处理流。它的强大之处就是可以把Java 中的对象写入到数据源中,也能把对象从数据源中还原回来。

- 优势：方便对象的读写

- 对象序列化：是指将一个对象的属性和方法转化为 一种序列化的格式用于存储和传输。**对象要想实现序列化，其所属的类必须实现`Serializable`接口**。如果要**定制对象的序列化和反序列化过程，需要实现`Externalizable`接口**。

  - `ObjectOutputStream`类:`ObjectOutputStream`既可以输出对象，又可以输出基本类型的数据。 

    - 创建方法:

    ```java
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("a.txt"));
    Employe em = new Employe("xiaoming","123");
    oos.writeObject(em);
    oos.close();
    ```

    - 常用方法：

    ```java
    void write(byte[] buf) 
    //输出一个 byte 数组
    void write(int val) 
    //输出一个字节
    void writeChar(int val)
    //输出一个char 值
    void writeDouble(double val) 
    //输出一个double 值
    Object writeObject(Object obj)
    //输出一个对象
    ```

  > - 对象序列化时，不保存关键字transient和static类型的变量。
  > - transient关键字只能修饰变量，而不能修饰方法和类

  案例（`Serializable`）：

  ```java
  import java.io.*;
  class Book implements Serializable   {
  	int id;
  	String name;
  	String author;
  	float price;  
      //transient float price;(transient变量不保存)
      //将图书类的成员变量price声明为临时变量。再运行程序，输出结果中其他成员变量的值不变，只有价格一项变为0.0，这是因为临时变量不保存。这对于保护重要的信息（例如密码等）是很有必要的。
  	public Book() {
  	}
  	public Book(int id,String name,String author,float price) {
  		this.id=id;
  		this.name=name;
  		this.author=author;
  		this.price=price;
  	}
  }
  class BookEx {
  	public static void main(String args[]) throws  Exception {
  	    Book book1 = new Book(100032,"Java","Li Si",30);
  	    ObjectOutputStream  oos = new ObjectOutputStream(new FileOutputStream("book.txt"));       
          oos.writeObject(book1);
      	oos.close(); 	
  	    ObjectInputStream  ois = new ObjectInputStream(new FileInputStream("book.txt"));    
          Book book2 = (Book)ois.readObject(); 
  	    ois.close(); 
   	    System.out.println("ID is:"+book2.id);  
  	    System.out.println("name is:"+book2.name);
  	    System.out.println("author is:"+book2.author);
  	    System.out.println("price is:"+book2.price);
  	}
  }
  //ID is: 100032
  //name is: Java
  //author is: Li Si
  //price is: 30.0
  ```

- 反序列化：在需要的时候，再将对象重构出来

  - `ObjectInputStream`类:`ObjectInputStream`即可以读入对象，又可以读入基本类型的数据。 

  ![image-20210130195423562](C:\Users\17159\AppData\Roaming\Typora\typora-user-images\image-20210130195423562.png)

  - 创建方法：

  ```java
  FileInputStream in = new FileInputStream(“out.data");
  ObjectInputStream ois = new ObjectInputStream(in);
  //或者
  ObjectInputStream ois = new ObjectInputStream(new FileInputStream("out.data"););
  String s= (String)ois.readObject();
  Date date = (Date)ois.readObject();// 需要进行类型转换
  ```

  - 常用方法：

  ```java
  byte readByte() 
  //读取一个字节
  char readChar() 
  //读取一个字符
  double readDouble() 
  //读取一个double值
  Object readObject()
  //读取一个对象
  ```

  

  > - `Externalizable`接口继承了`Serializable`接口
  >
  > - 实现`Externalizable`接口可以控制对象的读写。
  >
  > - `Externalizable`接口包含两个方法 `writeExternal()`和`readExternal()`，实现接口的类必须实现这两个方法。
  >
  > - 一个类实现了`Externalizable`接口
  >
  > - 当采用`ObjectOutputStream`流输出对象时，会自动调用`writeExternal()`方法；
  >
  > - 当采用`ObjectInputStream`流输入对象时，会自动调用`readExternal()`方法。

  综合案例（`Externalizable`）：

  ```java
  class Book implements Externalizable {
  	int id;
  	String name;
  	String author;
  	transient float price;
  	public Book() {
  	}
  	public Book(int id, String name, String author, float price) {
      	this.id = id;
      	this.name = name;
      	this.author = author;
      	this.price = price;
  	}
  	// 当序列化对象时(使用对象输出流)，writeExternal()方法被自动调用
  	public void writeExternal(ObjectOutput out) throws IOException {
  		Date date = new Date();
  		out.writeObject(date); 		// 输出非自身的变量
  		out.writeObject(name);      //ObjectOutputStream既可以输出对象，又可以输出基本类型的数据。
  		out.writeObject(author);
  }
  	// 当反序列化对象时(使用对象输入流)，readExternal()方法被自动调用
  	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
  		Date date = (Date) in.readObject();
    		System.out.println(date);
    		this.name = (String) in.readObject();
    		this.author = (String) in.readObject();
    	}
  }
  class BookEx {
   public static void main(String args[]) throws Exception {
      Book book1 = new Book(100032, "Java", "Li Si", 30);
      ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("book.txt"));
      oos.writeObject(book1);
      oos.close();
  
      ObjectInputStream ois = new ObjectInputStream(new FileInputStream("book.txt"));
      Book book2 = (Book) ois.readObject();
      ois.close();
       
      System.out.println("name is:" + book2.name);
      System.out.println("author is:" + book2.author);
   }
  }
    //Sun Jan 15 12:25:12 CST 2017
    //name is: Java
    //author is: Li Si
  ```

  

- 注意：

    > 对象输入流和对象输出流必须配合使用
    >
    > 主要用于对象数据，也可以是基本数据类型的读写。
    >
    > 一个类实现Serializable接口后才能进行序列化
    >
    > 如果要定制对象的序列化和反序列化过程，需要实现Externalizable接口。

###### d.序列流

- 概念：也称为合并流，对多个流进行合并。 `SequenceInputStream `表示其他输入流的逻辑串联。它从输入流的有序集合开始，并从 　第一个输入流开始读取，直到到达文件末尾，接着从第二个输入流读取，依次类推，直到到达包含的最后一个输入流的文件末尾为止。

- 优势：没有使用序列流时如果读取两个输入流时，读取过程的操作降低了代码的复用性

- 构造方法：

  ```java
  SequenceInputStream(InputStream s1, InputStream s2) 
  //整合两个输入流
  SequenceInputStream(Enumeration<? extends InputStream> e) 
  //整个多个输入流
  ```

  - 案例：利用序列流来整合两个文件

  ```java
  public static void main(String[] args) throws IOException {
  		
  		FileInputStream fis1 = new FileInputStream("xxx.txt");
  		FileInputStream fis2 = new FileInputStream("yyy.txt");
  		//将两个流整合成一个流
  		SequenceInputStream sis = new SequenceInputStream(fis1, fis2);
  		FileOutputStream  fos = new FileOutputStream("zzz.txt");
  		int b;
  		while((b = sis.read())!=-1){
  			fos.write(b);
  		}
  		//sis在关闭的时候，在构造方法中传入的值也会闭掉
  		sis.close();
  		fos.close();
  }
  ```

  

  ![640?wx_fmt=jpeg](https://ss.csdn.net/p?https://mmbiz.qpic.cn/mmbiz_jpg/bcPwoCALib9JeHIysnpXDMxGyOgPHoArOZuWIF4iaHNicmXSSVUba57lPE0t3rL9AkfpHnLkq1eJ3w7kOmKF7UTqQ/640?wx_fmt=jpeg)

  - 案例：序列流整合多个？（利用枚举）

  ```java
  public static void main(String[] args) throws IOException {
  	FileInputStream fis1 = new FileInputStream("xxx.txt");	//创建输入流对象,关联a.txt
  	FileInputStream fis2 = new FileInputStream("yyy.txt");	//创建输入流对象,关联b.txt
  	FileInputStream fis3 = new FileInputStream("zzz.txt");	//创建输入流对象,关联c.txt
  	Vector<InputStream> v = new Vector<>();					//创建vector集合对象
  	v.add(fis1);											//将流对象添加
  	v.add(fis2);
  	v.add(fis3);
  	Enumeration<InputStream> en = v.elements();				//通过Vector获取迭代器
  	SequenceInputStream sis = new SequenceInputStream(en);	//传递给SequenceInputStream构造
  	FileOutputStream fos = new FileOutputStream("ooo.txt");
  	int b;
  	while((b = sis.read()) != -1) {
  		fos.write(b);
  	}
  
  	sis.close();
  	fos.close();
}
  ```

  
  
  ![640?wx_fmt=jpeg](https://ss.csdn.net/p?https://mmbiz.qpic.cn/mmbiz_jpg/bcPwoCALib9JeHIysnpXDMxGyOgPHoArOC6ozRs1EicJeQsqatRUZibLBTMO24PJWPURBkaB1Es4XxOUudmPDDJ2w/640?wx_fmt=jpeg)

###### e.内存输出流

- 概念：文件流的操作是对文件进行操作，除了文件，IO也可以对内存进行操作，这种流称之为内存流。该输出流可以向内存中写数据, 把内存当作一个缓冲区, 写出之后可以一次性获取出所有数据（一般应用在聊天）

- 构造函数：

  ```java
  ByteArrayOutputStream()
      //创建的“字节数组输出流”对应的字节数组大小是32。
  ByteArrayOutputStream(int size)
      //创建“字节数组输出流”，它对应的字节数组大小是size。
  ```

- 常用方法：

  ```java
  void write(byte[] buffer, int offset, int len)
      //将字节数组buffer写入到输出流中，offset是从buffer中读取数据的起始偏移位置，len是读取的长度。
  void write(int oneByte)
      //的作用将int类型的oneByte换成byte类型，然后写入到输出流中。
  void writeTo(OutputStream out)
      //将此 byte 数组输出流的全部内容写入到指定的输出流参数中，这与使用 out.write(buf, 0, count) 调用该输出流的 write 方法效果一样。
  byte[] toByteArray()
      //创建一个新分配的 byte 数组。
  String toString(String charsetName)
      //使用指定的 charsetName(编码集)，通过解码字节将缓冲区内容转换为字符串。
  String toString()
      //使用平台默认的字符集，通过解码字节将缓冲区内容转换为字符串。
  void reset()
      //将此 byte 数组输出流的 count 字段重置为零，从而丢弃输出流中目前已累积的所有输出。
  int size()
      //返回缓冲区的当前大小。
  void close()
      //关闭 ByteArrayOutputStream 无效。
  ```

  案例（创建方法）：

  ```java
  import java.io.*;
  public class Test1 {
      public static void main(String[] args) throws IOException {
          //1,reda(byte[] b)是字节输入流的方法,创建FileInputStream,关联a.txt
          FileInputStream fis = new FileInputStream("a.txt");
          //2,创建内存输出流,将读到的数据写到内存输出流中
          ByteArrayOutputStream baos = new ByteArrayOutputStream();
          //3,创建字节数组,长度为5
          byte[] arr = new byte[5];
          int len;
          while((len = fis.read(arr)) != -1) {
              baos.write(arr, 0, len);
   			//System.out.println(new String(arr,0,len));
          }
          //4,将内存输出流的数据全部转换为字符串打印
          System.out.println(baos);            //即使没有调用,底层也会默认帮我们调用toString()方法
          //5,关闭输入流
          fis.close();
      }
  ```

  案例（常用方法）：

  ```java
  import java.io.IOException;
  import java.io.OutputStream;
  import java.io.ByteArrayOutputStream;
  import java.io.ByteArrayInputStream;
  
  public class ByteArrayOutputStreamTest {
  
      private static final int LEN = 5;
      // 对应英文字母“abcddefghijklmnopqrsttuvwxyz”
      private static final byte[] ArrayLetters = {
          0x61, 0x62, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68, 0x69, 0x6A, 0x6B, 0x6C, 0x6D, 0x6E, 0x6F,
          0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 0x78, 0x79, 0x7A
      };
  
      public static void main(String[] args) {
          //String tmp = new String(ArrayLetters);
          //System.out.println("ArrayLetters="+tmp);
  
          tesByteArrayOutputStream() ;
      }
  
      private static void tesByteArrayOutputStream() {
          // 创建ByteArrayOutputStream字节流
          ByteArrayOutputStream baos = new ByteArrayOutputStream();
  
          // 依次写入“A”、“B”、“C”三个字母。0x41对应A，0x42对应B，0x43对应C。
          baos.write(0x41);
          baos.write(0x42);
          baos.write(0x43);
          System.out.printf("baos=%s\n", baos);
  
          // 将ArrayLetters数组中从“3”开始的后5个字节写入到baos中。
          // 即对应写入“0x64, 0x65, 0x66, 0x67, 0x68”，即“defgh”
          baos.write(ArrayLetters, 3, 5);
          System.out.printf("baos=%s\n", baos);
  
          // 计算长度
          int size = baos.size();
          System.out.printf("size=%s\n", size);
  
          // 转换成byte[]数组
          byte[] buf = baos.toByteArray();
          String str = new String(buf);
          System.out.printf("str=%s\n", str);
  
          // 将baos写入到另一个输出流中
          try {
              ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
              baos.writeTo((OutputStream)baos2);
              System.out.printf("baos2=%s\n", baos2);
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
  }
  //baos=ABC
  //baos=ABCdefgh
  //size=8
  //str=ABCdefgh
  //baos2=ABCdefgh
  ```

###### g.打印流

- 概念：`PrintStream`只负责输出数据，不负责读取数据

- 优势：打印流是输出信息最方便的类，永远不会抛出`IOException`,有一个构造方法可以直接接收`OutputStream`类的实例，与`OutputStream`相比起来，`PrintStream`可以更方便的输出数据，相当于把`OutputStream`类重新包装了一下，使之输出更方便。

- 构造方法：

  ```java
  PrintWriter(String fileName) 
  //使用指定的文件名创建一个新的PrintWriter，而不需要自动执行刷新
  PrintWriter(Writer out, boolean autoFlush)
  //创建一个新的PrintWriter，out：字符输出流，autoFlush： 一个布尔值，如果为真，则println，printf,或format方法将刷新输出缓冲区 
  ```

- 子承父类的方法：

  ```java
  public void close():  
  //关闭此输出流并释放与此流相关联的任何系统资源
  public void flush():  
  //刷新此输出流并强制任何缓冲流的输出字节被写入
  public void write(byte[] b):  
  //将b.leng字节从指定的字节数组写入此输出流
  public void write(byte[] b,int off,int len):  
  //从指定的字节数组写入len字节，从偏移量off开始输出到此输出流
  public abstract void write(int b):  
  //将指定的字节写入此流。
  ```

- 特有方法：

  ```java
  void print(boolean b) 
       //打印 boolean 值。
  void println(boolean x) 
       //打印 boolean 值，然后终止行。
  PrintStream printf(String format, Object... args) 
       //使用指定格式字符串和参数将格式化的字符串写入此输出流的便捷方法。
  PrintStream format(Locale l, String format, Object... args) 
       //使用指定格式字符串和参数将格式化字符串写入此输出流中。 
  ```

- 分类：

  - 字节打印流：`PrintStream`

  案例：

  ```java
  import java.io.FileNotFoundException;
  import java.io.FileOutputStream;
  import java.io.PrintStream;
  import java.text.SimpleDateFormat;
  import java.util.Date;
  
  public class PrintStreamTest {
  
  	public static void main(String[] args) throws FileNotFoundException {
  		try {
  		    int[] arr=new int[-1];     //出错行13
  		} catch (Exception e) {
  			Date d=new Date();
  			SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日hh:mm:ss SS");
  			String line = sdf.format(d);
  			PrintStream ps=new PrintStream(new FileOutputStream("log.txt"));
  			ps.println(line);
  			e.printStackTrace(ps);
  			ps.close();
  		}
  	}
  
  }
  //利用字节输出流输出异常信息
  ```

  ![image-20210201002617195](C:\Users\17159\AppData\Roaming\Typora\typora-user-images\image-20210201002617195.png)

  - 字符打印流：`PrintWriter`

  案例：

  ```java
  import java.io.*;
   
  public class Copy4 {
      public static void main(String[] args) throws IOException{
          BufferedReader br = new BufferedReader(new FileReader("1.java"));
          PrintWriter pw = new PrintWriter(new FileWriter("2.txt"),true);
          String line ;
          while ((line=br.readLine())!= null){
              pw.println(line);
          }
          pw.close();  //因为是字符流，所以需要刷新，但是pw.close()方法里已经包含pw.flush()方法了，所以不需要再调用了。
  //如果pw.flush()方法和pw.close()方法都没调用，但是数据还是写进文件里了，是因为构造参数里的true，设置为了刷新，所以会把数据写入。
          br.close();
      }
  }
  //文件复制，相较于文件字符流简洁很多
  ```

  

###### h.标准输入输出流

- 概念：Java通过系统类`System`实现标准输入/输出的功能，定义了3个流变量:`in`,`out`,和`err`.这3个流在Java中都定义为静态变量，可以直接通过`System`类进行调用。

  - `System.in`表示标准输入，通常指从键盘输入数据；

    - 常见方法：

      ```java
      //从键盘接受数据
      int read() 
      int read(byte b[]) 
      int read(byte b[],int offset,int len)
      ```

      案例：

      ```java
      import java.io.IOException;
      public class StdInput{
          public static void main(String[] args) throws IOException 
          {
              System.out.println("input:");
              byte b[]=new byte[512];
              int count=System.in.read(b);
              System.out.println("Output");
              for(int i=0;i<count;i++)
              {
                  System.out.print(b[i]+" ");
              }
              System.out.println();
              for(int i=0;i<count;i++)
              {
                  System.out.print((byte)b[i]+" ");
              }
              System.out.println("count="+count);
          }
      }
      //程序运行时，从键盘输入4个字符abcd并按Enter键，保存在缓冲区b中的元素个数count为6，Enter占用最后两个字节
      //input: 
      //abcd 
      //Output 
      //97 98 99 100 13 10 
      //97 98 99 100 13 10 count=6
      ```

      > 不过System.in却是一个没有被包装过的未经加工的`InputStream`，也就是说在使用`System.in`之前必须对其进行包装。

      案例：

      ```java
      public static void in() throws IOException {
      		
      	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      		
      	System.out.print("请输入一个整数 ： " );
      	int integer = Integer.parseInt(br.readLine());
      	System.out.println("您输入的整数是 ： " + integer);
      	System.out.println();
      	
      	System.out.print("请输入一个小数 ： " );
      	double decimal = Double.parseDouble(br.readLine());
      	System.out.println("您输入的小数是 ： " + decimal);
      	System.out.println();
      	
      	System.out.print("请输入一个字符串：");
      	String line = br.readLine();
      	System.out.println("您输入的字符串是 ： " + line);
      		
      	// 释放资源
      	br.close();
      		
      }
      ```

      ![img](https://img-blog.csdn.net/20180204142202671?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvTGVleGljaGFuZw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)

      > 上面方法虽然也能实现从控制台输入任意类型数据，但是比较麻烦，需要我们自己将字符串解析成任意类型数据，也可能会出现`NumberFormatException`异常，所以一般我们不这样用。JDK1.5给我们提供了`Scanner`，我们可以很方便的使用`Scanner`从控制台输入任意类型数据。

      案例:

      ```java
      public static void in2() throws IOException {
      		
      	Scanner sc = new Scanner(System.in);
      		
      	System.out.print("请输入一个整数 ： " );
      	int integer = sc.nextInt();
      	System.out.println("您输入的整数是 ： " + integer);
      	System.out.println();
      		
      	System.out.print("请输入一个小数 ： " );
      	double decimal = sc.nextDouble();
      	System.out.println("您输入的小数是 ： " + decimal);
      	System.out.println();
      	
      	System.out.print("请输入一个字符串：");
      	sc.nextLine();
      	String line = sc.nextLine();
      	System.out.println("您输入的字符串是 ： " + line);
      	System.out.println();
      		
      	// 释放资源
      	sc.close();
      }
      ```

      ![img](https://img-blog.csdn.net/20180204142327276?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvTGVleGljaGFuZw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)

      

  - `System.out`表示标准输出，通常指把数据输出到控制台或者屏幕，其本质为`PrintStream`（怎么用打印流就怎么用`System.out`语句）；

    - 常见方法：

    ```java
    public void print(int i); 
    public void println(int i); 
    ```

    案例：

    ```java
    //常见的
        System.out.print();
    	System.out.println();
    ------------------------------------
    //等价的
        PrintStream ps = System.out;
    	ps.println(47);		// 往控制台输出int类型数据
    	ps.println(13.14);	// 往控制台输出double类型数据
    	ps.println("I love java");	// 往控制台输出string类型数据 		
    ```

    > 由于`System.out`是一个`PrintStream`，而`PrintStream`是一个`OutputStream`，也就是说`System.out`是一个字节流。为了使用起来更加高效快捷，我们完全可以将`System.out`包装成`PrintWriter`。

    案例：

    ```java
    public static void out2() {
    		
    	PrintWriter pw = new PrintWriter(System.out, true);
    	//第二个参数设置为true表示开启自动刷新，否则，可能由于输出的数据小于缓冲区的大小而导致数据暂时存放于缓冲区中，从而看不到数据的输出。	
    	pw.println(47);		// 往控制台输出int类型数据
    	pw.println(13.14);	// 往控制台输出double类型数据
    	pw.println("I love java");	// 往控制台输出string类型数据 	
    		
    }	
    ```

综合案例：

```java
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

class Log {
	public static void writeLog(String msg) {
		PrintStream out = null;
		try {
			out = new PrintStream(new FileOutputStream("log.txt", true));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// 改变输出方向，使得标准输出流不再指向控制台，指向log文件
		System.setOut(out);
		// 当前日期时间
		Date nowtime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String strTime = sdf.format(nowtime);
		System.out.println(strTime + ":" + msg);
	}
}

public class LogTest {
	public static void main(String[] args) {
		Log.writeLog("7点起床");
		Log.writeLog("然后去吃早饭");
	}
}
//2021-01-31 13:21:04:7点起床
//2021-01-31 13:21:04:然后去吃早饭
```

- `System.err`表示标准错误输出，通常指把数据输出到控制台或者屏幕，其本质为`PrintStream`。

  > `System.err.println`只能在屏幕上实现打印，即使你重定向了也一样。
  > 你使用`err`打印出的 字符串，在eclipse的console会显示成红色的哦。

# IO流的非流式部分：随机访问文件流

- 概念： `RandomAccessFile`类不属于流，是Object类的子类，支持随机访问文件的读取和写入。我们以前讲的 IO 字节流，包装流等都是按照文件内容的顺序来读取和写入的。而这个随机访问文件流我们可以再文件的任意地方写入数据，也可以读取任意地方的字节。

- 构造方法：

  ```java
  RandomAccessFile(File file, String mode):
  //创建从中读取和向其中写入（可选）的随机访问文件流，该文件由 File 参数指定。
  RandomAccessFile(String name, String mode):
  //创建从中读取和向其中写入（可选）的随机访问文件流，该文件具有指定名称。
  ```

  > mode 参数指定用以打开文件的访问模式。允许的值及其含意为：
  >
  > | 值    | 含意                                                         |
  > | ----- | ------------------------------------------------------------ |
  > | "r"   | 以只读方式打开。调用结果对象的任何 write 方法都将导致抛出 `IOException`。(不会创建文件。会去读取一个已存在文件，如果该文件不存在，则会出现文件找不到异常`FileNotFoundException`。) |
  > | "rw"  | 打开以便读取和写入。如果该文件尚不存在，则尝试创建该文件。(操作的文件不存在，会自动创建；如果文件存在则不会覆盖。) |
  > | "rws" | 打开以便读取和写入，对于 "rw"，还要求对文件的内容或元数据的每个更新都同步写入到底层存储设备。 |
  > | "rwd" | 打开以便读取和写入，对于 "rw"，还要求对文件内容的每个更新都同步写入到底层存储设备。 |

- 常用方法：

  ```java
  void seek(long pos):
  //设置到此文件开头测量到的文件指针偏移量，改变指针的位置,在该位置发生下一个读取或写入操作。
  long getFilePointer():
  //返回此文件中的当前偏移量，获取指针位置。
  int skipBytes(int n):
  //尝试跳过输入的 n 个字节以丢弃跳过的字节。 
  void write(byte[] b):
  //将 b.length 个字节从指定 byte 数组写入到此文件，并从当前文件指针开始。
  void writeInt(int v):
  //按四个字节将 int 写入该文件，先写高字节。
  int read(byte[] b):
  //将最多 b.length 个数据字节从此文件读入 byte 数组。
  int readInt():
  //从此文件读取一个有符号的 32 位整数。
  ```

  案例：

  ```java
  import java.io.File ;
  import java.io.RandomAccessFile ;
  public class RandomAccessFileDemo01{
  	// 所有的异常直接抛出，程序中不再进行处理
  	public static void main(String args[]) throws Exception{
  		File f = new File("test.txt") ;	// 指定要操作的文件
  		RandomAccessFile rdf = new RandomAccessFile(f,"rw") ;// 读写模式，如果文件不存在，会自动创建
  		String name = null ;
  		int age = 0 ;
  		name = "zhangsan" ;			// 字符串长度为8
  		age = 30 ;					// 数字的长度为4
  		rdf.writeBytes(name) ;		// 将姓名写入文件之中
  		rdf.writeInt(age) ;			// 将年龄写入文件之中
  		name = "lisi    " ;			// 字符串长度为8
  		age = 31 ;					// 数字的长度为4
  		rdf.writeBytes(name) ;		// 将姓名写入文件之中
  		rdf.writeInt(age) ;			// 将年龄写入文件之中
  		name = "wangwu  " ;			// 字符串长度为8
  		age = 32 ;					// 数字的长度为4
  		rdf.writeBytes(name) ;		// 将姓名写入文件之中
  		rdf.writeInt(age) ;			// 将年龄写入文件之中
  		rdf.close() ;				// 关闭
  	}
  }
  public class RandomAccessFileDemo02{
  	// 所有的异常直接抛出，程序中不再进行处理
  	public static void main(String args[]) throws Exception{
  		File f = new File("test.txt") ;	// 指定要操作的文件
  		RandomAccessFile rdf = new RandomAccessFile(f,"r") ;// 以只读的方式打开文件
  		String name = null ;
  		int age = 0 ;
  		byte b[] = new byte[8] ;	// 开辟byte数组
  		// 读取第二个人的信息，意味着要空出第一个人的信息
  		rdf.skipBytes(12) ;		// 跳过第一个人的信息
  		for(int i=0;i<b.length;i++){
  			b[i] = rdf.readByte() ;	// 读取一个字节
  		}
  		name = new String(b) ;	// 将读取出来的byte数组变为字符串
  		age = rdf.readInt() ;	// 读取数字
  		System.out.println("第二个人的信息 --> 姓名：" + name + "；年龄：" + age) ;
  		// 读取第一个人的信息
  		rdf.seek(0) ;	// 指针回到文件的开头
  		for(int i=0;i<b.length;i++){
  			b[i] = rdf.readByte() ;	// 读取一个字节
  		}
  		name = new String(b) ;	// 将读取出来的byte数组变为字符串
  		age = rdf.readInt() ;	// 读取数字
  		System.out.println("第一个人的信息 --> 姓名：" + name + "；年龄：" + age) ;
  		rdf.skipBytes(12) ;	// 空出第二个人的信息
  		for(int i=0;i<b.length;i++){
  			b[i] = rdf.readByte() ;	// 读取一个字节
  		}
  		name = new String(b) ;	// 将读取出来的byte数组变为字符串
  		age = rdf.readInt() ;	// 读取数字
  		System.out.println("第三个人的信息 --> 姓名：" + name + "；年龄：" + age) ;
  		rdf.close() ;				// 关闭
  	}
  };
  ```

  ![img](https://img-blog.csdn.net/20160714225931644?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)

# Properties

- 概念：是一个Map体系的集合类，Properties可以保存到流中或从流中加载，属性列表中的每个键及其对应的值都是一个字符串

- 构造方法：

  ```java
  Properties()	
      //它将创建一个没有默认值的空属性列表。
  Properties(Properties defaults)	
      //它将创建具有指定默认值的空属性列表。
  ```

- 特有方法：

  ```java
  Object setProperty(String key, String value)
  //设置集合的键和值，都是String类型，底层调用 Hashtable方法 put
  String getProperty(String key)
  //使用此属性列表中指定的键搜索属性
  Set<String> stringPropertyNames()
  //从该属性列表中返回一个不可修改的键集，其中键及其对应的值是字符串
  ```

- Properties和IO流结合的方法：

  ```java
  void load(InputStream inStream)
  //从输入字节流读取属性列表（键和元素对）
  void load(Reader reader)
  //从输入字符流读取属性列表（键和元素对）
  void store(OutputStream out,String comments)
  //将此属性列表（键和元素对）写入此 Properties表中，以适合于使用 load(InputStream)方法的格式写入输出字节流
  void store(Writer writer,String comments)
  //将此属性列表（键和元素对）写入此 Properties表中，以适合使用 load(Reader)方法的格式写入输出字符流
  ```

  案例：

  ```java
  public class PropertiesDemo03 {
      public static void main(String[] args) throws IOException {
          
          myLoad();
          myStore();
      }
   
      private static void myLoad() throws IOException {
          Properties prop = new Properties();
   
          //void load(Reader reader)：
          FileReader fr = new FileReader("fr.txt");
          prop.load(fr);			//读取fr文件中的键值对
          fr.close();
   
          System.out.println(prop);  
      }
   
      private static void myStore() throws IOException {
        Properties prop = new Properties();
   
          prop.setProperty("leon001","林青霞");
          prop.setProperty("leon002","张曼玉");
          prop.setProperty("leon003","王祖贤");
   
          //void store(Writer writer, String comments)：
          FileWriter fw = new FileWriter("fw.txt");
          prop.store(fw,null);			//写入以上键值对到fw文件
          fw.close();
      }
  }
  ```
  

- 综合案例：

  > 用`Properties`读取配置文件非常简单。Java默认配置文件以`.properties`为扩展名，每行以`key=value`表示，以`#`课开头的是注释。以下是一个典型的配置文件：

  > ```
  > # setting.properties
  > last_open_file=/data/hello.txt
  > auto_save_interval=60
  > ```
  >
  > 用`Properties`读取配置文件，一共有三步：
  >
  > 1. 创建`Properties`实例；
  > 2. 调用`load()`读取文件；
  > 3. 调用`getProperty()`获取配置。
  >
  > ###### 写入配置文件
  >
  > 如果通过`setProperty()`修改了`Properties`实例，可以把配置写入文件，以便下次启动时获得最新配置。写入配置文件使用`store()`方法：

```java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

import junit.framework.TestCase;

public class PropertiesTester extends TestCase {

    public void writeProperties() {
        Properties properties = new Properties();
        OutputStream output = null;
        try {
            output = new FileOutputStream("config.properties");
            properties.setProperty("url", "jdbc:mysql://localhost:3306/");
            properties.setProperty("username", "root");
            properties.setProperty("password", "root");
            properties.setProperty("database", "users");//保存键值对到内存
            properties.store(output, "这是写入的properties注释");// 保存键值对到文件中
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
//配置.properties文件
```

