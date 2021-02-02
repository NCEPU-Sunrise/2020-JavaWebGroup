class Driver {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void drive(Vihecle c, Address dest) {
		c.go(dest);
	}
}
abstract class Vihecle {
	public abstract void go(Address dest);
}
class Car extends Vihecle{
	public void go(Address dest) {
		System.out.println("一路哼着歌，冒着烟，去了" + dest.getName());
	}
}
class Address {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address(String name) {
		super();
		this.name = name;
	}	
}
public class VihecleTest {
	public static void main(String[] args) {
		Driver d = new Driver();
		d.setName("老张");
		Address a = new Address("北京");
		d.drive(new Car(),a);
	}
}	