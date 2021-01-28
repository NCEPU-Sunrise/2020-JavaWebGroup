import java.time.Year;
import java.util.Scanner;

/* 
 * �����ַ��������������֤�ţ�ͳһ18λ��;620321 2002 08 02 0028
 * Ȼ��������������ָ�ţ��������أ����֤��ǰ��λ����ע�������������գ��Ա��жϵ�17λ����������ż������
 * �������������StringBuffer�ķ�����ӳ�һ���ַ��������
*/
public class HomeWork_4 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	    System.out.println("���������������֤�ţ���Ӣ�����뷨�¶��Ÿ�������");
	    String info = sc.next();
	    String[] subInfo = info.split("\\,");
	    String name = subInfo[0];
	    StringBuffer id = new StringBuffer(subInfo[1]);
	    String birthCity = id.substring(0, 2);
	    birthCity = cityValue(birthCity);
	    
	    String year = id.substring(6, 10) + "��";
	    
	    String month = id.substring(10, 12);
	    month = dayValue(month) + "��";
	    String day = id.substring(12, 14);
	    day = dayValue(day)+"��";
	    
	    String sex = id.substring(16, 17);
	    sex = sexValue(sex);

	    StringBuffer information = new StringBuffer();
	    information.append("������"+name);
	    information.append(",�����أ�"+birthCity);
	    information.append(",���������գ�"+year+month+day);
	    information.append(",�Ա�"+sex);
	    
	    System.out.println(information);
	}
	public static String cityValue(String birthCity) {
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
			return "Ů";
		else return "��";
	}
	
	
}
