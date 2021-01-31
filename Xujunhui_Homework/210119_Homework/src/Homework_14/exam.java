package Homework_14;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import java.util.Scanner;

public class exam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int flag=1;
		Random r= new Random();
		Scanner sc=new Scanner(System.in);
		while(flag==1) {
			int i=r.nextInt(3);
			switch (i) {
			case 0:{
				int j=r.nextInt(10);//0-9随机
				j++;
				BigDecimal a=BigDecimal.valueOf(calTools.V_Ball(j));
				BigDecimal b=BigDecimal.valueOf(calTools.S_Ball(j));
				a=a.setScale(0,RoundingMode.HALF_UP);
				b=b.setScale(0,RoundingMode.HALF_UP);
				int V=a.intValue();
				int S=b.intValue();
				System.out.println("已知一个球体，它的半径为："+j+"，求它的体积和面积。(四舍五入，保留整数位)\n你的答案：");
				System.out.print("体积为：");
				int v=sc.nextInt();
				System.out.print("表面积为：");
				int s=sc.nextInt();
				if(V==v&&S==s) {
					System.out.print("回答正确!! (按1继续考试，按0退出)");
				}else {
					if(V!=v)
						System.out.print("体积错误！！！");
					else if(S!=s)
						System.out.print("表面积错误！！！");
					System.out.print(" (按1继续考试，按0退出)");
				}
				flag=sc.nextInt();
				break;
			}
			case 1:{
				int j=r.nextInt(10);//0-9随机
				int h=r.nextInt(10);
				h++;
				j++;
				BigDecimal a=BigDecimal.valueOf(calTools.V_cylinder(j, h));
				BigDecimal b=BigDecimal.valueOf(calTools.S_cylinder(j, h));
				a=a.setScale(0,RoundingMode.HALF_UP);
				b=b.setScale(0,RoundingMode.HALF_UP);
				int V=a.intValue();
				int S=b.intValue();
				System.out.println("已知一个圆柱体，它的底面半径为："+j+"它的高为："+h+"，求它的体积和面积。(四舍五入，保留整数位)\n你的答案：");
				System.out.print("体积为：");
				int v=sc.nextInt();
				System.out.print("表面积为：");
				int s=sc.nextInt();
				if(V==v&&S==s) {
					System.out.print("回答正确!! (按1继续考试，按0退出)");
				}else {
					if(V!=v)
						System.out.print("体积错误！！！");
					else if(S!=s)
						System.out.print("表面积错误！！！");
					System.out.print(" (按1继续考试，按0退出)");
				}
				flag=sc.nextInt();
				break;
			}
			case 2:{
				int j=r.nextInt(10);//0-9随机
				int h=r.nextInt(10);
				h++;
				j++;
				BigDecimal a=BigDecimal.valueOf(calTools.V_cylinder(j, h));
				BigDecimal b=BigDecimal.valueOf(calTools.S_cylinder(j, h));
				a=a.setScale(0,RoundingMode.HALF_UP);
				b=b.setScale(0,RoundingMode.HALF_UP);
				int V=a.intValue();
				int S=b.intValue();
				System.out.println("已知一个圆锥体，它的底面半径为："+j+"它的高为："+h+"，求它的体积和面积。(四舍五入，保留整数位)\n你的答案：");
				System.out.print("体积为：");
				int v=sc.nextInt();
				System.out.print("表面积为：");
				int s=sc.nextInt();
				if(V==v&&S==s) {
					System.out.print("回答正确!! (按1继续考试，按0退出)");
				}else {
					if(V!=v)
						System.out.print("体积错误！！！");
					else if(S!=s)
						System.out.print("表面积错误！！！");
					System.out.print(" (按1继续考试，按0退出)");
				}
				flag=sc.nextInt();
				break;
			}
			}
		}
	}

}
