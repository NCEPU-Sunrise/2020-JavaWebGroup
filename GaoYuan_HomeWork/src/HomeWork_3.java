
/*Vector实现*/
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
		System.out.println("\t\t课程管理系统                                                          ");
		System.out.println("\t1.添加课程\t\t  2.查询课程");
		System.out.println("\t3.删除课程\t\t  4.修改课程");
		System.out.println("\t5.输出全部课程信息\t  6.退出");
		System.out.println("***************************************");
	}

	static void searchMeau() {
		System.out.println("********************************");
		System.out.println("\t       查询课程                                                         ");
		System.out.println("\t1.按课程名查询");
		System.out.println("\t2.按是否为必修课查询");
		System.out.println("\t3.按授课教师查询");
		System.out.println("********************************");
	}

	static void modifyMeau() {
		System.out.println("***************************************");
		System.out.println("\t\t修改课程信息                                                         ");
		System.out.println("\t1.修改课程名\t    2.修改是否必修选项");
		System.out.println("\t3.修改任课教师\t    4.修改学时");
		System.out.println("\t5.修改学分\t\t    6.退出");
		System.out.println("***************************************");
	}

	void AddCourse() {
		Scanner sc = new Scanner(System.in);
		Course a = new Course();
		System.out.println("请依次输入添加课程的信息：");
		System.out.print("课程名称：");
		a.name = sc.next();
		System.out.print("是否选修课：（YES/NO）");
		a.must = sc.next();
		System.out.print("教师：");
		a.teacher = sc.next();
		System.out.print("学时：");
		a.time = sc.nextInt();
		System.out.print("学分：");
		a.score = sc.nextFloat();

		course.addElement(a);
		// sc.close();
		return;
	}

	void search() {
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入查询条件编号：");
		int select = sc.nextInt();
		switch (select) {
		case 1:
			while (true) {
				System.out.print("请输入课程名称：");
				String name = sc.next();
				if (searchName(name) != 0)
					break;
			}
			break;
		case 2:
			while (true) {
				System.out.print("请选择查询是或否（输入YES/NO）：");
				String must = sc.next();
				if (searchRequired(must) == 1)
					break;
			}
			break;
		case 3:
			while (true) {
				System.out.print("请输入教师：");
				String teacher = sc.next();
				if (searchTeacher(teacher) == 1)
					break;
			}
			break;
		default:
			System.out.println("输入错误！请输入正确的功能编号1-3！");
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

		System.out.println("未找到该课程，请重新输入！");
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
			System.out.println("未找到相关课程，请重新输入！");
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
			System.out.println("未找到该老师所授课程，请重新输入！");
			return 0;
		}
		return 1;
	}

	void delete() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("请输入要删除课程名称：");
			String name = sc.next();
			int i;
			for (i = 0; i < course.size(); i++) {
				if (course.elementAt(i).name.indexOf(name) != -1) {
					course.elementAt(i).print();
					course.removeElementAt(i);
					System.out.println("删除成功！");
					// sc.close();
					return;
				}
			}
			System.out.println("未找到该课程，请重新输入！");
		}
	}

	void modify() {
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入要修改信息课程名称：");
		String a = sc.next();
		for (int i = 0; i < course.size(); i++) {
			if (course.elementAt(i).name.indexOf(a) != -1) {
				Course index = new Course();
				index = course.elementAt(i);
				index.print();
				modifyMeau();
				while (true) {
					System.out.print("请输入修改课程功能编号：");
					int choice = sc.nextInt();
					switch (choice) {
					case 1:
						System.out.print("请输入新的课程名称：");
						index.name = sc.next();
						course.elementAt(i).name = index.name;
						System.out.println("修改成功！");
						break;
					case 2:
						System.out.print("请输入选修课类型(YES/NO)：");
						index.must = sc.next();
						course.elementAt(i).must = index.must;
						System.out.println("修改成功！");
						break;
					case 3:
						System.out.print("请输入任课教师姓名：");
						index.teacher = sc.next();
						course.elementAt(i).teacher = index.teacher;
						System.out.println("修改成功！");
						break;
					case 4:
						System.out.print("请输入新的课程学时：");
						index.time = sc.nextInt();
						course.elementAt(i).name = index.name;
						System.out.println("修改成功！");
						break;
					case 5:
						System.out.print("请输入新的课程学分：");
						index.score = sc.nextFloat();
						course.elementAt(i).score = index.score;
						System.out.println("修改成功！");
						break;
					case 6:// sc.close();
						return;
					default:
						System.out.println("输入错误！请输入正确的功能编号1-6！");
						break;
					}// switch
				} // while
			} // if
		} // for
		System.out.println("未找到该课程，请重新输入！");

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
			System.out.print("请输入功能编号：");
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
				System.out.println("程序结束！");
				return;
			default:
				System.out.println("输入错误！请输入正确的功能编号1-6！");
				break;
			}
		}
	}
}
