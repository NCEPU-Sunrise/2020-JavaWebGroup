/*��֪2000.1.1��������������������������ڣ�2000���Ժ�ģ������̼�������������ڼ���*/
package HomeWork_210119;
import java.util.*;

public class HomeWork_1 {

	public static void main(String[] args) {
		while (true) {
			Scanner sc = new Scanner(System.in);

			System.out.println("������������ڣ��Կո������");
			int year = sc.nextInt(); 
			int month = sc.nextInt(); 
			int day = sc.nextInt(); 

			if (year < 2000) {
				System.out.println("������2000���Ժ����ݣ�");
			} else {
				int monthday[][] = { { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, // ƽ��ÿ������
						{ 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } }; // ����ÿ������

				String[] weekday = { "��", "��", "һ", "��", "��", "��", "��" };

				int days = 0; 

				if (year > 2000) // �������ꡱ����������
				{
					for (int i = 2000; i < year; i++) {
						if (leapYear(i) == 1) {
							days += 366;
						} else
							days += 365;

					}

				}

				if (month > 1) // �������¡�����������
				{
					for (int j = 1; j < month; j++) {
						days += monthday[leapYear(year)][j]; // �������������ƽ�� �� ����ѡ������
					}

				}

				days = days + day - 1; // �������ա������ӵ�����
				System.out.println(year + "��" + month + "��" + day + "�� �� ����" + weekday[days % 7]);
				sc.close();
				break;

			} // else
		} // while
	}

	// �ж��Ƿ�Ϊ���꣬��Ϊ���꣬����1����Ϊƽ�꣬����0
	public static int leapYear(int year) {
		if (year % 100 == 0 && year % 400 == 0)
			return 1;
		if (year % 100 != 0 && year % 4 == 0)
			return 1;
		return 0;
	}
}
