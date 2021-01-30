import java.util.Scanner;

class  Courses{
    String name;
    boolean necessary;
    String teacher;
    int time;
    float credit;
    Courses(String name,boolean necessary,String teacher,int time,float credit){
        this.name = name;
        this.necessary = necessary;
        this.teacher = teacher;
        this.time = time;
        this.credit = credit;
    }

}
class Demo2 {
    static int numlesson = 9;
    static Courses[] courses = new Courses[100];
    public static void main(String[] args) {
        courses[0] = new Courses("高等数学", true, "彭武安", 56, 5);
        courses[1] = new Courses("工程制图", true, "李红", 32, 3.5f);
        courses[2] = new Courses("大学物理", true, "李克强", 56, 3.5f);
        courses[3] = new Courses("电路理论基础", true, "李渤龙", 84, 4f);
        courses[4] = new Courses("离散数学", true, "胡海涛", 48, 4f);
        courses[5] = new Courses("面向对象程序设计", true, "彭文", 32, 3.5f);
        courses[6] = new Courses("C语言", true, "谢萍", 32, 3.5f);
        courses[7] = new Courses("毛泽东思想与中国特色社会主义概论", true, "王旭琰", 48, 5f);
        courses[8] = new Courses("电影音乐赏析", false, "邹琳", 32, 2f);
        courses[9] = new Courses("舞蹈形体", false, "王悦", 48, 2f);
        boolean wflag =true;
        while(wflag) {
            System.out.println("欢迎进入课程管理系统:）");
            System.out.println("请选择功能（序号）：");
            System.out.println("[1] 创建课程");
            System.out.println("[2] 添加课程");
            System.out.println("[3] 删除课程");
            System.out.println("[4] 修改课程");
            System.out.println("[5] 查询课程");
            System.out.println("[6] 输出全部课程信息");
            System.out.println("[7] 退出程序");
            System.out.println("**********************");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6
                    && choice != 7 && choice != 8) {
                System.out.println("输入无效，请重新输入！");
                choice = sc.nextInt();
            }
            switch (choice) {
                case 1:
                    add_lesson();
                    break;
                case 2:
                    System.out.println("有一说一，没怎么看懂创建课程和添加课程有什么区别~");
                    break;
                case 3:
                    delete_lesson();
                    break;
                case 4:
                    modify_lesson();
                    break;
                case 5:
                    search_lesson();
                    break;
                case 6:
                    System.out.println("所有课程信息如下：");
                    for (int i = 0; i < numlesson + 1; i++) {
                        System.out.println(courses[i].name + "   是否必修: " + courses[i].necessary + "   学时：" + courses[i].time
                                + "   学分：" + courses[i].credit);
                    }
                    System.out.println("按任意键+回车返回上级菜单....");
                    sc.next();
                    break;
                case 7:
                    System.out.println("确认退出？(yes or no)");
                    String str = sc.next();
                    while (!str.equals("yes") && !str.equals("Yes") && !str.equals("no") && !str.equals("No")) {
                        System.out.println("输入无效，请重新输入！");
                        str = sc.next();
                    }
                    if (str.equals("Yes") || str.equals("yes")) {
                        wflag = false;
                        System.out.println("已退出，欢迎下次使用！");
                        System.exit(0);

                    }
            }
        }


    }

    public static void add_lesson() {
        boolean aflag = true;
        Scanner sc1 = new Scanner(System.in);
        while (aflag) {
            System.out.println("请输入要创建的课程名称：");
            String newname = sc1.next();
            System.out.println("是否为必修?(true or false)");
            boolean newnecessary = sc1.nextBoolean();
            System.out.println("请输入授课老师：");
            String newteacher = sc1.next();
            System.out.println("请输入课程学时：");
            int newtime = sc1.nextInt();
            System.out.println("请输入课程学分：");
            float newcredit = sc1.nextFloat();
            numlesson += 1;
            courses[numlesson] = new Courses(newname, newnecessary, newteacher, newtime, newcredit);
            System.out.println("是否继续创建？(yes or no)");
            String str = sc1.next();
            while (!str.equals("yes") && !str.equals("Yes") && !str.equals("no") && !str.equals("No")) {
                System.out.println("输入无效，请重新输入！");
                str = sc1.next();
            }
            if (str.equals("no") || str.equals("No"))
                aflag = false;
        }
        aflag = true;
    }

    public static void delete_lesson() {
        Scanner sc2 = new Scanner(System.in);
        String dname;
        int i, j;
        boolean dflag = true;
        while (dflag) {
            System.out.println("请输入要删除课程的名称：");
            dname = sc2.nextLine();
            for (i = 0; i < numlesson + 1; i++) {
                if (courses[i].name.equals(dname) == true) {
                    for (j = i; j < numlesson; j++) {
                        courses[j] = courses[j + 1];
                    }
                    numlesson -= 1;
                    break;
                }
            }
            if (i >= numlesson + 1)
                System.out.println("未找到相关课程，请检查课程名称是否输入正确！");
            else
                System.out.println("删除成功！");
            System.out.println("是否继续删除？(yes or no)");
            String str = sc2.next();
            while (!str.equals("yes") && !str.equals("Yes") && !str.equals("no") && !str.equals("No")) {
                System.out.println("输入无效，请重新输入！");
                str = sc2.next();
            }
            if (str.equals("no") || str.equals("No"))
                dflag = false;
        }
        dflag = true;
    }

    public static void modify_lesson() {
        Scanner sc3 = new Scanner(System.in);
        String mname, mteacher, name0;
        int mtime;
        int i, index = 0;
        float mcredit;
        boolean mnecessary, mflag = true;
        int mchoice;
        while (mflag) {
            System.out.println("请输入要修改的课程名称：");
            name0 = sc3.nextLine();
            for (i = 0; i < numlesson + 1; i++) {
                if (courses[i].name.equals(name0) == true) {
                    index = i;
                    System.out.println("请选择要修改的信息：");
                    System.out.println("[1] 课程名称");
                    System.out.println("[2] 课程性质");
                    System.out.println("[3] 授课教师");
                    System.out.println("[4] 修改学时");
                    System.out.println("[5] 修改学分");
                    mchoice = sc3.nextInt();
                    switch (mchoice) {
                        case 1:
                            System.out.println("请输入课程名称：");
                            mname = sc3.nextLine();
                            courses[index].name = mname;
                            System.out.println("修改成功！");
                            break;
                        case 2:
                            System.out.println("请输入课程性质：(true or false)");
                            mnecessary = sc3.nextBoolean();
                            courses[index].necessary = mnecessary;
                            System.out.println("修改成功！");
                            break;
                        case 3:
                            System.out.println("请输入授课老师：");
                            mteacher = sc3.nextLine();
                            courses[index].teacher = mteacher;
                            System.out.println("修改成功！");
                            break;
                        case 4:
                            System.out.println("请输入学时：");
                            mtime = sc3.nextInt();
                            courses[index].time = mtime;
                            System.out.println("修改成功！");
                            break;
                        case 5:
                            System.out.println("请输入学分：");
                            mcredit = sc3.nextFloat();
                            courses[index].credit = mcredit;
                            System.out.println("修改成功！");
                            break;
                    }
                    break;
                }
            }
            if (i == numlesson + 1)
                System.out.println("该课程不存在！请检查课程名称是否输入正确");
            System.out.println("是否继续修改？(yes or no)");
            String str = sc3.next();
            while (!str.equals("yes") && !str.equals("Yes") && !str.equals("no") && !str.equals("No")) {
                System.out.println("输入无效，请重新输入！");
                str = sc3.next();
            }
            if (str.equals("no") || str.equals("No"))
                mflag = false;
        }
        mflag = true;
    }

    public static void search_lesson() {
        Scanner sc4 = new Scanner(System.in);
        int schoice, i;
        String sname, steacher;
        boolean snecessary;
        boolean dflag = true;
        while (dflag) {
            System.out.println("请选择要查询的信息：");
            System.out.println("[1] 按课程名称查询");
            System.out.println("[2] 按课程性质查询");
            System.out.println("[3] 按授课教师查询");
            schoice = sc4.nextInt();
            switch (schoice) {
                case 1:
                    System.out.println("请输入课程名称：");
                    sname = sc4.next();
                    for (i = 0; i < numlesson + 1; i++) {
                        if (courses[i].name.equals(sname) == true) {
                            System.out.println("查询信息如下：");
                            System.out.println(courses[i].name + "   是否必修: " + courses[i].necessary + "   学时：" + courses[i].time
                                    + "   学分：" + courses[i].credit);
                            break;
                        }
                    }
                    if (i == numlesson + 1)
                        System.out.println("该课程不存在！请检查课程名称是否输入正确");
                    break;
                case 2:
                    System.out.println("请输入课程性质：");
                    snecessary = sc4.nextBoolean();
                    for (i = 0; i < numlesson + 1; i++) {
                        if (courses[i].necessary == snecessary) {
                            System.out.println("查询信息如下：");
                            System.out.println(courses[i].name + "   是否必修: " + courses[i].necessary + "   学时：" + courses[i].time
                                    + "   学分：" + courses[i].credit);
                        }
                    }
                    break;
                case 3:
                    System.out.println("请输入授课教师：");
                    steacher = sc4.nextLine();
                    int flag = 0;
                    for (i = 0; i < numlesson + 1; i++) {
                        if (courses[i].name.equals(steacher) == true) {
                            flag = 1;
                            System.out.println("查询信息如下：");
                            System.out.println(courses[i].name + "   是否必修: " + courses[i].necessary + "   学时：" + courses[i].time
                                    + "   学分：" + courses[i].credit);
                        }
                    }
                    if (flag == 0)
                        System.out.println("该老师不存在！请检授课老师是否输入正确");
                    break;

            }
            System.out.println("是否继续查询？(yes or no)");
            String str = sc4.next();
            while (!str.equals("yes") && !str.equals("Yes") && !str.equals("no") && !str.equals("No")) {
                System.out.println("输入无效，请重新输入！");
                str = sc4.next();
            }
            if (str.equals("no") || str.equals("No"))
                dflag = false;
        }
        dflag = true;
    }
}
