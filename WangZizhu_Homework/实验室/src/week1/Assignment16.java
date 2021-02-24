package week1;

abstract class Instrument {
	abstract public void play();
}
class Piano extends Instrument {

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("µ¯×à¸ÖÇÙ");
	}
	
}
class Violin extends Instrument {

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("À­Ð¡ÌáÇÙ");
	}
	
}
public class Assignment16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		(new Piano()).play(); 
		(new Violin()).play();
	}

}
