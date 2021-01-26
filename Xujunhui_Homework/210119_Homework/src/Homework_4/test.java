package Homework_4;
import java.util.*;
public class test {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String codeAndCity[][] = {{"11", "北京"}, {"12", "天津"},
				{"13", "河北"}, {"14", "山西"}, {"15", "内蒙古"}, {"21", "辽宁"},
				{"22", "吉林"}, {"23", "黑龙江"}, {"31", "上海"}, {"32", "江苏"},
				{"33", "浙江"}, {"34", "安徽"}, {"35", "福建"}, {"36", "江西"},
				{"37", "山东"}, {"41", "河南"}, {"42", "湖北"}, {"43", "湖南"},
				{"44", "广东"}, {"45", "广西"}, {"46", "海南"}, {"50", "重庆"},
				{"51", "四川"}, {"52", "贵州"}, {"53", "云南"}, {"54", "西藏"},
				{"61", "陕西"}, {"62", "甘肃"}, {"63", "青海"}, {"64", "宁夏"},
				{"65", "新疆"}, {"71", "台湾"}, {"81", "香港"}, {"82", "澳门"},
				{"91", "国外"}};
		int i;
		String str;
		StringBuffer s=new StringBuffer();
		StringBuffer city=new StringBuffer();
		System.out.println("请输入：姓名，身份证号：");
		Scanner sc=new Scanner(System.in);
		str=sc.nextLine();
		for(i=0;str.charAt(i)!=',';i++) 
			s.append(str.charAt(i));
		city.append(str.charAt(++i));
		city.append(str.charAt(++i));
		String c=city.toString();
		for(int j=0;j<codeAndCity.length;j++) {
			if(c.equals(codeAndCity[j][0])) {
				s.append(codeAndCity[j][1]);
			}
		}
		i+=5;
		for(int j=0;j<8;i++,j++)
			s.append(str.charAt(i));
		i+=3;
		int k=Integer.parseInt(String.valueOf(str.charAt(i)));
		if(k%2==0) {
			s.append("男");
		}else {
			s.append("女");
		}
		System.out.println(s);
	}

}
