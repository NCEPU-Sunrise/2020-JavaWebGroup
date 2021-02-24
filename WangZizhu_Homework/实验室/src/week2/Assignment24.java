package week2;

import java.util.Scanner;

interface Manu {
	double getPrice();
}
enum Appetizer implements Manu {
	SALAD(35.0), SOUP(40.0), SPRING_ROLLS(50.0);
    private double price;  
	Appetizer(double d) {
		this.price = d;
	}

	@Override
	public double getPrice() {
		return price;
		// TODO Auto-generated method stub
	}
}
enum Main implements Manu{
	LASAGNE(55.0), BURRITO(70.0), PAD_THAI(75.0), LENTILS(60.0);
    private double price;  
	Main(double d) {
		this.price = d;
	}

	@Override
	public double getPrice() {
		return price;
		// TODO Auto-generated method stub
	}
}
enum Dessert implements Manu{
	BLACK_FOREST_CAKE(30.0), FRUIT(20.0);
    private double price;  
	Dessert(double d) {
		this.price = d;
	}

	@Override
	public double getPrice() {
		return price;
		// TODO Auto-generated method stub
	}
}
public class Assignment24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("-----开始点菜-----");
		System.out.println("------------菜单---------------");
		System.out.println("----前菜------");
		for(Appetizer l: Appetizer.values()) {
			System.out.println(l+"---"+l.getPrice());
		}
		System.out.println("----主菜------");
		for(Main l: Main.values()) {
			System.out.println(l+"---"+l.getPrice());
		}
		System.out.println("----甜点------");
		for(Dessert l: Dessert.values()) {
			System.out.println(l+"---"+l.getPrice());
		}
		System.out.println("--------------------------");
		double sum = 0;
		System.out.println("请问需要什么前菜？");
		String a = scanner.next();
		for(Appetizer m: Appetizer.values()) {
			if(m.toString().equals(a)) {
				sum+=m.getPrice();
			}
		}
		System.out.println("请问需要什么主菜？");
		String b = scanner.next();
		for(Main m: Main.values()) {
			if(m.toString().equals(b)) {
				sum+=m.getPrice();
			}
		}
		System.out.println("请问需要什么甜点？");
		String c = scanner.next();
		for(Dessert m: Dessert.values()) {
			if(m.toString().equals(c)) {
				sum+=m.getPrice();
			}
		}
		System.out.println("总共消费："+sum+"元！请耐心等待，马上为您上菜！");
		
	}

}
