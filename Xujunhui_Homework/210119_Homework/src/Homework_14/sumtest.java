package Homework_14;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class sumtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double sumV,sumS;
		sumV=calTools.V_Ball(3)+calTools.V_cylinder(3, 3)+calTools.V_cone(3,3);
		sumS=calTools.S_Ball(3)+calTools.S_cylinder(3, 3)+calTools.S_cone(3,3);
		BigDecimal a=BigDecimal.valueOf(sumV);
		a=a.setScale(0,RoundingMode.HALF_UP);
		BigDecimal b=BigDecimal.valueOf(sumS);
		b=b.setScale(0,RoundingMode.HALF_UP);
		System.out.println("体积总和为："+a);
		System.out.println("表面积总和为："+b);
	}

}
