class Outer { 				// 外部类
	private int age = 12;
	class Inner {
	    			// 内部类
		public void show() { 		// 内部类的成员方法
			System.out.println("内部类输出");
			System.out.println(age);
		}
	}

	void show() { // 外部类的成员方法
		
		System.out.println("外部类输出");
		//创建内部类对象
		Inner i = new Inner();		
		i.show();// 调用内部类成员方法
	}
	public static void main(String[] args) {
		Outer o = new Outer();
		o.show();

		//创建内部类对象
		Outer.Inner in = new Outer().new Inner();
		in.show();
	}
}
