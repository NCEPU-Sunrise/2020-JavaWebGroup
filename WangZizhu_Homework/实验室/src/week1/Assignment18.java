package week1;

interface USB {
	void checkplugin(int flag);
	void checkwork(int flag);
}

class Computer implements USB {
	public void plugin(String mounting){
		
	}
	@Override
	public void checkplugin(int flag) {
		// TODO Auto-generated method stub
		if(flag==1) {
			System.out.println("已经插入");

		}
		else {
			System.out.println("插入失败");
		}
	}

	@Override
	public void checkwork(int flag) {
		// TODO Auto-generated method stub
		if(flag==1) {
			System.out.println("开始工作");

		}
		else {
			System.out.println("工作失败");
		}
	}
	
}
public class Assignment18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Computer a = new Computer();
		a.plugin("键盘");
		a.checkplugin(1);
		a.checkwork(1);
		a.plugin("打印机");
		a.checkplugin(0);
		a.checkwork(0);
		
 	}

}
