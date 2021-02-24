package week1;

//�����ַ��������������֤�ţ�ͳһ18λ����Ȼ��������������ָ�ţ��������أ����֤��ǰ��λ����ע�������������գ��Ա��жϵ�17λ����������ż�������������������StringBuffer�ķ�����ӳ�һ���ַ��������
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
		String codeAndCity[][] = {{"11", "����"}, {"12", "���"},
				{"13", "�ӱ�"}, {"14", "ɽ��"}, {"15", "���ɹ�"}, {"21", "����"},
				{"22", "����"}, {"23", "������"}, {"31", "�Ϻ�"}, {"32", "����"},
				{"33", "�㽭"}, {"34", "����"}, {"35", "����"}, {"36", "����"},
				{"37", "ɽ��"}, {"41", "����"}, {"42", "����"}, {"43", "����"},
				{"44", "�㶫"}, {"45", "����"}, {"46", "����"}, {"50", "����"},
				{"51", "�Ĵ�"}, {"52", "����"}, {"53", "����"}, {"54", "����"},
				{"61", "����"}, {"62", "����"}, {"63", "�ຣ"}, {"64", "����"},
				{"65", "�½�"}, {"71", "̨��"}, {"81", "���"}, {"82", "����"},
				{"91", "����"}};
		
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
			return sexString="Ů";
		else 
			return sexString="��";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("����������,���֤�ţ�18λ����");
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
