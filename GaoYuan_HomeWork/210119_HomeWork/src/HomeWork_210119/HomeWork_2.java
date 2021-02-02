package HomeWork_210119;
/*
 * 通过运用对象数组（作业二）/利用Vector（作业三）以及类的知识完成如下课程管理系统功能：
 * 课程管理每学期都要开设多门课程，每门课程的信息包括课程名称（String）、是否是必修课(boolean)、授课教师（String）、学时(int)、学分(float)；
 * 编程实现对课程信息进行创建、添加、删除、修改和查询操作；
 * 可以按课程名、是否是必修课、授课教师来进行查询；
 * 修改或删除之前要先查询； */

/*对象数组实现*/
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

	void AddCourse() {
		Scanner sc = new Scanner(System.in);
		Courses a = new Courses();
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

		course[count++] = a;
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
		for (int i = 0; i < count; i++) {
			if (course[i].name.equals(a)) {
				course[i].print();
				return 1;
			}
		}
		System.out.println("未找到该课程，请重新输入！");
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
			System.out.println("未找到相关课程，请重新输入！");
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
			for (int i = 0; i < count; i++) {
				if (course[i].name.equals(name)) {
					course[i].print();
					for (int j = i; j < count; j++) {
						course[j] = course[j + 1];
					}
					count--;
					System.out.println("删除成功！");
					// sc.close();
					return;
				}
			}
			System.out.println("未找到该课程，请重新输入！");
		}
	}

	void modifyMeau() {
		System.out.println("***************************************");
		System.out.println("\t\t修改课程信息                                                         ");
		System.out.println("\t1.修改课程名\t    2.修改是否必修选项");
		System.out.println("\t3.修改任课教师\t    4.修改学时");
		System.out.println("\t5.修改学分\t\t    6.退出");
		System.out.println("***************************************");
	}

	void modify() {
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入要修改信息课程名称：");
		String a = sc.next();
		int num = 0;
		for (int i = 0; i < count; i++) {
			if (course[i].name.equals(a)) {
				course[i].print();
				num++;

				modifyMeau();
				while (true) {
					System.out.print("请输入修改课程功能编号：");
					int choice = sc.nextInt();
					switch (choice) {
					case 1:
						System.out.print("请输入新的课程名称：");
						course[i].name = sc.next();
						System.out.println("修改成功！");
						break;
					case 2:
						System.out.print("请输入选修课类型(YES/NO)：");
						course[i].must = sc.next();
						System.out.println("修改成功！");
						break;
					case 3:
						System.out.print("请输入任课教师姓名：");
						course[i].teacher = sc.next();
						System.out.println("修改成功！");
						break;
					case 4:
						System.out.print("请输入新的课程学时：");
						course[i].time = sc.nextInt();
						System.out.println("修改成功！");
						break;
					case 5:
						System.out.print("请输入新的课程学分：");
						course[i].score = sc.nextFloat();
						System.out.println("修改成功！");
						break;
					case 6:// sc.close();
						return;
					default:
						System.out.println("输入错误！请输入正确的功能编号1-6！");
						break;
					}
				}
			}
		}
		if (num == 0) {
			System.out.println("未找到该课程，请重新输入！");
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
			case 6:
				return;
			default:
				System.out.println("输入错误！请输入正确的功能编号1-6！");
				break;
			}
		}
	}
}
