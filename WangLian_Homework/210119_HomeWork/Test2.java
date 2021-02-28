/*
 * 通过运用对象数组（作业二）/利用Vector（作业三）以及类的知识完成如下课程管理系统功能：
 * 课程管理每学期都要开设多门课程，每门课程的信息包括课程名称（String）、是否是必修课(boolean)、授课教师（String）、学时(int)、学分(float)；
 * 编程实现对课程信息进行创建、添加、删除、修改和查询操作；
 * 可以按课程名、是否是必修课、授课教师来进行查询；
 * 修改或删除之前要先查询； */

/*对象数组实现*/
package HomeWork1;
import  java.util.Scanner;
public class Test2 {
    public static void main(String args[]){
        System.out.println("菜单");
        System.out.println("1.创建");
        System.out.println("2.添加");
        System.out.println("3.删除");
        System.out.println("4.修改");
        System.out.println("5.查询");
        System.out.println("请选择:");
        Scanner sc  = new Scanner(System.in);
        int choose = sc.nextInt();
        Course course1 = new Course();
        switch (choose){
            case 1 :
                course1.create();
                break;
            case 2 :
                course1.addCourse();
                break;
            case 3:
                course1.removeCourse();
                break;
            case 4:
                course1.alterCourse();
                break;
            case 5:
                course1.findCourse();
                break;
            default:
                System.out.println("出错了!");


        }


    }
}
class Course{
    String coursename;
    boolean isChoose;
    String treacher;
    Course[] course = new Course[66];
    int count = 0 ;//便于在后期查找过程中定位
    int time;
    float score;
    public Course(String coursename,boolean isChoose,String treacher,int time,float score){
        this.coursename = coursename;
        this.isChoose = isChoose;
        this.treacher = treacher;
        this.time = time;
        this.score = score;
    }
    public Course(){

    }

    //创建
    public void create(){
        //分别创建不同的数组来存放
        //总课程数
        System.out.println("请输入要创建的课程数目：");
        Scanner sc = new Scanner(System.in);
        int courseNumber = sc.nextInt();
        for(int i =0 ;i<courseNumber;i++){
            System.out.println("请输入课程名称，是否选修课（true or false），授课教师，课时，学分（以空格隔开）");
            course[i].coursename = sc.next();
            course[i].isChoose = sc.nextBoolean();
            course[i].treacher = sc.next();
            course[i].time = sc.nextInt();
            course[i].score = sc.nextFloat();
            count++;

        }
       sc.close();


    }
    //添加
    public void addCourse(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入课程名称，是否选修课（true or false），授课教师，课时，学分");
        Course course2 = new Course();
        course2.coursename = sc.next();
        course2.isChoose = sc.nextBoolean();
        course2.treacher = sc.next();
        course2.time = sc.nextInt();
        course2.score = sc.nextFloat();
        course[count++] = course2;

        sc.close();

    }
    //修改前需要查询
    public void alterCourse(){
        int seachnumber = findCourse();
        Scanner sc = new Scanner(System.in);
        Course course2 = new Course();
        course2.coursename = sc.next();
        course2.isChoose = sc.nextBoolean();
        course2.treacher = sc.next();
        course2.time = sc.nextInt();
        course2.score = sc.nextFloat();
        course[seachnumber] = course2;


    }


    //查找按照课程名，老师和是否必修课
    public int findCourse(){
        System.out.println("请输入你要查询的类别（课程名/授课老师/是否必修课/课时/学分");
        Scanner sc  = new Scanner(System.in);
        String searchCategory = sc.next();
        switch (searchCategory){
            case "课程名":
                System.out.println("请输入要查询课程名称：");
                String searchname = sc.next();
                int i = 0;
                for(;i<count;i++){
                    if(searchname.equals(course[i].coursename)){
                        return i;
                    }

                }
                if(i== count){
                    System.out.println("没有找到!");
                    return 0;
                }
                break;
            case"授课老师":
                System.out.println("请输入要查授课老师：");
                String searchteacher = sc.next();
                i = 0;
                for(;i<count;i++){
                    if(searchteacher.equals(course[i].treacher)){
                        return i;
                    }

                }
                if(i== count){
                    System.out.println("没有找到!");
                    return 0;
                }
                break;
            case"是否必修课":
                System.out.println("请输入要查授课老师：");
                Boolean searchischoose = sc.nextBoolean();
                i = 0;
                for(;i<count;i++){
                    if(searchischoose.equals(course[i].isChoose)){
                        return i;
                    }

                }
                if(i== count){
                    System.out.println("没有找到!");
                    return 0;
                }
                break;
            default:
                return 0;
        }

    return 0;
    }
    //删除前查询
    public void removeCourse() {
        int seachnumber = findCourse();
        for(int i =seachnumber;i<count;i++){
            course[i]=course[i++];
        }
    }


}
