class OuterA { 				
	int age = 12;
	void show() { 
		System.out.println("A类输出");
	}
}
class OuterB {
    OuterA a;
    OuterB(OuterA a){
        this.a = a;
    }
    void show() { 
		System.out.println("B类输出");
		a.show();
	}
}
class OuterAOuterB{
	public static void main(String[] args) {
		 new OuterB(new OuterA()).show();
	}
}
