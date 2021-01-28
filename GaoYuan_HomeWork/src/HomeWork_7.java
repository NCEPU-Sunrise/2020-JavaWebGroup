/**
 * 假设某赛车游戏中，汽车涉及如下内容：车主、品牌、颜色，能够进行启动、前进、后退、停止、熄火等动作， 并要求，若汽车已经启动，就不能重复启动；
 * 若汽车处于熄火状态，不能执行除启动外的其它动作。 另外，要能够直接打印出汽车对象的信息。 请完成汽车类的设计，其中各项动作给出相关信息提示即可。
 */
class Car {

	String owner, brand, color;// 车主、品牌、颜色
	boolean isActive = false; // 标记汽车是否启动,boolean型只有两个值：true和false

	Car(String o, String b, String c) {
		owner = o;
		brand = b;
		color = c;
	} // 构造函数

	void start() {
		if (isActive == true) {
			System.out.println("汽车不能重复启动！");
			return;
		} // 若已经启动，就结束
		isActive = true;
		System.out.println("汽车启动！");
	}

	void go() {
		if (isActive == false) {
			System.out.println("汽车未启动，不能前进！");
			return;
		}
		System.out.println("汽车前进！");
	}

	void stop() {
		if (isActive == false) {
			System.out.println("汽车未启动，不能熄火！");
			return;
		}
		isActive = false;
		System.out.println("汽车熄火！");
	}

	public String toString() {// 此函数的功能：会被System.out.print()在【打印对象时】自动调用；
		return " 品牌：" + brand + " 颜色：" + color;
	}
}

public class HomeWork_7 {
	public static void main(String[] x) {
		Car c = new Car("张三", "奇瑞", "黑色");
		System.out.print(c);
		c.go();
		c.stop();
		c.start();
		c.stop();
	}
}
