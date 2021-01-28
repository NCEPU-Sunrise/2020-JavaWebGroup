import java.time.Year;
import java.util.Scanner;

/* 
 * 输入字符串：姓名，身份证号（统一18位）;620321 2002 08 02 0028
 * 然后解析出姓名（分割逗号），出生地（身份证号前两位，见注），出生年月日，性别（判断第17位是奇数还是偶数），
 * 最后将上述属性用StringBuffer的方法添加成一句字符串输出。
*/
public class HomeWork_4 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	    System.out.println("请输入姓名和身份证号（用英文输入法下逗号隔开）：");
	    String info = sc.next();
	    String[] subInfo = info.split("\\,");
	    String name = subInfo[0];
	    StringBuffer id = new StringBuffer(subInfo[1]);
	    String birthCity = id.substring(0, 2);
	    birthCity = cityValue(birthCity);
	    
	    String year = id.substring(6, 10) + "年";
	    
	    String month = id.substring(10, 12);
	    month = dayValue(month) + "月";
	    String day = id.substring(12, 14);
	    day = dayValue(day)+"日";
	    
	    String sex = id.substring(16, 17);
	    sex = sexValue(sex);

	    StringBuffer information = new StringBuffer();
	    information.append("姓名："+name);
	    information.append(",出生地："+birthCity);
	    information.append(",出生年月日："+year+month+day);
	    information.append(",性别："+sex);
	    
	    System.out.println(information);
	}
	public static String cityValue(String birthCity) {
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
		for(int i = 0,j =0 ;i<35;i++) {
			if(codeAndCity[i][0].equals(birthCity)) {
				birthCity = codeAndCity[i][1];
				break;
	        }
        }
		return birthCity;
	}
	
	
	public static String dayValue(String month) {
		if(month.substring(0, 1).equals("0")) {
			month = month.substring(1);
		}
		return month;
	}
	
	public static String sexValue(String num) {
		int sex =  Integer.parseInt(num);
		if(sex % 2 == 0)
			return "女";
		else return "男";
	}
	
	
}
