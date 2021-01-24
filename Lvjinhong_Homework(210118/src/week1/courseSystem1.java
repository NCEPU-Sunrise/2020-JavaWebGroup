//作业2:对象数组完成课程管理系统功能
package week1;

import java.util.Scanner;

public class courseSystem1 {
    public static void main(String[] args) {
        course c1 = new course("游戏设计", false, "Mr.Game", 24, 4);
        course c2 = new course("java", true, "Mr.Java", 24, 4);
        course c3 = new course("C", true, "Mr.C", 24, 4);

        course Courses[] = new course[10];
        Courses[0] = c1;
        Courses[1] = c2;
        Courses[2] = c3;

        System.out.println("Welcome to the course information management system!");
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
                //录入
                System.out.println("输入一门课程的信息(格式:课程名称,是否是必修课,授课教师,学时,学分)");

                s = sc.nextLine();
                String []buff = s.split(",");

                Courses[0] = new course();
                Courses[0].setCname(buff[0]);
                if(buff[1].toUpperCase().charAt(0) == 'T')Courses[0].setCompulsory(true);
                else Courses[0].setCompulsory(false);
                Courses[0].setTname(buff[2]);
                Courses[0].setHours(Integer.parseInt(buff[3]));
                Courses[0].setCredit(Float.parseFloat(buff[4]));
            }else if( c == '2'){
                //添加
                //计算第一个null元素的索引
                int index = -1;
                while(Courses[++index] != null);
                //录入
                System.out.println("输入一门课程的信息(格式:课程名称,是否是必修课,授课教师,学时,学分)");

                s = sc.nextLine();
                String []buff = s.split(",");

                Courses[index] = new course();
                Courses[index].setCname(buff[0]);
                if(buff[index].toUpperCase().charAt(0) == 'T')Courses[0].setCompulsory(true);
                else Courses[index].setCompulsory(false);
                Courses[index].setTname(buff[2]);
                Courses[index].setHours(Integer.parseInt(buff[3]));
                Courses[index].setCredit(Float.parseFloat(buff[4]));
            }else if( c == '3'){
                //删除
                //先遍历查询
                //遍历打印
                for(int i = 0;i < indexCal(Courses);i++){
                    System.out.println(i + "--" + Courses[i].infoPrint());
                }
                //删除
                System.out.println("--------------------------------------");
                System.out.println("输入你需要删除的信息索引(格式:index1[,index2,...])");
                s = sc.nextLine();
                String []buff = s.split(",");
                for(int i = 0;i < buff.length;i++){
                    arrayDelete(Courses, Integer.parseInt(buff[i]));
                }
            }else if( c == '4'){
                //修改
                //先遍历查询
                //遍历打印
                for(int i = 0;i < indexCal(Courses);i++){
                    System.out.println(i + "--" + Courses[i].infoPrint());
                }
                //修改
                System.out.println("--------------------------------------");
                System.out.println("输入你需要删除的信息索引(格式:index");
                c = sc.nextLine().charAt(0);
                System.out.println("输入一门课程的信息(格式:课程名称,是否是必修课,授课教师,学时,学分)");
                s = sc.nextLine();
                String []buff = s.split(",");
                int index = (int)c - 48;
                Courses[index] = new course();
                Courses[index].setCname(buff[0]);
                if(buff[index].toUpperCase().charAt(0) == 'T')Courses[0].setCompulsory(true);
                else Courses[index].setCompulsory(false);
                Courses[index].setTname(buff[2]);
                Courses[index].setHours(Integer.parseInt(buff[3]));
                Courses[index].setCredit(Float.parseFloat(buff[4]));
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
                    for(int i = 0;i < indexCal(Courses);i++){
                       if(Courses[i].getCname().equals(s)) System.out.println(i + "--" + Courses[i].infoPrint());
                    }
                }else if(c == '2'){
                    System.out.println("输入你需要查询的是否必修(t/f)");
                    s = sc.nextLine();boolean b;
                    if(s.toUpperCase().charAt(0) == 'T')b = true;else b = false;
                    for(int i = 0;i < indexCal(Courses);i++){
                        if(Courses[i].getCompulsory() == b) System.out.println(i + "--" + Courses[i].infoPrint());
                    }
                }else if(c == '3'){
                    System.out.println("输入你需要查询的授课教师");
                    s = sc.nextLine();
                    for(int i = 0;i < indexCal(Courses);i++){
                        if(Courses[i].getTname().equals(s)) System.out.println(i + "--" + Courses[i].infoPrint());
                    }
                }else if(c == '4'){
                    //遍历打印
                    for(int i = 0;i < indexCal(Courses);i++){
                        System.out.println(i + "--"+ Courses[i].infoPrint());
                    }
                }
            }else if (c == '6'){
                //退出
                System.exit(0);
            }
        }
    }
    //计算第一个null元素的索引
    public static int indexCal(Object o[]){
        int index = -1;
        while(o[++index] != null);
        return index;
    }
    //数组删除
    public static void arrayDelete(Object o[],int index){
        //越界判断
        if(index == -1 || index >= o.length)return;
        //删除
        o[index] = null;
        //位置左移
        for(int i = index;i < o.length - 1;i++){
            o[i] = o[i+1];
        }
        o[o.length - 1] = null;
    }
}
