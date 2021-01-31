package Homework_15;

public class Array {
	static int [] arr;
	static int size;
	Array() {
		// TODO Auto-generated constructor stub
		arr=new int[0];
		this.size=0;
	}
	Array(int[] array){
		this.arr=array;
		size=array.length;
	}
	static void extendSpace() {
		if(size==arr.length) {
			int[] newarr=new int[size*3/2+1];
			System.arraycopy(arr, 0, newarr, 0, size);
			arr=newarr;
		}
	}
	static void add(int obj) {
		if(size<arr.length){
			arr[size]=obj;
			size++;
		}else {
			System.out.println("需要扩充空间！！！");
			extendSpace();
			arr[size]=obj;
			size++;
		}
	}
	int[] getInfo() {
		return arr;
	}
	
}
