public class Leaf {
	//定义成员变量i
	int i = 0;
	
	//构造方法 
	//此处参数列表里的局部变量i 和成员变量i同名
	//要将局部变量i的值赋值给成员变量i，那就要将成员变量i加上this.做区分
	//如果不做区分，根据变量声明的“就近原则”：i=i;中两个i都是局部变量
	//那么就无法将值赋值给成员变量了。
	Leaf(int i) {
		this.i = i;
	}
	
	//增加方法，每调用一次，i自增1
	//返回当前对象的引用。
	Leaf increament() {
		i++;
		return this;
	}
	
	//调用此方法将结果打印到控制台
	void print() {
		System.out.println("i = " + i);
	}
	
	//main方法
	public static void main(String[] args) {
        
		//创建一个leaf对象，将成员变量i赋值为100
		Leaf leaf = new Leaf(100);
        
		//调用两次增加方法，并打印出结果：i=102.
		leaf.increament().increament().print();
        
	}
}