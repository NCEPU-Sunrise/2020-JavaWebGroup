package week1;

//输入字符串：姓名，身份证号（统一18位），然后解析出姓名（分割逗号），出生地（身份证号前两位，见注），出生年月日，性别（判断第17位是奇数还是偶数），最后将上述属性用StringBuffer的方法添加成一句字符串输出。
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Assignment4 {
	
	public static String[] getName(String infoString) {
		
		String[] infosplitStrings = infoString.split(",");
		return infosplitStrings;
	}
	
	public static String getAddress(String idString) {
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
		
		for(int i=0;i<codeAndCity.length;i++)
			if((idString.substring(0, 2)).equals(codeAndCity[i][0]))
				return codeAndCity[i][1];
		return null;
	}
	
	public static String getAge(String idString) {
		Calendar calendar = Calendar.getInstance();
		int yearNow = calendar.get(Calendar.YEAR);  
        int monthNow = calendar.get(Calendar.MONTH)+1;  
        int dayOfMonthNow = calendar.get(Calendar.DAY_OF_MONTH);
		String birthString = idString.substring(6, 14);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		try{
	        Date birthDate = dateFormat.parse(birthString);
	        calendar.setTime(birthDate);
	    } catch (ParseException e) {
	        System.out.println(e.getMessage());
	    }
        int yearBirth = calendar.get(Calendar.YEAR);
        int monthBirth = calendar.get(Calendar.MONTH)+1;
        int dayOfMonthBirth = calendar.get(Calendar.DAY_OF_MONTH);       
        int age = yearNow - yearBirth;   
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) 
                	age--;
            }
            else 
                    age--;
        }
		return String.valueOf(age);
	}
	
	public static String getSex(String idString) {
		@SuppressWarnings("unused")
		String sexString;
		int num = Integer.parseInt(idString.substring(16, 17));
		if(num%2 == 0)
			return sexString="女";
		else 
			return sexString="男";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入姓名,身份证号（18位）：");
		String infoString = scanner.next();
		
		StringBuffer infoBuffer = new StringBuffer();
		infoBuffer.append(getName(infoString)[0]+" ");
		infoBuffer.append(getAddress(getName(infoString)[1])+" ");
		infoBuffer.append(getAge(getName(infoString)[1])+" ");
		infoBuffer.append(getSex(getName(infoString)[1]));
		System.out.println(infoBuffer);	
		scanner.close();
	}

}
