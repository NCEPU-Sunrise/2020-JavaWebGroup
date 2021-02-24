package week2;

interface Fruit {
	public abstract void eat();
}
interface Vegetable {
	public abstract void make();
}
class Apple implements Fruit{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("³ÔÆ»¹û");
	}
	
}
class Orange implements Fruit {

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("³ÔéÙ×Ó");
	}
	
}
class Carrot implements Vegetable {

	@Override
	public void make() {
		// TODO Auto-generated method stub
		System.out.println("ÇÐºúÂÜ²·");
	}
	
}
class Tomato implements Vegetable {

	@Override
	public void make() {
		// TODO Auto-generated method stub
		System.out.println("°þÎ÷ºìÊÁ");
	}
	
}
class Factory {
	
    private Factory() {
    	
    } 
    @SuppressWarnings("unchecked")
	public static<T> T getInstance(String className, Class<T> clazz) {  
        T instance = null;
        try {
            instance = (T)Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }
}
public class Assignment28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fruit a = Factory.getInstance("week2.Apple", Fruit.class);
		a.eat();
		Fruit b = Factory.getInstance("week2.Orange", Fruit.class);
		b.eat();
		Vegetable c = Factory.getInstance("week2.Carrot", Vegetable.class);
		c.make();
		Vegetable d = Factory.getInstance("week2.Tomato", Vegetable.class);
		d.make();
	}

}
