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
                    c = c[0].add(c);
                    System.out.println("1.添加课程\n2.修改课程\n3.删除课程\n4.查询课程\n0.退出程序\n请输入0-4：");
                    break;
                }
                case 2: {
                    c[0].update(c);
                    System.out.println("1.添加课程\n2.修改课程\n3.删除课程\n4.查询课程\n0.退出程序\n请输入0-4：");
                    break;
                }
                case 3: {
                    c = c[0].delete(c);
                    System.out.println("1.添加课程\n2.修改课程\n3.删除课程\n4.查询课程\n0.退出程序\n请输入0-4：");
                    break;
                }
                case 4: {
                    c[0].query(c);
                    System.out.println("1.添加课程\n2.修改课程\n3.删除课程\n4.查询课程\n0.退出程序\n请输入0-4：");
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

    public Course[] add(Course[] c) {
        Course[] cs = c;
        while (true) {
            Course[] c0 = (Course[]) cs.clone();
            cs = (Course[]) Arrays.copyOf(c0, c0.length + 1);
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入课程名称：");
            cs[cs.length - 1] = new Course();
            cs[cs.length - 1].name = sc.next();
            System.out.println("请输入课程性质：");
            cs[cs.length - 1].isMust = sc.nextBoolean();
            System.out.println("请输入课程教师：");
            cs[cs.length - 1].teacher = sc.next();
            System.out.println("请输入课程学时：");
            cs[cs.length - 1].period = sc.nextInt();
            System.out.println("请输入课程学分：");
            cs[cs.length - 1].credit = sc.nextInt();
            System.out.println("是否继续添加：1.是\t0.否");
            if (sc.nextInt() == 0)
                return cs;
        }
    }

    public void query(Course[] c) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.按课程名称查询\n2.按课程性质查询\n3.按课程教师查询\n0.返回上级\n请输入0-3：");
        boolean tree = true;
        while (tree) {
            switch (sc.nextInt()) {
                case 0:
                    tree = false;
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
                    System.out.println("1.按课程名称查询\n2.按课程性质查询\n3.按课程教师查询\n0.返回上级\n请输入0-3：");
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

    public Course[] delete(Course[] c) {
        Course[] cs = c;
        while (true) {
            System.out.println("请输入要删除的课程：");
            Scanner sc = new Scanner(System.in);
            String s = sc.next();
            int flag = 0;
            Course[] c0 = cs;
            for (int i = 0; i < c0.length; i++) {
                if (c0[i].name.equals(s)) {
                    for (int j = i; j < c0.length - 1; j++) {
                        c0[j] = c0[j + 1];
                    }
                    flag = 1;
                }
            }
            cs = new Course[c0.length - 1];
            for (int i = 0; i < cs.length; i++) {
                cs[i] = c0[i];
            }
            if (flag == 0)
                System.out.println("无该课程！");
            System.out.println("是否继续删除：1.是\t0.否");
            if (sc.nextInt() == 0)
                return cs;
        }
    }

    public void update(Course[] c) {
        while (true) {
            System.out.println("请输入需要修改的课程:");
            Scanner sc = new Scanner(System.in);
            String s = sc.next();
            int flag = 0;
            for (int i = 0; i < c.length; i++) {
                if (c[i].name.equals(s)) {
                    System.out.println("请依次输入修改后的课程信息：");
                    c[i].name = sc.next();
                    c[i].isMust = sc.nextBoolean();
                    c[i].teacher = sc.next();
                    c[i].period = sc.nextInt();
                    c[i].credit = sc.nextInt();
                    flag = 1;
                }
            }
            if (flag == 0)
                System.out.println("无该课程！");
            System.out.println("是否继续修改：1.是\t0.否");
            if (sc.nextInt() == 0) break;
        }
    }

}