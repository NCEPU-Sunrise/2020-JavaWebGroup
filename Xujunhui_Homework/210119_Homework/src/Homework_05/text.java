package Homework_05;

public class text {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String address[]= {"中国"," 重庆市"," 石柱县"," 南滨街道","409199"};
		Address demo=new Address(address[0], address[1], address[2], address[3],address[4]);
		System.out.println(demo.getInfo());
	}

}
