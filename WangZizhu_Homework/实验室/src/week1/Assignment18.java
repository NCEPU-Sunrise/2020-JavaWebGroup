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
			System.out.println("�Ѿ�����");

		}
		else {
			System.out.println("����ʧ��");
		}
	}

	@Override
	public void checkwork(int flag) {
		// TODO Auto-generated method stub
		if(flag==1) {
			System.out.println("��ʼ����");

		}
		else {
			System.out.println("����ʧ��");
		}
	}
	
}
public class Assignment18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Computer a = new Computer();
		a.plugin("����");
		a.checkplugin(1);
		a.checkwork(1);
		a.plugin("��ӡ��");
		a.checkplugin(0);
		a.checkwork(0);
		
 	}

}
