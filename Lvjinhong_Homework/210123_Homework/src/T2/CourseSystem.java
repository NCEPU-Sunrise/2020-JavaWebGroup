//作业2:对象数组完成课程管理系统功能
package T2;

import java.util.Scanner;
import java.util.Vector;

public class CourseSystem {
    public static void main(String[] args) {
        Course c1 = new Course("游戏设计", false, "Mr.Game", 24, 4);
        Course c2 = new Course("java", true, "Mr.Java", 24, 4);
        Course c3 = new Course("C", true, "Mr.C", 24, 4);

        Vector<Course> courses = new Vector<>();
        courses.add(c1);
        courses.add(c2);
        courses.add(c3);

        Course Courses[] = new Course[10];
        Courses[0] = c1;
        Courses[1] = c2;
        Courses[2] = c3;

        System.out.println("Welcome to the Course information management system!");
        //boolean flag = true;
        while (true){
            Scanner sc = new Scanner(System.in);
            char c = ' ';
            String s;
            //反复询问至输入合法
            while(c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6'){
                System.out.println("--------------------------------------");
                System.out.println("输入你需要进行的功能：");
                System.out.println("1:创建;2:添加;3:删除;4:修改;5:查询;6:退出");
                c = sc.nextLine().charAt(0);
            }

            //执行对应功能
            if (c == '1'){
                //创建
                //原数组清空
                for(int i = 0;i < Courses.length;i++){
                    Courses[i] = null;
                }
                courses.clear();
                //录入
                System.out.println("输入一门课程的信息(格式:课程名称,是否是必修课,授课教师,学时,学分)");

                s = sc.nextLine();
                String []buff = s.split(",");

                courses.add(new Course());
                //设置课程信息
                courses.get(0).setCname(buff[0]);
                if(buff[1].toUpperCase().charAt(0) == 'T')courses.get(0).setCompulsory(true);
                else Courses[0].setCompulsory(false);
                courses.get(0).setTname(buff[2]);
                courses.get(0).setHours(Integer.parseInt(buff[3]));
                courses.get(0).setCredit(Float.parseFloat(buff[4]));
            }else if( c == '2'){
                //添加

                //录入
                System.out.println("输入一门课程的信息(格式:课程名称,是否是必修课,授课教师,学时,学分)");

                s = sc.nextLine();
                String []buff = s.split(",");


                courses.add(new Course());
                //设置课程信息
                courses.get(courses.size() - 1).setCname(buff[0]);
                if(buff[1].toUpperCase().charAt(0) == 'T')courses.get(courses.size() - 1).setCompulsory(true);
                else courses.get(courses.size() - 1).setCompulsory(false);
                courses.get(courses.size() - 1).setTname(buff[2]);
                courses.get(courses.size() - 1).setHours(Integer.parseInt(buff[3]));
                courses.get(courses.size() - 1).setCredit(Float.parseFloat(buff[4]));
            }else if( c == '3'){
                //删除
                //先遍历查询
                //遍历打印
                int count = 0;
                for (Course citer:courses
                ) {
                    System.out.println(count + "--" + citer.infoPrint());
                    count ++;
                }
                //删除
                System.out.println("--------------------------------------");
                System.out.println("输入你需要删除的信息索引(格式:index1[,index2,...])");
                s = sc.nextLine();
                String []buff = s.split(",");
                for(int i = 0;i < buff.length;i++){
                    courses.removeElementAt(Integer.parseInt(buff[i]));
                }
            }else if( c == '4'){
                //修改
                //先遍历查询
                //遍历打印
                int count = 0;
                for (Course citer:courses
                ) {
                    System.out.println(count + "--" + citer.infoPrint());
                    count ++;
                }
                //修改
                System.out.println("--------------------------------------");
                System.out.println("输入你需要修改的信息索引(格式:index");
                c = sc.nextLine().charAt(0);
                System.out.println("输入一门课程的信息(格式:课程名称,是否是必修课,授课教师,学时,学分)");
                s = sc.nextLine();
                String []buff = s.split(",");
                int index = (int)c - 48;

                //设置课程信息
                courses.get(index).setCname(buff[0]);
                if(buff[1].toUpperCase().charAt(0) == 'T')courses.get(index).setCompulsory(true);
                else courses.get(index).setCompulsory(false);
                courses.get(index).setTname(buff[2]);
                courses.get(index).setHours(Integer.parseInt(buff[3]));
                courses.get(index).setCredit(Float.parseFloat(buff[4]));
            }else if( c == '5'){
                //查询
                //选择查询依据:课程名/必修课/授课教师
                c = ' ';
                //反复询问至输入合法
                while(c != '1' && c != '2' && c != '3' && c != '4'){
                    System.out.println("--------------------------------------");
                    System.out.println("输入你需要进行的查询的条件：");
                    System.out.println("1:课程名;2:是否必修课;3:授课教师;4:全部");
                    c = sc.nextLine().charAt(0);
                }
                System.out.println("--------------------------------------");
                //根据输入执行相应操作
                if(c == '1'){
                    System.out.println("输入你需要查询的课程名:");
                    s = sc.nextLine();

                    int count = 0;
                    for (Course citer:courses
                         ) {
                        if(citer.getCname().equals(s)) System.out.println(count + "--" + citer.infoPrint());
                        count ++;
                    }
                }else if(c == '2'){
                    System.out.println("输入你需要查询的是否必修(t/f)");
                    s = sc.nextLine();boolean b;
                    if(s.toUpperCase().charAt(0) == 'T')b = true;else b = false;

                    int count = 0;
                    for (Course citer:courses
                    ) {
                        if(citer.getCompulsory() == b) System.out.println(count + "--" + citer.infoPrint());
                        count ++;
                    }
                }else if(c == '3'){
                    System.out.println("输入你需要查询的授课教师");
                    s = sc.nextLine();

                    int count = 0;
                    for (Course citer:courses
                    ) {
                        if(citer.getTname().equals(s)) System.out.println(count + "--" + citer.infoPrint());
                        count ++;
                    }
                }else if(c == '4'){
                    //遍历打印
                    int count = 0;
                    for (Course citer:courses
                    ) {
                        System.out.println(count + "--" + citer.infoPrint());
                        count ++;
                    }
                }
            }else if (c == '6'){
                //退出
                System.exit(0);
            }
        }
    }
}
