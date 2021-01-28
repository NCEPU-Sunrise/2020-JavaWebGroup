
/*Vectorʵ��*/
import java.util.*;

class Course {
	String name;
	String must;
	String teacher;
	int time;
	float score;

	Course(String a, String b, String c, int d, float e) {
		name = a;
		must = b;
		teacher = c;
		time = d;
		score = e;
	}

	Course() {
	}

	void print() {
		System.out.println(name + "\t" + must + "\t" + teacher + "\t" + time + "\t" + score + "\t");
	}

}

class AllCourse {
	Vector<Course> course;

	AllCourse() {
		course = new Vector<Course>();
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

	static void modifyMeau() {
		System.out.println("***************************************");
		System.out.println("\t\t�޸Ŀγ���Ϣ                                                         ");
		System.out.println("\t1.�޸Ŀγ���\t    2.�޸��Ƿ����ѡ��");
		System.out.println("\t3.�޸��ον�ʦ\t    4.�޸�ѧʱ");
		System.out.println("\t5.�޸�ѧ��\t\t    6.�˳�");
		System.out.println("***************************************");
	}

	void AddCourse() {
		Scanner sc = new Scanner(System.in);
		Course a = new Course();
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

		course.addElement(a);
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
		for (int i = 0; i < course.size(); i++) {

			if (course.elementAt(i).name.indexOf(a) != -1) {
				course.elementAt(i).print();
				return 1;
			}
		}

		System.out.println("δ�ҵ��ÿγ̣����������룡");
		return 0;
	}

	int searchRequired(String a) {
		int num = 0;
		for (int i = 0; i < course.size(); i++) {
			if (course.elementAt(i).must.indexOf(a) != -1) {
				course.elementAt(i).print();
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
		for (int i = 0; i < course.size(); i++) {
			if (course.elementAt(i).teacher.indexOf(a) != -1) {
				course.elementAt(i).print();
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
			int i;
			for (i = 0; i < course.size(); i++) {
				if (course.elementAt(i).name.indexOf(name) != -1) {
					course.elementAt(i).print();
					course.removeElementAt(i);
					System.out.println("ɾ���ɹ���");
					// sc.close();
					return;
				}
			}
			System.out.println("δ�ҵ��ÿγ̣����������룡");
		}
	}

	void modify() {
		Scanner sc = new Scanner(System.in);
		System.out.print("������Ҫ�޸���Ϣ�γ����ƣ�");
		String a = sc.next();
		for (int i = 0; i < course.size(); i++) {
			if (course.elementAt(i).name.indexOf(a) != -1) {
				Course index = new Course();
				index = course.elementAt(i);
				index.print();
				modifyMeau();
				while (true) {
					System.out.print("�������޸Ŀγ̹��ܱ�ţ�");
					int choice = sc.nextInt();
					switch (choice) {
					case 1:
						System.out.print("�������µĿγ����ƣ�");
						index.name = sc.next();
						course.elementAt(i).name = index.name;
						System.out.println("�޸ĳɹ���");
						break;
					case 2:
						System.out.print("������ѡ�޿�����(YES/NO)��");
						index.must = sc.next();
						course.elementAt(i).must = index.must;
						System.out.println("�޸ĳɹ���");
						break;
					case 3:
						System.out.print("�������ον�ʦ������");
						index.teacher = sc.next();
						course.elementAt(i).teacher = index.teacher;
						System.out.println("�޸ĳɹ���");
						break;
					case 4:
						System.out.print("�������µĿγ�ѧʱ��");
						index.time = sc.nextInt();
						course.elementAt(i).name = index.name;
						System.out.println("�޸ĳɹ���");
						break;
					case 5:
						System.out.print("�������µĿγ�ѧ�֣�");
						index.score = sc.nextFloat();
						course.elementAt(i).score = index.score;
						System.out.println("�޸ĳɹ���");
						break;
					case 6:// sc.close();
						return;
					default:
						System.out.println("���������������ȷ�Ĺ��ܱ��1-6��");
						break;
					}// switch
				} // while
			} // if
		} // for
		System.out.println("δ�ҵ��ÿγ̣����������룡");

	}

	void disp() {
		for (int i = 0; i < course.size(); i++) {
			course.elementAt(i).print();
		}
	}
}

public class HomeWork_3 {
	public static void main(String[] args) {
		AllCourse test = new AllCourse();

		while (true) {
			AllCourse.meau();
			Scanner sc = new Scanner(System.in);
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
			case 6:// sc.close();
				System.out.println("���������");
				return;
			default:
				System.out.println("���������������ȷ�Ĺ��ܱ��1-6��");
				break;
			}
		}
	}
}
