package Homework_18;

public class Competer implements USB{
	boolean USB1,USB2;
	Competer(){
		USB1=USB2=false;
		
	}
	void plugin(String tool) {
		if((!check(USB1))||(!check(USB2))) {
			System.out.println(tool+"成功接入");
		}
	}
	
	@Override
	public boolean check(boolean usb) {
		// TODO Auto-generated method stub
		return usb;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("开始工作");
	}

}
