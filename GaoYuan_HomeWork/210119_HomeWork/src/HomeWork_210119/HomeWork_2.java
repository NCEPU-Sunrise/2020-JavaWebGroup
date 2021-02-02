package HomeWork_210119;
/*
 * ͨ�����ö������飨��ҵ����/����Vector����ҵ�����Լ����֪ʶ������¿γ̹���ϵͳ���ܣ�
 * �γ̹���ÿѧ�ڶ�Ҫ������ſγ̣�ÿ�ſγ̵���Ϣ�����γ����ƣ�String�����Ƿ��Ǳ��޿�(boolean)���ڿν�ʦ��String����ѧʱ(int)��ѧ��(float)��
 * ���ʵ�ֶԿγ���Ϣ���д�������ӡ�ɾ�����޸ĺͲ�ѯ������
 * ���԰��γ������Ƿ��Ǳ��޿Ρ��ڿν�ʦ�����в�ѯ��
 * �޸Ļ�ɾ��֮ǰҪ�Ȳ�ѯ�� */

/*��������ʵ��*/
import java.util.*;

class Courses {
	String name;
	String must;
	String teacher;
	int time;
	float score;

	Courses(String a, String b, String c, int d, float e) {
		name = a;
		must = b;
		teacher = c;
		time = d;
		score = e;
	}

	Courses() {
	}

	void print() {
		System.out.println(name + "\t" + must + "\t" + teacher + "\t" + time + "\t" + score + "\t");
	}

}

class AllCourses {
	Courses[] course;

	static int count = 0;

	AllCourses(int i) {
		course = new Courses[i];
		for (int j = count; j < i + count; j++) {
			course[j] = new Courses();
		}
	}

	AllCourses() {
	}

	static void meau() {
		System.out.println("***************************************");
		System.out.println("\t\t�γ̹���ϵͳ                                                          ");
		System.out.println("\t1.��ӿγ�\t\t  2.��ѯ�γ�");
		System.out.println("\t3.ɾ���γ�\t\t  4.�޸Ŀγ�");
		System.out.println("\t5.���ȫ���γ���Ϣ\t  6.�˳�");
		System.out.println("***************************************");
	}

	static void searchMeau() {
		System.out.println("********************************");
		System.out.println("\t       ��ѯ�γ�                                                         ");
		System.out.println("\t1.���γ�����ѯ");
		System.out.println("\t2.���Ƿ�Ϊ���޿β�ѯ");
		System.out.println("\t3.���ڿν�ʦ��ѯ");
		System.out.println("********************************");
	}

	void AddCourse() {
		Scanner sc = new Scanner(System.in);
		Courses a = new Courses();
		System.out.println("������������ӿγ̵���Ϣ��");
		System.out.print("�γ����ƣ�");
		a.name = sc.next();
		System.out.print("�Ƿ�ѡ�޿Σ���YES/NO��");
		a.must = sc.next();
		System.out.print("��ʦ��");
		a.teacher = sc.next();
		System.out.print("ѧʱ��");
		a.time = sc.nextInt();
		System.out.print("ѧ�֣�");
		a.score = sc.nextFloat();

		course[count++] = a;
		// sc.close();
		return;
	}

