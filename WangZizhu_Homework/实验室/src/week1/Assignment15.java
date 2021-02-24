package week1;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class Array {
	int[] x;
	int l = 0;
	public Array(int[] x) {
		this.x=x;
		// TODO Auto-generated constructor stub
	}
	public boolean add(int o) {
		if(x.length==l) {
			System.out.println("�����������޷�����!");
			return false;
		}
		else {
			x[l++]=o;
			return true;
		}
	}
	public int[] addcompacity(int c) {
		int com = c+x.length;
		int[] d = new int[com];
		for(int i=0,j=0;i<com;i++,j++) {
			if(j<x.length) {
				d[i]=x[j];
			}
			else {
				break;
			}
		}
		x=d;
		return x;
	}
	public void print() {
		for(int i=0;i<x.length;i++) {
			System.out.println(x[i]);
		}
	}
	
}
class Arraysort extends Array {
	
	public Arraysort(int[] x) {
		super(x);
		// TODO Auto-generated constructor stub
	}

	public int[] sort() {
		Arrays.sort(x);
		return x;
	}
	public void print() {
		for(int i=0;i<x.length;i++) {
			System.out.println(x[i]);
		}
	}
}
class Arrayreverse extends Array {
	
	public Arrayreverse(int[] x) {
		super(x);
		// TODO Auto-generated constructor stub
	}

	public int[] reverse() {
		int[] k = new int[x.length];
		int j=0;
		for(int i=x.length-1;i>=0;i--) {
			k[j++]=x[i];
		}
		x=k;
		return x;
	}
	public void print() {
		for(int i=0;i<x.length;i++) {
			System.out.println(x[i]);
		}
	}
}
public class Assignment15 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		char c='Y';
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ����������ĳ��ȣ�");
		int n = sc.nextInt();
		int[] a = new int[n];
		Array m = new Array(a);
		while(c=='Y') {
			System.out.println("�����������������ݣ�");
			if(m.add(sc.nextInt())) {
				System.out.println("�Ƿ������ӣ���Y/N��");
				c=(char)System.in.read();
			}
			else {
				break;
			}
		}
		m.print();
		System.out.println("��������������������������");
		a=m.addcompacity(sc.nextInt());
		System.out.println("��ӡ�������飺");
		m.print();
		(new Arraysort(a)).sort();
		System.out.println("��ӡ�������飺");
		(new Arraysort(a)).print();
		(new Arrayreverse(a)).reverse();
		System.out.println("��ӡ��ת���飺");
		(new Arrayreverse(a)).print();
		sc.close();
	}
}
