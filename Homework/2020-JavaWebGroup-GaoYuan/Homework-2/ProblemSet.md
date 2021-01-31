# ProblemSet

1. `Calendar`类

获取任意一年的二月有多少天，给点思路： 
- 键盘录入任意的年份
-  设置日历对象的年、月、日
    - 年：来自于键盘录入
    - 月：设置为3月，月份是从0开始的，所以设置的值是2
    - 日：设置为1日
-  3月1日往前推一天，就是2月的最后一天
-  获取这一天输出即可

2. `Vector<Course>`

- 课程管理每学期都要开设多门课程，每门课程的信息包括课程名称（`String`）、是否是必修课（`boolean`）、授课教师（`String`）、学时（`int`）、学分（`float`）
- 编程实现对课程信息进行创建、添加、删除、修改和查询操作
- 可以按课程名、是否是必修课、授课教师来进行查询
- 修改或删除之前要先查询

3. Regular Expression

输入我的手机号是`18837112195`，曾经用过`18888888888`，还用过`18812345678`（号码随意，形式一样就行），思路如下：

- 首先利用获取功能提取出现在用的手机号
- 其次匹配功能检验该手机号是否符合：第一位为1，第二位为（3,4,5,7,8,9）中的一个，后面9位为任意0-9的数字
- 其次利用字符串替换功能，将中间四位用`*`号加密，比如`18837112195` ——> `188****2195`

4. 枚举类

编写菜单系统模拟点菜：编写三个枚举类（前菜类（`SALAD`，`SOUP`，`SPRING_ROLLS`）、主菜类（`LASAGNE`，`BURRITO`，`PAD_THAI`，`LENTILS`）、甜点类（`BLACK_FOREST_CAKE`，`FRUIT`））实现一个`Menu`接口，通过括号赋值来定义菜价比如`SALAD(35.0)`，主函数实现点菜流程，每个菜类各点一道菜，最终计算总消费（一个消费对象即可）

5. `Calendar`类，`Date`类，`SimpleDateFormat`类

修改上周身份证号的作业中将提取的出生年月日转化为年龄输出

6. 有一个给出`Student`类，在`Test`类里面利用反射机制实现以下操作：
	
	1. 创建`Student`类的`Class`对象
	2. 获取完整`Student`类名并输出
	3. 调用无参构造方法创建`Student`类的实例化对象`stu1`
	4. 调用有参构造方法创建`Student`类的实例化对象`stu2`
	5. 获取类全部属性信息，并修改
	6. 获取全部方法信息
	7. 调用类中无参方法`display()`
	8. 调用类中有参方法`say()`
	9. 通过反射来操作属性，设置名字为`Bob`

```Java
public class Student {
	private String name;
	private int age;

	public Student() {
	}

	public Student(String name,int age) {
		this.name = name;
		this.age = age;
	}


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void display() {
		System.out.println("学生信息： name=" + name + " age=" + age);
	}

	public void say(String str){
		System.out.println("学生说：" + str);
	}
}
```

7. 利用反射实现的代理模式（真实业务类，代理类，接口）

现给出接口定义、真实业务实现类及测试类定义，编写代理类（`MyInvocationHandler`）

```Java
interface Subject {
	public void say(String name,int age);
}

class RealSubject implements Subject{

	@Override
	public void say(String name, int age) {
		System.out.println(name + "今年已经" + age + "岁了。");
	}
}
```

```Java
public class Test {
	public static void main(String[] args) {
		MyInvocationHandler demo = new MyInvocationHandler();
		Subject sub = (Subject) demo.bind(new RealSubject());
		sub.say("Rollen",23);
	}
}
```

8. 利用反射完成工厂设计模式

- 有一个公共接口（`Fruit`）里面包含一个抽象方法`eat()`，`Apple`，`Orange`类实现了`Fruit`接口
- 有一个公共接口（`Vegetables`）里面包含一个抽象方法`make()`，`Carrot`，`Tomato`类实现了`Vegetables`接口
- 设计一个工厂类，可以在`Test`类里对通过接口实例化对的方式创建`Apple`，`Orange`，`Carrot`，`Tomato`类的实例化对象，并调用该对象的方法

```wJava
interface Fruit {
	public abstract void eat();
}
```