	void search() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�������ѯ������ţ�");
		int select = sc.nextInt();
		switch (select) {
		case 1:
			while (true) {
				System.out.print("������γ����ƣ�");
				String name = sc.next();
				if (searchName(name) != 0)
					break;
			}
			break;
		case 2:
			while (true) {
				System.out.print("��ѡ���ѯ�ǻ������YES/NO����");
				String must = sc.next();
				if (searchRequired(must) == 1)
					break;
			}
			break;
		case 3:
			while (true) {
				System.out.print("�������ʦ��");
				String teacher = sc.next();
				if (searchTeacher(teacher) == 1)
					break;
			}
			break;
		default:
			System.out.println("���������������ȷ�Ĺ��ܱ��1-3��");
			break;
		}
		// sc.close();
	}

	int searchName(String a) {
		for (int i = 0; i < count; i++) {
			if (course[i].name.equals(a)) {
				course[i].print();
				return 1;
			}
		}
		System.out.println("δ�ҵ��ÿγ̣����������룡");
		return 0;
	}

	int searchRequired(String a) {
		int num = 0;
		for (int i = 0; i < count; i++) {
			if (course[i].must.equals(a)) {
				course[i].print();
				num++;
			}
		}
		if (num == 0) {
			System.out.println("δ�ҵ���ؿγ̣����������룡");
			return 0;
		}
		return 1;
	}

	int searchTeacher(String a) {
		int num = 0;
		for (int i = 0; i < count; i++) {
			if (course[i].teacher.equals(a)) {
				course[i].print();
				num++;
			}
		}
		if (num == 0) {
			System.out.println("δ�ҵ�����ʦ���ڿγ̣����������룡");
			return 0;
		}
		return 1;
	}

	void delete() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("������Ҫɾ���γ����ƣ�");
			String name = sc.next();
			for (int i = 0; i < count; i++) {
				if (course[i].name.equals(name)) {
					course[i].print();
					for (int j = i; j < count; j++) {
						course[j] = course[j + 1];
					}
					count--;
					System.out.println("ɾ���ɹ���");
					// sc.close();
					return;
				}
			}
			System.out.println("δ�ҵ��ÿγ̣����������룡");
		}
	}

	void modifyMeau() {
		System.out.println("***************************************");
		System.out.println("\t\t�޸Ŀγ���Ϣ                                                         ");
		System.out.println("\t1.�޸Ŀγ���\t    2.�޸��Ƿ����ѡ��");
		System.out.println("\t3.�޸��ον�ʦ\t    4.�޸�ѧʱ");
		System.out.println("\t5.�޸�ѧ��\t\t    6.�˳�");
		System.out.println("***************************************");
	}

	void modify() {
		Scanner sc = new Scanner(System.in);
		System.out.print("������Ҫ�޸���Ϣ�γ����ƣ�");
		String a = sc.next();
		int num = 0;
		for (int i = 0; i < count; i++) {
			if (course[i].name.equals(a)) {
				course[i].print();
				num++;

				modifyMeau();
				while (true) {
					System.out.print("�������޸Ŀγ̹��ܱ�ţ�");
					int choice = sc.nextInt();
					switch (choice) {
					case 1:
						System.out.print("�������µĿγ����ƣ�");
						course[i].name = sc.next();
						System.out.println("�޸ĳɹ���");
						break;
					case 2:
						System.out.print("������ѡ�޿�����(YES/NO)��");
						course[i].must = sc.next();
						System.out.println("�޸ĳɹ���");
						break;
					case 3:
						System.out.print("�������ον�ʦ������");
						course[i].teacher = sc.next();
						System.out.println("�޸ĳɹ���");
						break;
					case 4:
						System.out.print("�������µĿγ�ѧʱ��");
						course[i].time = sc.nextInt();
						System.out.println("�޸ĳɹ���");
						break;
					case 5:
						System.out.print("�������µĿγ�ѧ�֣�");
						course[i].score = sc.nextFloat();
						System.out.println("�޸ĳɹ���");
						break;
					case 6:// sc.close();
						return;
					default:
						System.out.println("���������������ȷ�Ĺ��ܱ��1-6��");
						break;
					}
				}
			}
		}
		if (num == 0) {
			System.out.println("δ�ҵ��ÿγ̣����������룡");
		}
		return;
	}

	void disp() {
		for (int i = 0; i < count; i++) {
			course[i].print();
		}
	}

}

public class HomeWork_2 {

	public static void main(String[] args) {
		AllCourses test = new AllCourses(20);
		Scanner sc = new Scanner(System.in);
		while (true) {
			AllCourses.meau();
			System.out.print("�����빦�ܱ�ţ�");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				test.AddCourse();
				break;
			case 2:
				AllCourses.searchMeau();
				test.search();
				break;
			case 3:
				test.delete();
				break;
			case 4:
				test.modify();
				break;
			case 5:
				test.disp();
				break;
			case 6:
				return;
			default:
				System.out.println("���������������ȷ�Ĺ��ܱ��1-6��");
				break;
			}
		}
	}
}
