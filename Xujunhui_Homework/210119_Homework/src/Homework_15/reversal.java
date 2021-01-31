package Homework_15;

public class reversal extends Array{
	reversal() {
		super.arr=new int[0];
		super.size=0;
	}
	reversal(int[] array){
		super.arr=array;
		super.size=array.length;
	}
	void invert() {
		int[] newarr=new int[arr.length];
		for(int i=size-1;i>=0;i--) 
			newarr[size-1-i]=arr[i];
		arr=newarr;
	}
}
