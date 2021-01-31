package Homework_15;

public class test {
	public static void main(String[] args) {
		int[] a= {5,1,4,3,1,5,6};
		Array b=new Array(a);
		for(int i=0;i<b.size;i++)
			System.out.print(b.getInfo()[i]+" ");
		System.out.println();
		sort cSort=new sort(a);
		for(int i=0;i<b.size;i++)
			System.out.print(cSort.getInfo()[i]+" ");
		System.out.println();
		reversal r=new reversal(a);
		for(int i=0;i<b.size;i++)
			System.out.print(r.getInfo()[i]+" ");
		r.invert();
		System.out.println();
		for(int i=0;i<b.size;i++)
			System.out.print(r.getInfo()[i]+" ");
	}
}
