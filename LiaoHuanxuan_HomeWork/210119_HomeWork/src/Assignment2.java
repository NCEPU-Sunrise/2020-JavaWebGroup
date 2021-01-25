import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Xnhyacinth
 * @date 2021/1/24 - 20:23
 */
public class Assignment2 {
    public static void main(String[] args) {
        Course[] c = new Course[4];
        c[0] = new Course("English", "Anny", 54, 3);
        c[1] = new Course("Chinese", "中华", 54, 4);
        c[2] = new Course("Math", "Jane", 54, 5);
        c[3] = new Course("Music", false, "Rinky", 36, 2);
        System.out.println("1.添加课程\n2.修改课程\n3.删除课程\n4.查询课程\n0.退出程序\n请输入0-4：");
        Scanner sc = new Scanner(System.in);
        while (true) {
            int a = sc.nextInt();
            switch (a) {
                case 0:
                    System.exit(0);
                case 1: {
                    c[0].add(c);
                    break;
                }
                case 2:
                case 3:
                case 4: {
                    c[0].query(c);
                    break;
                }

            }
        }
    }
}

class Course {
    String name = null;
    boolean isMust = true;
    String teacher = null;
    int period = 0;
    float credit = 0;

    public Course(String name, boolean isMust, String teacher, int period, float credit) {
        this.name = name;
        this.isMust = isMust;
        this.teacher = teacher;
        this.period = period;
        this.credit = credit;
    }

    public Course(String name, String teacher, int period, float credit) {
        this.name = name;
        this.teacher = teacher;
        this.period = period;
        this.credit = credit;
    }

    public Course() {
    }


    public void creat(String name, boolean isMust, String teacher, int period, float credit) {
        this.name = name;
        this.isMust = isMust;
        this.teacher = teacher;
        this.period = period;
        this.credit = credit;
    }

    public void creat(String name, String teacher, int period, float credit) {
        this.name = name;
        this.teacher = teacher;
        this.period = period;
        this.credit = credit;
    }

    public void add(Course[] c) {
        Arrays.copyOf(c, c.length + 1);
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入课程名称：");
        c[c.length - 1].name = sc.next();
        System.out.println("请输入课程性质：");
        c[c.length - 1].isMust = sc.nextBoolean();
        System.out.println("请输入课程教师：");
        c[c.length - 1].teacher = sc.next();
        System.out.println("请输入课程学时：");
        c[c.length - 1].period = sc.nextInt();
        System.out.println("请输入课程学分：");
        c[c.length - 1].credit = sc.nextInt();
    }

    public void query(Course[] c) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.按课程名称查询\n2.按课程性质查询\n3.按课程教师查询\n0.返回上级\n请输入0-3：");
        while (true) {
            switch (sc.nextInt()) {
                case 0:
                    break;
                case 1: {
                    System.out.println("请输入课程名称：");
                    String s = sc.next();
                    int flag = 0;
                    for (int i = 0; i < c.length; i++) {
                        if (c[i].name.equals(s)) {
                            System.out.println("课程信息：" + c[i].name + "\t" + c[i].isMust + "\t" + c[i].teacher + "\t" + c[i].period + "\t" + c[i].credit);
                            flag = 1;
                        }
                    }
                    if (flag == 0) System.out.println("无该课程\n");
                    System.out.println("请输入0-3：");
                    break;
                }
                case 2: {
                    System.out.println("请输入查询课程性质：");
                    boolean b = sc.nextBoolean();
                    int flag = 0;
                    for (int i = 0; i < c.length; i++) {
                        if (c[i].isMust == b) {
                            System.out.println("课程信息：" + c[i].name + "\t" + c[i].isMust + "\t" + c[i].teacher + "\t" + c[i].period + "\t" + c[i].credit);
                            flag = 1;
                        }
                    }
                    if (flag == 0) System.out.println("无该性质课程\n");
                    System.out.println("请输入0-3：");
                    break;
                }
                case 3: {
                    System.out.println("请输入查询课程教师：");
                    String s = sc.next();
                    int flag = 0;
                    for (int i = 0; i < c.length; i++) {
                        if (c[i].teacher.equals(s)) {
                            System.out.println("课程信息：" + c[i].name + "\t" + c[i].isMust + "\t" + c[i].teacher + "\t" + c[i].period + "\t" + c[i].credit);
                            flag = 1;
                        }
                    }
                    if (flag == 0) System.out.println("无该教师课程\n");
                    System.out.println("请输入0-3：");
                    break;
                }
            }
        }
    }
}