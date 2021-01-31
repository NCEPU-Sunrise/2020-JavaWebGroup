package Homework_15;

public class sort extends Array{
	sort() {
		super.arr=new int[0];
		super.size=0;
	}
	sort(int[] array){
		super.arr=array;
		super.size=array.length;
	}
	int[] getInfo() {
		for(int i=0;i<size;i++) {
			for(int j = 0;j<size-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		return arr;
	}
}
